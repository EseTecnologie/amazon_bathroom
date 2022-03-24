import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class paintThread extends Thread{
    private final Shared s;
    private myFrame frame;

    public paintThread(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        frame = new myFrame(s);
        frame.setVisible(true);

        ThreadDesign disegna = new ThreadDesign(frame);
        disegna.start();
        //USAMI SE DEVI FERMARE IL PROGRAMMA QUANDO CHIUDI LA FINESTRA
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public myFrame getFrame() {
        return frame;
    }
}
