package Modelo.PaginaPrincipal.PantallasISRD;

import Exceptions.InicioSesionIncorrectoException;
import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasPCA.PantallaPrincipalAdmin;
import Modelo.PaginaPrincipal.PantallasPCA.PantallaPrincipalConserje;
import Modelo.PaginaPrincipal.PantallasPCA.PantallaPrincipalPasajero;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicioSesion extends JFrame{
    private JTextField Usuario;
    private JButton iniciarSecionButton;
    private JButton salirButton1;
    private JPanel InicioSecionPanel;
    private JPasswordField passwordField1;
    private JButton registrarseButton;


    public PantallaInicioSesion(Hotel hotel) throws InicioSesionIncorrectoException{
        setTitle("Inicio de sesion");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(InicioSecionPanel);
        setLocationRelativeTo(null);

        salirButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        iniciarSecionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Usuario.getText().isEmpty() && passwordField1.getPassword().length!=0)
                {
                    char[] passwordChars = passwordField1.getPassword();
                    // Convierte el array de caracteres a String
                    String password = new String(passwordChars);
                    int autentificador = -1;
                    try{
                        autentificador = hotel.validarUsuario(Usuario.getText(),password);
                    }catch (InicioSesionIncorrectoException ex)
                    {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }

                    if(autentificador ==1)
                    {
                        PantallaPrincipalAdmin admin = new PantallaPrincipalAdmin(hotel);
                        JOptionPane.showMessageDialog(null,"inicio de sesion exitoso");
                        setVisible(false);

                    } else if (autentificador ==2) {
                        Persona p = hotel.buscarPersona(Usuario.getText(),password);
                        PantallaPrincipalConserje conserje = new PantallaPrincipalConserje(hotel,p.getNombre());
                        JOptionPane.showMessageDialog(null,"inicio de sesion exitoso");
                        setVisible(false);
                    }else if (autentificador ==0){
                        Persona p = hotel.buscarPersona(Usuario.getText(),password);
                        PantallaPrincipalPasajero pasajero = new PantallaPrincipalPasajero(hotel,p);
                        JOptionPane.showMessageDialog(null,"inicio de sesion exitoso");
                        setVisible(false);
                    }
                }
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaRegistro registro = new PantallaRegistro();
                registro.setVisible(true);
                setVisible(false);

            }
        });
    }


}
