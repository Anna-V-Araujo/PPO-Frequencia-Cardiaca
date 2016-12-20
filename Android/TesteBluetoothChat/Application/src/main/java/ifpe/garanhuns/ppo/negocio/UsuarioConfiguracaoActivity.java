package ifpe.garanhuns.ppo.negocio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bluetoothchat.R;

import ifpe.garanhuns.ppo.common.activities.ActivityManager;

import static java.lang.Integer.parseInt;

public class UsuarioConfiguracaoActivity extends Activity {

    EditText editText3;

    @Override
    protected void onStart() {
        super.onStart();
        editText3 = (EditText) findViewById(R.id.usuario_freqMinima_edit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_configuracao);
        ActivityManager.getInstance().setAtual(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityManager.getInstance().setAtual(this);
    }

    public void alteraNomeIdade(View view){
        EditText editText1 = (EditText) findViewById(R.id.usuario_nome_edit);
        String nome = editText1.getText().toString();
        Usuario.getInstance().setNome(nome);

        EditText editText2 = (EditText) findViewById(R.id.usuario_idade_edit);
        String idadeStr = editText2.getText().toString();
        int idade = Integer.parseInt(idadeStr);
        Usuario.getInstance().setIdade(idade);

        Usuario.getInstance().determinafequencias();
        String mensagemFreq = "Sua frquencia mínima é: " + Usuario.getInstance().getFreqMinima() + "\n Sua frequência máxima é: " + Usuario.getInstance().getFreqMaxima();
        Toast.makeText(ActivityManager.getInstance().getAtual(), mensagemFreq, Toast.LENGTH_SHORT).show();
        //editText3.setText(String.valueOf(Usuario.getInstance().getFreqMinima()));
        //((EditText) findViewById(R.id.usuario_freqMinima_edit)).setText(Usuario.getInstance().getFreqMinima());

//        EditText editText4 = (EditText) findViewById(R.id.usuario_freqMaxima_edit);
//        editText4.setText(Usuario.getInstance().getFreqMaxima());

    }

    public void alteraFrequencias(View view){
        EditText editText1 = (EditText) findViewById(R.id.usuario_freqMinima_edit);
        String freqMinStr = editText1.getText().toString();
        int frequenciaMinima = Integer.parseInt(freqMinStr);
        Usuario.getInstance().setFreqMinima(frequenciaMinima);

        EditText editText2 = (EditText) findViewById(R.id.usuario_freqMaxima_edit);
        String freqMaxStr = editText2.getText().toString();
        int freqMax = Integer.parseInt(freqMaxStr);
        Usuario.getInstance().setFreqMaxima(freqMax);

        String mensagemFreq = "Sua frquencia mínima é: " + Usuario.getInstance().getFreqMinima() + "\n Sua frequência máxima é: " + Usuario.getInstance().getFreqMaxima();
        Toast.makeText(ActivityManager.getInstance().getAtual(), mensagemFreq, Toast.LENGTH_SHORT).show();
        //editText3.setText(String.valueOf(Usuario.getInstance().getFreqMinima()));
    }

}
