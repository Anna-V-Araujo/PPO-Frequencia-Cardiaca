package com.example.android.protocoloComunicacao;

/**
 * Created by Anna Vitória on 25/11/2016.
 */

public class PacoteConfirmacao {

    int id;
    int codigo; // Referência confirmando recebimento ou não
    /* 0 => OK, pacote recebido
       1 =>  Pacote não recebido completamente
     */


    public PacoteConfirmacao() {}

    public PacoteConfirmacao(int id, int codigo) {
        this.id = id;
        this.codigo = codigo;
    }



    public byte[] encode(){

        /*Código da internet - Não entendi.
         byte[] toByteArray(int value) {
         return new byte[] {
        (byte)(value >> 24),
        (byte)(value >> 16),
        (byte)(value >> 8),
        (byte)value };
}
         */

        byte[] buffer = new byte[2];
        buffer[0] = (byte) id;
        buffer[1] = (byte) codigo;

        return buffer;
    }

    public byte[] encode(int id, int codigo){
        this.id = id;
        this.codigo = codigo;
        return encode();
    }


    public void decode(byte[] buffer){
        this.id = buffer[0];
        this.codigo = buffer[1];
    }

}
