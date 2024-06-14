package Modelo.PaginaPrincipal.PantallasISRD;

import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PantallaRegistro extends JFrame{
    private JTextField nombre;
    private JTextField apellido;
    private JTextField mail;
    private JPasswordField contraseña;
    private JPasswordField repetirContraseña;
    private JTextField dni;
    private JButton siguienteButton;
    private JButton salirButton;
    private JPanel PantallaRegistro;

    public PantallaRegistro() {

        setTitle("Registro");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(PantallaRegistro);
        setLocationRelativeTo(null);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //verifica que ningun campo este vacio
                if(!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !mail.getText().isEmpty()
                        && !contraseña.getText().isEmpty() && !dni.getText().isEmpty() && !repetirContraseña.getText().isEmpty()){
                    if(mail.getText().contains("@") && !(mail.getText().contains("@admin.com") || mail.getText().contains("@conserje.com"))){

                        char[] password1 = contraseña.getPassword();
                        char[] password2 = repetirContraseña.getPassword();
                        if(Arrays.equals(password1, password2)){

                            String sNombre = nombre.getText();
                            String sApellido = apellido.getText();
                            String sDni = dni.getText();
                            String sMail = mail.getText();

                            char[] passwordChars = contraseña.getPassword();
                            // Convertir el char[] a String
                            String sContraseña = new String(passwordChars);

                            Persona p = new Persona(sNombre,sApellido,sDni,sMail,sContraseña,null);
                            PantallaDomicilio domicilio = new PantallaDomicilio(p);
                            domicilio.setVisible(true);
                            setVisible(false);

                        }else {
                            JOptionPane.showMessageDialog(null,"las constraseñas no coiciden");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"ingrese un mail valido");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"todos los campos deven estar completos");
                }
            }
        });
    }

    public PantallaRegistro(int x) {
        setTitle("Registro conserje");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(PantallaRegistro);
        setLocationRelativeTo(null);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //verifica que ningun campo este vacio
                if(!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !mail.getText().isEmpty()
                        && !contraseña.getText().isEmpty() && !dni.getText().isEmpty() && !repetirContraseña.getText().isEmpty()){
                    if(mail.getText().contains("@")){

                        char[] password1 = contraseña.getPassword();
                        char[] password2 = repetirContraseña.getPassword();
                        if(Arrays.equals(password1, password2)){

                            String sNombre = nombre.getText();
                            String sApellido = apellido.getText();
                            String sDni = dni.getText();
                            String sMail = mail.getText();

                            char[] passwordChars = contraseña.getPassword();
                            // Convertir el char[] a String
                            String sContraseña = new String(passwordChars);

                            Persona p = new Persona(sNombre,sApellido,sDni,sMail,sContraseña,null);
                            p.agregarAlArchivo(p);
                            JOptionPane.showMessageDialog(null,"Registro exitoso");
                            setVisible(false);

                        }else {
                            JOptionPane.showMessageDialog(null,"las constraseñas no coiciden");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"ingrese un mail valido");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"todos los campos deven estar completos");
                }
            }
        });

    }


}
