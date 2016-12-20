package ifpe.garanhuns.ppo.persistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.android.bluetoothchat.R;

public class historicoTabela extends AppCompatActivity {

    private GridView gridTabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_tabela);
        gridTabela = (GridView)findViewById(R.id.tabela);
    }


}
