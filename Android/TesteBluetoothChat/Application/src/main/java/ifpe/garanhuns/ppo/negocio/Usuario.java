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
        freqMaxima = (int) ((200 - idade) * 0.7);
        freqMinima = (int) ((200 - idade) * 0.6);
    }

    public boolean verificarAdequacaoFrequencia (int frequencia){
        if(frequencia > freqMaxima || frequencia < freqMinima){
            return  false;
        } else {
            return true;
        }
    }

}
