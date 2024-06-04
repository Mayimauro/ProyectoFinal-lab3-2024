package Modelo.PaginaPrincipal.PantallasPCA;

import Modelo.Hotel.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipalAdmin extends JFrame {
    private JButton listaDeHabitacionesButton;
    private JButton listaDeHuespedesButton;
    private JButton agregarHabitacionButton;
    private JButton agregarConserjeButton;
    private JButton quitarConserjeButton;
    private JButton consultarButton;
    private JButton consultarButton3;
    private JButton consultarButton2;
    private JButton consultarButton1;
    private JButton consultarButton4;
    private JButton consultarButton5;
    private JButton salirButton;
    private JPanel pantallaAdministrador;


    public PantallaPrincipalAdmin(Hotel a) {
        setTitle("Administrador");
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pantallaAdministrador);
        setLocationRelativeTo(null);


        listaDeHabitacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,a.mostrarHabitacionesConNumero());
            }
        });




        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
