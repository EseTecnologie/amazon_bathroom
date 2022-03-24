import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Shared s = new Shared();
      /* java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                myFrame frame = new myFrame(s);
                frame.setVisible(true);

                ThreadDesign disegna = new ThreadDesign(frame);
                disegna.start();
            }
        });*/
        paintThread paint = new paintThread(s);
        paint.start();

        Employee[] EmployeesArray = new Employee[100];

        Random rnd = new Random();
        for(int i = 0; i < EmployeesArray.length; i++){
            EmployeesArray[i] = new Employee(Integer.toString(i),s);
            EmployeesArray[i].start();
        }
        System.out.println("Start day\n\n");
        EndDay endDay = new EndDay();
        endDay.start();

        try {
            endDay.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < EmployeesArray.length; i++) {
            try {
                EmployeesArray[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("\n\n");

        Employee mMax = new Employee("none",s);
        Employee fMax = new Employee("none", s);
        for (Employee employee : EmployeesArray) {
            if (employee.getSex() == 0 && employee.gettInBathroom() > mMax.gettInBathroom()) mMax = employee;
            else if (employee.getSex() == 1 && employee.gettInBathroom() > fMax.gettInBathroom()) fMax = employee;
        }
        System.out.println("Verranno licenziati " + mMax.getFreshman() +" e "+ fMax.getFreshman());
        Bathroom minUsedBathroomM = s.minUsedBathroomM();
        Bathroom minUsedBathroomF = s.minUsedBathroomF();
        System.out.println("Bagno meno utilizzato maschi:" + (minUsedBathroomM.bathroomID+1) +", con "+minUsedBathroomM.usesCount +" utilizzi");
        System.out.println("Bagno meno utilizzato maschi:" + (minUsedBathroomF.bathroomID+1) +", con "+minUsedBathroomF.usesCount +" utilizzi");


        try {
            paint.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
