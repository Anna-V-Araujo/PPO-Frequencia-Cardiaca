package ifpe.garanhuns.ppo.apresentacao;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.bluetoothchat.R;

import java.io.IOException;
import java.util.ArrayList;

import ifpe.garanhuns.ppo.persistencia.HistoricoRecente;
import im.dacer.androidcharts.LineView;

public class Grafico extends AppCompatActivity {

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

        dataList.clear();
        dataList = HistoricoRecente.getInstance().ultimasFrequencias();



        lineView.setBottomTextList(legenda);

        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<ArrayList<Integer>>();
        dataLists.add(dataList);
        lineView.setDataList(dataLists);


    }

}
