package modell;

public class Mosoda {

    private Ruha[] ruhak;
    private int ruhaDb;
    private boolean leeg = leeges();

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
    }

    public void bevesz(Ruha ruha) {
        if (leeg == false) {
            if (ruhaDb < ruhak.length) {
                ruhak[ruhaDb++] = ruha;
            } else {
                System.out.println("A mosoda megtelt!");
            }
        } else {
            System.out.println("nem tud ruhát bevinni. A mosoda leégett!");
        }
    }

    public boolean leeges() {
        int rand = (int) (Math.random() * 3 - 1 + 1) + 1;
        System.out.println("leégett a mosoda!");
        for (int i = 0; i < ruhak.length; i++) {
            ruhak[i] = null;
        }
        return rand == 3;
    }

    public void mos() {
        for (Ruha ruha : ruhak) {
            if (ruha != null) {
                if (ruha instanceof Ing) {
                    Ing ing = (Ing) ruha;
                    ing.setSzin(ing.getSzin() * 0.97);
                }
                ruha.setTiszta(true);
            }
        }
    }

    public void kiad(String tulNeve) {
        int i = 0;
        if (leeg == false) {
            while (ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))) {
                i++;
            }
            if (i < ruhaDb) {
                String tipus = ruhak[i] instanceof Ruha ? "ruhája" : "inge";
                System.out.println("Kiadva %s %s!".formatted(tulNeve, tipus));
                ruhak[i] = null;
            } else {
                System.out.println("Nincs ilyen ruha a mosodában!");
            }
        } else {
            System.out.println("nem tud ruhát bevinni. A mosoda leégett!");
        }
    }

    public String[] getRuhak() {
        if (leeg == false) {
            String[] ruhak = new String[this.ruhak.length];
            for (int i = 0; i < ruhaDb; i++) {
                Ruha r = this.ruhak[i];
                if (r != null) {
                    ruhak[i] = r.toString();
//                ruhak[i] = r.getTulNev();
//                
//                //ruhak[i] += r instanceof Ing ? " ingje " : " ruhája ";
//                String szinIntenzitas = "";
//                if(r instanceof Ing){
//                    ruhak[i] += " ingje ";
//                    szinIntenzitas = " színe " + ((Ing) r).getSzin() + "%";
//                }else{
//                    ruhak[i] += " ruhája ";
//                }
//                ruhak[i] += r.isTiszta() ? "tiszta" : "koszos";
//                ruhak[i] += szinIntenzitas;
                }
            }
            return ruhak;
        } else {
            System.out.println("nem tud ruhát bevinni. A mosoda leégett!"); 
            return ;
        }
    }

}
