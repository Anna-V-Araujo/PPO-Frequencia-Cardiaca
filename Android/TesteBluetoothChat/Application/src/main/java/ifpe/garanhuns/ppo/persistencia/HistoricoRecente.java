package ifpe.garanhuns.ppo.persistencia;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;

import java.io.IOException;
import java.util.LinkedList;

import ifpe.garanhuns.ppo.common.activities.ActivityManager;
import ifpe.garanhuns.ppo.comunicacaoBluetooth.MainActivity;
import ifpe.garanhuns.ppo.negocio.Usuario;
import ifpe.garanhuns.ppo.protocoloComunicacao.PacoteDadosBPM;

/**
 * Created by Anna Vitória on 09/12/2016.
 */

public class HistoricoRecente {

    private static HistoricoRecente instance;

    public static HistoricoRecente getInstance() {
        if(instance == null)
            instance = new HistoricoRecente();
        return instance;
    }

    LinkedList<StatusPacote> historico = new LinkedList();

    public HistoricoRecente() {
        try {

            //Isso para quando for determinar o mínimo de itens que apareceram no gráfico
            /*LinkedList tempList = new LinkedList();
            tempList = PersistenciaTextoBinario.getInstance().lerDoArquivo();
            int tempListSize = tempList.size();

            for(int i = 11; i < 1; i--) {
                historico.add(tempList.get(tempListSize - i));
            }
            */
            if (historico.isEmpty()) {
                Activity activity = ActivityManager.getInstance().getAtual();
                LinkedList<PacoteDadosBPM> histTemp = PersistenciaTextoBinario.getInstance().lerDoArquivo();
                for (PacoteDadosBPM p : histTemp) {
                    StatusPacote statusPacote = new StatusPacote(p, true);
                    historico.add(statusPacote);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPacote(PacoteDadosBPM pacoteDadosBPM) throws IOException {
        StatusPacote statusPacote = new StatusPacote(pacoteDadosBPM, false);
        historico.add(statusPacote);
       if (Usuario.getInstance().verificarAdequacaoFrequencia(statusPacote.getPacoteDadosBPM().getFrequencia()) == false) {
           Vibrator v = (Vibrator) ActivityManager.getInstance().getAtual().getSystemService(Context.VIBRATOR_SERVICE);
           v.vibrate(1000);
       }

    }



    public void sincronizarMemoriaInterna(){
        Activity activity = ActivityManager.getInstance().getAtual();
        for (StatusPacote statusPacote : historico) {
            if(statusPacote.getEstaSalvo() == false){
                try {
                    PersistenciaTextoBinario.getInstance().salvarNoArquivo(statusPacote.getPacoteDadosBPM().encode(), activity);
                    statusPacote.setEstaSalvo(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
