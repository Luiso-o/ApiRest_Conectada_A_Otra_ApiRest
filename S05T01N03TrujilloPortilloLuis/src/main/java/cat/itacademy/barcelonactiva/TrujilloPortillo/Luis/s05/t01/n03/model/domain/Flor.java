package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.domain;

public class Flor {
    private String nombreFlor;
    private String paisFlor;
    private String tipoFlor;

    public Flor(String nombreFlor, String paisFlor, String tipoFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        this.tipoFlor = tipoFlor;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }
}