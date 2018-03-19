package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;


import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author renzo
 */
public class Controlador implements ActionListener, Observer {
  

    String rptaregistro;
    User obj1 = new User();
    EstudianteDAO obj2 = new EstudianteDAO();

    public Controlador(User obj1, EstudianteDAO obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj1.btn_guardar.addActionListener(this);
    }

    public void limpiar() {
        obj1.txt_nombre.setText(null);
        obj1.txt_apellido.setText(null);
        obj1.txt_cedula.setText(null);
        obj1.txt_user.setText(null);
        obj1.jpass.setText(null);
    }

    public void actionPerformed(ActionEvent e) {
        //String pasc;
        if (e.getSource() == obj1.btn_guardar) {
            String nombre = obj1.txt_nombre.getText();

            String apellido = obj1.txt_apellido.getText();

            String cedula = obj1.txt_cedula.getText();

            String user = obj1.txt_user.getText();

            String pass = obj1.jpass.getText();

            limpiar();
            //pasc = DigestUtils.md5Hex(pass);
            rptaregistro = obj2.insertarEstudiante(nombre,
                    apellido, cedula, user, pass);

            if (rptaregistro != null) {
                JOptionPane.showMessageDialog(null, rptaregistro);

            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo");

            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Actualizado" + o + arg);
    }

}
