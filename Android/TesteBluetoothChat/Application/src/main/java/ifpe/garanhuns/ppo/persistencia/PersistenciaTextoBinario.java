package ifpe.garanhuns.ppo.persistencia;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.opengl.EGLExt;
import android.support.v4.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ifpe.garanhuns.ppo.common.activities.ActivityManager;
import ifpe.garanhuns.ppo.protocoloComunicacao.PacoteDadosBPM;

/**
 * Created by Anna Vitória on 28/11/2016.
 */

public class PersistenciaTextoBinario {

    private File pacoteBPMPersist;
    private FileOutputStream outputStream;
    private FileInputStream inputStream;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static PersistenciaTextoBinario instance;

    private PersistenciaTextoBinario () throws IOException{
        criarStream();
    }

    public static PersistenciaTextoBinario getInstance() throws IOException{
        if(instance==null)
            instance = new PersistenciaTextoBinario();
        return instance;
    }

    public void criarStream() throws IOException {
        File file = new File(android.os.Environment.getExternalStorageDirectory() + "teste/");
        if(file.exists()){
            file.mkdirs();
        }


        //?
        if(!pacoteBPMPersist.exists()) {
            pacoteBPMPersist = new File(file.getAbsolutePath(), "PacoteBPMPersistencia.bin");
        }
        outputStream = new FileOutputStream(pacoteBPMPersist);
        inputStream = new FileInputStream(pacoteBPMPersist); //Isso é a mesma coisa que FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE) ?
        String a = pacoteBPMPersist.getAbsolutePath();

    }

    public void salvarNoArquivo(byte[] buffer, Activity activity) throws IOException {

        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        outputStream.write(buffer);
        outputStream.flush();
    }

    public LinkedList lerDoArquivo() throws IOException {

        Activity activity = ActivityManager.getInstance().getAtual();
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        LinkedList<PacoteDadosBPM> pacoteDadosBPMLinkedList = new LinkedList<>();

        int posicaoInicial = 0;
        int posicaoFinal = 8;

        if (inputStream.available() > 9) {
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
