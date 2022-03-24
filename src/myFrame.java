import javax.swing.*;
import java.awt.*;

public class myFrame extends JFrame {
    Shared s;
    public myFrame(Shared s) throws HeadlessException{
        this.setSize(500,300);
        this.s = s;
    }

    @Override
    public void paint(Graphics g) {
        //evitare flickering figure
        Image image = createImage(this.getWidth(), this.getHeight());
        Graphics gImage=image.getGraphics();
        gImage.clearRect(0, 0, this.getWidth(), this.getHeight());

        int startX = 100;
        int x = startX;
        final int size = 50;
        final int nBathroomM = s.getnBagni();
        final int nBathroomF = s.getnBagni();
        final Bathroom[] mBusyBathroom = s.getmBagnoBuffer().getBathroomsArray();
        final Bathroom[] fBusyBathroom = s.getfBagnoBuffer().getBathroomsArray();

        int[] xCoordinates = new int[5];
        for (int i = 0; i < xCoordinates.length;i++){
            xCoordinates[i] = x;
            x += size + 10;
        }

        x = startX;
        for (int i = 0; i<nBathroomM;i++){
            if(mBusyBathroom[i].inUse){
                gImage.setColor(Color.cyan);
                gImage.fillRect(x,100, size, size);
            }
            gImage.setColor(Color.BLACK);
            gImage.drawRect(x,100, size, size);
            if(mBusyBathroom[i].toDelete){
                gImage.setColor(Color.BLUE);
                gImage.fillRect(x,100, size, size);
                gImage.setColor(Color.RED);
                gImage.drawRect(x,100, size, size);
            }
            x += size + 10;
        }

        x = startX;
        for (int i = 0; i<nBathroomF;i++){
            if(fBusyBathroom[i].inUse){
                gImage.setColor(Color.pink);
                gImage.fillRect(x,180, size, size);
            }
            gImage.setColor(Color.BLACK);
            gImage.drawRect(x,180, size, size);

            if(fBusyBathroom[i].toDelete){
                gImage.setColor(Color.MAGENTA);
                gImage.fillRect(x,180, size, size);
                gImage.setColor(Color.RED);
                gImage.drawRect(x,180, size, size);
            }
            x += size + 10;
        }


        g.drawImage(image, 0, 0, this);
    }
}
