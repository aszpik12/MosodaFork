package main;

import modell.Ing;
import modell.Mosoda;
import modell.Ruha;

public class MosodaProgram {

    private Mosoda mosoda;

    public static void main(String[] args) {
        new MosodaProgram();
    }
    
    public MosodaProgram() {
        mosoda = new Mosoda(4);
        mosoda.bevesz(new Ruha("Péter"));
        mosoda.bevesz(new Ruha("Pál"));
        mosoda.bevesz(new Ing("Petra"));
        mosoda.bevesz(new Ing("Piroska"));
        
        //NullPointerException
        //mosoda.leeg();
        
        System.out.println("--- mosoda ruhái mosás ELŐTT:");
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 1. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 2. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        Ruha ruhaPal = mosoda.kiad("Pál");
        Ruha ingPetra = mosoda.kiad("Petra");
        System.out.println("--- a mosodában maradt ruhák:");
        mosodaRuhai();
        
        System.out.println("--- a mosoda leég:");
        mosoda.leeg();
        mosoda.bevesz(new Ruha("Valaki"));
        mosoda.kiad("Piroska");
        
        System.out.println("--- leégés előtt kivett ruhák:");
        //String a = "tul: %s, tiszta: %b".formatted(ruhaPal.getTulNev(), ruhaPal.isTiszta());
        System.out.println(ruhaPal);
        
        //Ing ing = (Ing)ingPetra;//cast nélkül nem elérhető az intenzitás
        //a = "tul: %s, tiszta: %b, intenzitas: %.3f".formatted(ing.getTulNev(), ing.isTiszta(), ing.getSzin());
        System.out.println(ingPetra);//megfelelő típus metódusa hívódik meg!
        
        //HIBÁS használat: */
        Ruha elegettruha = new Ruha("Az elégett ruha");
        Mosoda ujMosoda = new Mosoda();
        ujMosoda.bevesz(elegettruha);
        ujMosoda.mos();
        ujMosoda.leeg();
        System.out.println(elegettruha);
    }
    
    private void mosodaRuhai() {
        for (String ruha : mosoda.getRuhak()) {
            if(ruha != null){
                System.out.println(ruha);
            }
        }
    }

}
