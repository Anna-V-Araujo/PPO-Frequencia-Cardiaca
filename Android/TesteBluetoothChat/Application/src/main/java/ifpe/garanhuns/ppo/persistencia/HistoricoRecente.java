package ifpe.garanhuns.ppo.persistencia;

import java.io.IOException;
import java.util.LinkedList;

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

    LinkedList historico = new LinkedList();

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

            this.historico = PersistenciaTextoBinario.getInstance().lerDoArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPacote(PacoteDadosBPM pacoteDadosBPM) throws IOException {
        historico.add(pacoteDadosBPM);
        PersistenciaTextoBinario.getInstance().salvarNoArquivo(pacoteDadosBPM.encode());
    }

}
