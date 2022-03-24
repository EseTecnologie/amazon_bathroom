import java.util.Random;

public class Bathrooms {
    int nBagni;
    private final Bathroom[] BagnoBuffer;
    private final Object lock = new Object();

    public Bathrooms(int nBagni) {
        this.nBagni = nBagni;
        BagnoBuffer = new Bathroom[nBagni];
        for(int i = 0; i < nBagni;i++){
            BagnoBuffer[i] = new Bathroom(i);
        }
    }

    public Boolean goToBathroom(Employee employee){
        Random rnd = new Random();
        int i;
        int t = rnd.nextInt(2001)+1000; //genero il tempo in cui starò in bagno(solo se il bagno è libero)
        synchronized (lock){
            if(isFullBathrooms(BagnoBuffer)) return false;

            //entro randomicamente in un bagno libero
            do {
                i = rnd.nextInt(nBagni);
            }while (!BagnoBuffer[i].entryBathroom());
            //System.out.println(employee.getFreshman() +" in bagno");
        }
        //sto in bagno max 1 sec
        employee.Add_tInBathroom(t); //aggiungo il tempo trascorso in bagno alla variabile del dipendente
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //finito il tempo setto che sono uscito
        BagnoBuffer[i].outBathroom();
        //System.out.println(employee.getFreshman() +" fuori bagno");
        return true;
    }

    private Boolean isFullBathrooms(Bathroom[] bathroomArray){
        for(int i = 0; i<nBagni; i++){
            if(bathroomArray[i].canEnter()) return false;
        }
        return true;
    }
    public Bathroom minUsedBathroom(){
        Bathroom max = new Bathroom(0);
        for (Bathroom bathroom : BagnoBuffer) {
            if(bathroom.usesCount > max.usesCount) max = bathroom;
        }
        max.toDelete = true;
        return max;
    }

    public Bathroom[] getBathroomsArray(){
        return BagnoBuffer;
    }
}
