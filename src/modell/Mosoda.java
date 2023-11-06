package modell;

public class Mosoda {
    private Ruha[] ruhak;
    private int ruhaDb;
    private boolean uzemel;
    private enum UzemelesiAllapot {UZEMEL, NEM_UZEMEL, LEEGETT};
    private UzemelesiAllapot allapot;

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
        uzemel = true;
        allapot = UzemelesiAllapot.UZEMEL;
        
    }
    
    public void leeg(){
        uzemel = false;
        allapot = UzemelesiAllapot.LEEGETT;
    }
    
    public void bevesz(Ruha ruha){
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            if (ruhaDb < ruhak.length) {
                ruhak[ruhaDb++] = ruha;
            } else {
                System.out.println("A mosoda megtelt!");
            }
        } else {
            nemUzemel();
        }
    }
    
    public void mos(){
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            for (Ruha ruha : ruhak) {
                if (ruha != null) {
                    if (ruha instanceof Ing) {
                        Ing ing = (Ing) ruha;
                        ing.setSzin(ing.getSzin() * 0.97);
                    }
                    ruha.setTiszta(true);
                }
            }
        } else {
            nemUzemel();
        }
    }
    
    public Ruha kiad(String tulNeve){
        Ruha kiadottRuha = null;
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            int i = 0;
            while (ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))) {
                i++;
            }
            if (i < ruhaDb) {
                String tipus = ruhak[i] instanceof Ruha ? "ruhája" : "inge";
                System.out.println("Kiadva %s %s!".formatted(tulNeve, tipus));
                kiadottRuha = ruhak[i];
                ruhak[i] = null;
            } else {
                System.out.println("Nincs ilyen ruha a mosodában!");
            }
        } else {
            nemUzemel();
        }
        
        return kiadottRuha;
    }

    public String[] getRuhak() {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            String[] ruhak = new String[this.ruhak.length];
            for (int i = 0; i < ruhaDb; i++) {
                Ruha r = this.ruhak[i];
                if (r != null) {
                    ruhak[i] = r.getTulNev();

                    //ruhak[i] += r instanceof Ing ? " ingje " : " ruhája ";
                    String szinIntenzitas = "";
                    if (r instanceof Ing) {
                        ruhak[i] += " inge ";
                        szinIntenzitas = " színe " + ((Ing) r).getSzin() + "%";
                    } else {
                        ruhak[i] += " ruhája ";
                    }
                    ruhak[i] += r.isTiszta() ? "tiszta" : "koszos";
                    ruhak[i] += szinIntenzitas;
                }
            }
            return ruhak;
        } else {
            nemUzemel();
            return null;
        }
    }
    
    private void nemUzemel() {
        if (allapot == UzemelesiAllapot.NEM_UZEMEL) {
            System.out.println("A mosoda nem üzemel!");
        } else if(allapot == UzemelesiAllapot.LEEGETT){
            System.out.println("A mosoda leégett!");
        }
    }
}
