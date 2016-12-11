package ifpe.garanhuns.ppo.persistencia;

import ifpe.garanhuns.ppo.protocoloComunicacao.PacoteDadosBPM;

/**
 * Created by Anna Vitória on 10/12/2016.
 */

public class StatusPacote {

    PacoteDadosBPM pacoteDadosBPM;
    boolean estaSalvo;

    public StatusPacote(PacoteDadosBPM pacoteDadosBPM, boolean estaSalvo) {
        this.pacoteDadosBPM = pacoteDadosBPM;
        this.estaSalvo = estaSalvo;
    }

    public PacoteDadosBPM getPacoteDadosBPM() {
        return pacoteDadosBPM;
    }

    public void setPacoteDadosBPM(PacoteDadosBPM pacoteDadosBPM) {
        this.pacoteDadosBPM = pacoteDadosBPM;
    }

    public boolean getEstaSalvo() {
        return estaSalvo;
    }

    public void setEstaSalvo(boolean estaSalvo) {
        this.estaSalvo = estaSalvo;
    }
}

