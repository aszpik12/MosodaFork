package modell;

public class Mosoda {
    private Ruha[] ruhak;
    private int ruhaDb;

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
    }
    
    public void bevesz(Ruha ruha){
        if(ruhaDb < ruhak.length){
            ruhak[ruhaDb++] = ruha;
        }else{
            System.out.println("A mosoda megtelt!");
        }
    }
    
    public void mos(){
        for (Ruha ruha : ruhak) {
            if(ruha != null){
                if(ruha instanceof Ing){
                    Ing ing = (Ing) ruha;
                    ing.setSzin(ing.getSzin() * 0.97);
                }
                ruha.setTiszta(true);
            }
        }
    }
    
    public void kiad(String tulNeve){
        int i = 0;
        while(ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))){
            i++;
        }
        if(i < ruhaDb){
            String tipus = ruhak[i] instanceof Ruha ? "ruhája" : "inge";
            System.out.println("Kiadva %s %s!".formatted(tulNeve, tipus));
            ruhak[i] = null;
        }else{
            System.out.println("Nincs ilyen ruha a mosodában!");
        }
    }

    public String[] getRuhak() {
        String[] ruhak = new String[this.ruhak.length];
        for (int i = 0; i < ruhaDb; i++) {
            Ruha r = this.ruhak[i];
            if(r != null){
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
    }
    
    
}
