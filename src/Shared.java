import java.util.Random;

public class Shared {
    static Boolean timeLeft;
    private final int nBagni = 5;


    private final Bathrooms mBagnoBuffer = new Bathrooms(nBagni);
    private final Bathrooms fBagnoBuffer = new Bathrooms(nBagni);

    public Shared() {
        timeLeft = false;
    }

    public Bathrooms getmBagnoBuffer() {
        return mBagnoBuffer;
    }

    public Bathrooms getfBagnoBuffer() {
        return fBagnoBuffer;
    }

    public int getnBagni() {
        return nBagni;
    }

    public Boolean goToBathroom(Employee employee){
        if(employee.getSex() == 0) return mBagnoBuffer.goToBathroom(employee);
        return fBagnoBuffer.goToBathroom(employee);
    }

    public Bathroom minUsedBathroomM(){
        return mBagnoBuffer.minUsedBathroom();
    }
    public Bathroom minUsedBathroomF(){
        return fBagnoBuffer.minUsedBathroom();
    }

}

//        Random rnd = new Random();
//        int i;
//        int t = rnd.nextInt(1000)+1; //genero il tempo in cui starò in bagno(solo se il bagno è libero)
//        if(employee.getSex() == 0){ //man
//            synchronized (lockMan){
//                if(isFullBathrooms(mBagnoBuffer)) return false;
//
//                //entro randomicamente in un bagno libero
//                do {
//                    i = rnd.nextInt(nBagni);
//                }while (!mBagnoBuffer[i].entryBathroom());
//                System.out.println(employee.getFreshman() +" in bagno");
//            }
//            //sto in bagno max 1 sec
//            employee.Add_tInBathroom(t); //aggiungo il tempo trascorso in bagno alla variabile del dipendente
//            try {
//                Thread.sleep(t);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //finito il tempo setto che sono uscito
//            mBagnoBuffer[i].outBathroom();
//            System.out.println(employee.getFreshman() +" fuori bagno");
//        }else { //woman
//            synchronized (lockWoman){
//                if(isFullBathrooms(fBagnoBuffer)) return false;
//
//                //entro randomicamente in un bagno libero
//                do {
//                    i = rnd.nextInt(nBagni);
//                }while (!fBagnoBuffer[i].entryBathroom());
//                System.out.println(employee.getFreshman() +" in bagno");
//            }
//            //sto in bagno max 1 sec
//            employee.Add_tInBathroom(t); //aggiungo il tempo trascorso in bagno alla variabile del dipendente
//            try {
//                Thread.sleep(t);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //finito il tempo setto che sono uscito
//            fBagnoBuffer[i].outBathroom();
//            System.out.println(employee.getFreshman() +" fuori bagno");
//        }
//        return true;
