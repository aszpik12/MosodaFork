package modell;

public class Ruha {
    private String tulNeve;
    private boolean tiszta;

    public Ruha(String tulNev) {
        this.tulNeve = tulNev;
        tiszta = false;
    }

    public String getTulNev() {
        return tulNeve;
    }

    public void setTulNev(String tulNeve) {
        this.tulNeve = tulNeve;
    }

    public boolean isTiszta() {
        return tiszta;
    }

    public void setTiszta(boolean tiszta) {
        this.tiszta = tiszta;
    }

    @Override
    public String toString() {
        return "Ruha{" + "tulNeve=" + tulNeve + ", tiszta=" + tiszta + '}';
    }
}
