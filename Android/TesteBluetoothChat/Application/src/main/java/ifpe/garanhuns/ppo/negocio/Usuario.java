package ifpe.garanhuns.ppo.negocio;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by Anna Vitória on 11/12/2016.
 */

public class Usuario {


    private static Usuario instance;
    public static Usuario getInstance() {
        if(instance == null)
            instance = new Usuario("Default", 20);
        return instance;
    }

    public String nome;
    public int idade;
    public int freqMaxima;
    public int freqMinima;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void determinafequencias(){
        if(idade > 0) {
            freqMaxima = (int) ((200 - idade) * 0.7);
            freqMinima = (int) ((200 - idade) * 0.6);
        } else{
            freqMaxima = 0;
            freqMinima = 0;
        }
    }

    public boolean verificarAdequacaoFrequencia (int frequencia){
        if(frequencia > freqMaxima || frequencia < freqMinima){
            return  false;

            //Vibrar apenas onde for chamado - quando for adicionado um item na lista;
            //Vibrator vibrator = (Vibrator) getSystemService(Usuario.class);
            //(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            //Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
           //vibrator.vibrate(500);
        } else {
            return true;
        }
    }

    public int getFreqMaxima() {
        return freqMaxima;
    }

    public void setFreqMaxima(int freqMaxima) {
        this.freqMaxima = freqMaxima;
    }

    public int getFreqMinima() {
        return freqMinima;
    }

    public void setFreqMinima(int freqMinima) {
        this.freqMinima = freqMinima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
