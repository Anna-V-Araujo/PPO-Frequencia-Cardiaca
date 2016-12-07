package com.example.android.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna Vitória on 28/11/2016.
 */

public class PersistenciaTextoBinario {

    private static PersistenciaTextoBinario instance;
    private PersistenciaTextoBinario(){

    }
    public static PersistenciaTextoBinario getInstance() {
        if(instance==null)
            instance = new PersistenciaTextoBinario();
        return instance;
    }

    File pacoteBPMPersist = new File("PacoteBPMPersistencia.txt" /*Nome do arquivo*/);
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

    public List lerDoArquivo() throws IOException {
        List buffersList = new ArrayList<byte[]>();

        int posicaoInicial = 0;
        int posicaoFinal = 8;

        if(inputStream.available() > 9){
           while (inputStream.read() != -1) {
               byte[] buffer = new byte[9];
               inputStream.read(buffer, posicaoInicial, posicaoFinal);
               buffersList.add(buffer);
               posicaoInicial = posicaoInicial + 9;
               posicaoFinal = posicaoFinal + 9;
           }
        }
        return buffersList;
    }

    public void fecharStream() throws IOException {
        inputStream.close();
        outputStream.close();
    }

}
