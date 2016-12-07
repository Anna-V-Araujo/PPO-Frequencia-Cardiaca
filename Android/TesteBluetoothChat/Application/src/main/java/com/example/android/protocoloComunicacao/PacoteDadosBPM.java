package com.example.android.protocoloComunicacao;

/**
 * Created by Anna Vitória on 25/11/2016.
 */

public class PacoteDadosBPM {

    int id;
    int dia;
    int mes;
    int ano;
    int hora;
    int minuto;
    int segundo;
    int bpm; /*falta pesquisar os limites*/


    public PacoteDadosBPM(int id, int ano, int dia, int mes, int hora, int minuto, int segundo, int bpm) {
        this.id = id;
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.bpm = bpm;
    }

    public PacoteDadosBPM(){}


    //Encode tranforma o Pacote em bytes
    public byte[] encode(){

        int anoPt1 = ano/100;
        int anoPt2 = ano - (anoPt1*100);

        byte[] buffer = new byte[9];
        buffer[0] = (byte) id;
        buffer[1] = (byte) dia;
        buffer[2] = (byte) mes;
        buffer[3] = (byte) anoPt1;
        buffer[4] = (byte) anoPt2;
        buffer[5] = (byte) hora;
        buffer[6] = (byte) minuto;
        buffer[7] = (byte) segundo;
        buffer[8] = (byte) bpm;

        return buffer;

    }

    public byte[] encode(int id, int dia, int mes, int ano, int hora, int minuto, int segundo, int bpm){
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.bpm = bpm;

        return encode();
    }

    /* Atribuirá os valores do buffer a um Pacote de Dados vazio
    Chamar assim: PacoteDadosBPM pacote = new PacoteDadosBPM;
                  pacote.code(buffer);
     */
    public void decode(byte[] buffer){
        this.id = buffer[0];
        this.dia = buffer[1];
        this.mes = buffer[2];
        this.ano = buffer[3]*256 + buffer[4];
        this.hora = buffer[5];
        this.minuto = buffer[6];
        this.segundo = buffer[7];
        this.bpm = buffer[8];
    }


    public int validarPreenchimento(){
        if(id != 0 && dia != 0 && mes != 0 && ano != 0 && /*hora != 0 && minuto != 0 && segundo != 0 &&*/ bpm != 0){
            return 0;
        } else {
            return 1;
        }
    }

    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public int getBpm() {
        return bpm;
    }

    /*A alteração do tamanho da mensagem foi em BCService e a criação dos Pacotes de dados em BCFragment*/

}
