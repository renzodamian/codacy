package eje;

import java.net.*;
import java.io.*;
import controlador.*;
import modelo.*;
import vista.*;

/**
 *
 * @author renzo
 */
public class Main {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream entra;


    public static void main(String[] args) {

        EstudianteDAO obj1 = new EstudianteDAO();
        User obj2 = new User();
        Controlador obj3 = new Controlador(obj2, obj1);

        obj1.addObserver(obj3);

        obj2.setVisible(true);
        obj2.setLocationRelativeTo(null);
        String m= " " ;
        System.out.println("");

        try {
            ss = new ServerSocket(4444);
            s = ss.accept();
            System.out.println("entr");
                    

            entra = new DataInputStream(s .getInputStream());
            System.out.println("entr");

            while (!m.equals("exit")) {
                m = entra.readUTF();
                obj2.txta.setText(obj2.txta.getText().trim() + "\n Cliente" + m);

            }
        } catch (Exception e) {
        }

    }
}
