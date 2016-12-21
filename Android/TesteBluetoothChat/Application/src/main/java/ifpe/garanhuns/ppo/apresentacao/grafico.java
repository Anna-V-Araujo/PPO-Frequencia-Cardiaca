package ifpe.garanhuns.ppo.apresentacao;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.bluetoothchat.R;

import java.util.ArrayList;

import ifpe.garanhuns.ppo.common.activities.ActivityManager;
import ifpe.garanhuns.ppo.persistencia.HistoricoRecente;
import im.dacer.androidcharts.LineView;

public class Grafico extends Activity {

    LineView lineView;
    ArrayList<String> legenda;
    ArrayList<Integer> dataList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        lineView = (LineView)findViewById(R.id.line_view);

        dataList = new ArrayList<>();
        legenda = new ArrayList<>();

        lineView.setDrawDotLine(true); //optional
        lineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY); //optional

        lineView.setColorArray(new int[]{Color.BLACK,Color.GREEN,Color.GRAY,Color.CYAN});

    }

    public void atualizaGrafico(View view){
        legenda.clear();
        legenda = HistoricoRecente.getInstance().ultimosDatas();

        if(legenda.isEmpty()){
            legenda.add("Vazio");
            legenda.add("Vazio");
            legenda.add("Vazio");
            Toast.makeText(ActivityManager.getInstance().getAtual(), "Não há dados disponíveis.", Toast.LENGTH_LONG).show();
        }

        dataList.clear();
        dataList = HistoricoRecente.getInstance().ultimasFrequencias();

        if(dataList.isEmpty()){
            dataList.add(0);
            dataList.add(0);
            dataList.add(0);
            Toast.makeText(ActivityManager.getInstance().getAtual(), "Não há dados disponíveis.", Toast.LENGTH_LONG).show();
        }

        lineView.setBottomTextList(legenda);
        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<ArrayList<Integer>>();
        dataLists.add(dataList);
        lineView.setDataList(dataLists);


    }

}
