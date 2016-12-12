package ifpe.garanhuns.ppo.negocio;

/**
 * Created by Anna Vitória on 11/12/2016.
 */

public class Usuario {

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
}
