package ifpe.garanhuns.ppo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ifpe.garanhuns.ppo.protocoloComunicacao.PacoteDadosBPM;

/**
 * Created by Anna Vitória on 28/11/2016.
 */

public class PersistenciaTextoBinario {


    //Singleton
    private static PersistenciaTextoBinario instance;
    private PersistenciaTextoBinario(){}


    public static PersistenciaTextoBinario getInstance() {
        if(instance==null)
            instance = new PersistenciaTextoBinario();
        return instance;
    }

    File pacoteBPMPersist = new File("PacoteBPMPersistencia.bin" /*Nome do arquivo*/);
    FileOutputStream outputStream;
    FileInputStream inputStream;


    public void criarStream(){
        try{
            outputStream = new FileOutputStream(pacoteBPMPersist);
            inputStream = new FileInputStream((pacoteBPMPersist)); //Isso é a mesma coisa que FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE) ?
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void salvarNoArquivo(byte[] buffer) throws IOException {
        for (int i = 0; i >= buffer.length; i++){
            outputStream.write(buffer[i]);
        }
        outputStream.flush();
    }

    public LinkedList lerDoArquivo() throws IOException {
        LinkedList<PacoteDadosBPM> pacoteDadosBPMLinkedList = new LinkedList<>();

        int posicaoInicial = 0;
        int posicaoFinal = 8;

        if(inputStream.available() > 9){
           while (inputStream.read() != -1) {
               byte[] buffer = new byte[9];
               inputStream.read(buffer, posicaoInicial, posicaoFinal);
               PacoteDadosBPM pacote = new PacoteDadosBPM();
               pacote.decode(buffer);
               pacoteDadosBPMLinkedList.add(pacote);
               posicaoInicial = posicaoInicial + 9;
               posicaoFinal = posicaoFinal + 9;
           }
        }
        return pacoteDadosBPMLinkedList;
    }

    public void fecharStream() throws IOException {
        inputStream.close();
        outputStream.close();
    }

}
