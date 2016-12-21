// Inclui os arquivos necessarios para compilar o projeto.
#include <Arduino.h>
#include <SoftwareSerial.h>
//#include "BufferCircular.cpp"
#include "PacoteBPM.h"
#include "PacoteConfirmacao.h"
#include "virtuabotixRTC.h"

// ------------------------------------------------------

#include <SoftwareSerial.h>

SoftwareSerial bluetoothSerial(10, 11); // RX, TX

String x = "";
uint8_t buf[256] = {0};

// ------------------------------------------------------

//Pulse sensor
// ------------------------------------------------------
//  Variables
int pulsePin = 0;                 // Pulse Sensor purple wire connected to analog pin 0
int blinkPin = 13;                // pin to blink led at each beat
int fadePin = 5;                  // pin to do fancy classy fading blink at each beat
int fadeRate = 0;                 // used to fade LED on with PWM on fadePin

// Volatile Variables, used in the interrupt service routine!
volatile int BPM;                   // int that holds raw Analog in 0. updated every 2mS
volatile int Signal;                // holds the incoming raw data
volatile int IBI = 600;             // int that holds the time interval between beats! Must be seeded!
volatile boolean Pulse = false;     // "True" when User's live heartbeat is detected. "False" when not a "live beat".
volatile boolean QS = false;        // becomes true when Arduoino finds a beat.

// ------------------------------------------------------

// Possiveis estados da maquina de estados.
typedef enum {
	ESTADO_ENVIANDO,
	ESTADO_ESPERANDOCONFIRMACAO,
	ESTADO_MEDINDO, // Default.
} Estado;

// Estado atual da maquina de estados.
Estado estadoAtual;

// Inicializa o buffer circular com SIZE = 100.
//BufferCircular<PacoteBPM> bufferCircular();

// Inicializa os pacotes (BPM e Confirmacao).
PacoteBPM pacoteBPM(0, 0, 0, 0, 0, 0, 0, 0);
PacoteConfirmacao pacoteConfirmacao(0, 0);

// Variaveis auxiliares
boolean mediu; // Flag para indicar se o sensor obteu a frequencia cardiaca.
boolean adicionouNoBuffer; // Flag para indicar se o pacote foi adicionado no buffer.
boolean confirmacao; // Flag para indicar se o app recebeu o pacote.

int contadorID = 0;

virtuabotixRTC myRTC(6, 7, 8);

void setup() {

	estadoAtual = ESTADO_MEDINDO; // Inicia no estado de medicao.
	mediu = false;
	adicionouNoBuffer = false;
	confirmacao = false;

	pacoteBPM._id = 0;
	pacoteBPM._dia = 0;
	pacoteBPM._mes = 0;
	pacoteBPM._ano = 0;
	pacoteBPM._hora = 0;
	pacoteBPM._minuto = 0;
	pacoteBPM._seg = 0;
	pacoteBPM._bpm = 0;

	pacoteConfirmacao._id = 0;
	pacoteConfirmacao._codigo = 0; // 0 = ok e 1 = erro.

	myRTC.setDS1302Time(30, 02, 10, 3, 20, 12, 2016); // (segundos, minutos, hora, dia da semana, dia do mes, mes, ano)

	Serial.begin(115200); // Serial para o sensor de pulso.

	// ------------------------------------------------------ Serial para receber dados do app ou enviar.
	Serial.begin(9600);
	bluetoothSerial.begin(9600);
	// ------------------------------------------------------

	interruptSetup();
}


void loop() {
	switch (estadoAtual) {

	case ESTADO_ENVIANDO: // Enviando o pacote de informacoes para o app.
	{

		Serial.println("ESTADO_ENVIANDO");

		if (adicionouNoBuffer == true) {
			//LER DO BUFFER CIRCULAR
			//PacoteBPM p = bufferCircular.read();

			if(Serial.available()){
				//memcpy(buf, &pacoteBPM, sizeof(PacoteBPM));
				bluetoothSerial.write((uint8_t*)&pacoteBPM, sizeof(PacoteBPM));

			}
			adicionouNoBuffer = false;
			estadoAtual = ESTADO_ESPERANDOCONFIRMACAO;

		} else {
			estadoAtual = ESTADO_MEDINDO;
		}
		break;
	}

	case ESTADO_ESPERANDOCONFIRMACAO: // Recebendo confirmacao de que o pacote de informacoes foi entregue com sucesso e limpando o buffer circular.
	{

		Serial.println("ESTADO_ESPERANDOCONFIRMACAO");

		if(bluetoothSerial.available() == 2){
			pacoteConfirmacao._id = bluetoothSerial.read();
			pacoteConfirmacao._codigo = bluetoothSerial.read();

			if(pacoteConfirmacao._codigo == 0){
				// Apaga o elemento da ultima posicao do buffer circular.
				estadoAtual = ESTADO_MEDINDO;
			}
		} else {
			estadoAtual = ESTADO_ENVIANDO;
		}
		break;
	}

	default:
	case ESTADO_MEDINDO: // Medindo a frequencia cardiaca.
	{

		medirFrequenciaCardiaca();

		Serial.println("ESTADO_MEDINDO");

		if (mediu == true) {
			mediu = false;
			estadoAtual =  ESTADO_ENVIANDO;
		} else {
			estadoAtual = ESTADO_MEDINDO;
		}
		break;
	}
	} // Fim do switch.
} //Fim do loop.

// Metodo que mede a frequencia cardiaca e adiciona no buffer circular.
void medirFrequenciaCardiaca() {
	long tempo = millis();
	const long tempoDeMedicao = 15000; // 15 segundos para ficar medindo a frequencia cardiaca.

	while (millis() - tempo <= tempoDeMedicao) {

	  if (QS == true){     // A Heartbeat Was Found
	                       // BPM and IBI have been Determined
	                       // Quantified Self "QS" true when arduino finds a heartbeat
	        fadeRate = 255;         // Makes the LED Fade Effect Happen
	                                // Set 'fadeRate' Variable to 255 to fade LED with pulse
	        pacoteBPM._bpm = BPM;
	        QS = false;                      // reset the Quantified Self flag for next time
	  }
	  delay(20);                             //  take a break


		pacoteBPM._id = contadorID;
		myRTC.updateTime();
		// Pega valores dados pelo RTC
		pacoteBPM._dia = myRTC.dayofmonth;
		pacoteBPM._mes = myRTC.month;
		pacoteBPM._ano = myRTC.year;  //year � int, mas pacoteBPM.ano � uint16_t. Tem algum problema?
		pacoteBPM._hora = myRTC.hours;
		pacoteBPM._minuto = myRTC.minutes;
		pacoteBPM._seg = myRTC.seconds;
		//pacoteBPM._bpm = BPM; // Valor dado pelo driver do sensor
		pacoteBPM._bpm = 93; //Teste

		delay(1);
	}
	mediu = true;
	// ESCREVE NO BUFFER CIRCULAR
	//bufferCircular.write(pacoteBPM);
	adicionouNoBuffer = true;
	contadorID++;
}
