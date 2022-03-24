import java.util.Random;

public class Employee extends Thread{
    private final String freshman;
    private final int sex; //0 = men, 1 = women
    private int tInBathroom;
    private final Shared s;

    public Employee (String freshman, Shared sharedClass){
        this.freshman = freshman;
        this.s = sharedClass;
        Random rnd = new Random();
        this.sex = rnd.nextInt(2);
        this.tInBathroom = 0;
    }

    public String getFreshman() {
        return freshman;
    }

    public int getSex() {
        return sex;
    }

    public int gettInBathroom() {
        return tInBathroom;
    }

    public void Add_tInBathroom(int tInBathroom) {
        this.tInBathroom += tInBathroom;
    }

    @Override
    public void run() {
        do {
            Random rnd = new Random();
           try {
                sleep(rnd.nextInt(5001)+2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.goToBathroom(this);
        }while(!Shared.timeLeft);
    }
}
