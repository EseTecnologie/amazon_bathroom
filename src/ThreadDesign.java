import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ThreadDesign extends Thread{

    Frame f;

    public ThreadDesign(Frame f){
        this.f = f;
    }

    @Override
    public void run() {
        while(true){
            f.repaint();
            try {
                sleep(36); //(30fps)
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDesign.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
