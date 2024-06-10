package Modelo.PaginaPrincipal.PantallasPCA;

import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallaAgregarHabitacion;
import Modelo.PaginaPrincipal.PantallaEliminarHabitacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipalAdmin extends JFrame {
    private JButton listaDeHabitacionesButton;
    private JButton listaDeHuespedesButton;
    private JButton agregarHabitacionButton;
    private JButton agregarConserjeButton;
    private JButton quitarConserjeButton;
    private JButton eliminarHabitacionButton;
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

        listaDeHuespedesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String huespedes = a.mostrarHuespedes();
                if(!a.mostrarHuespedes().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,a.mostrarHuespedes());
                }else {
                    JOptionPane.showMessageDialog(null,"No hay huespedes :_(");
                }

            }
        });
        agregarHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaAgregarHabitacion agh1 = new PantallaAgregarHabitacion(a);
            }
        });
        eliminarHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaEliminarHabitacion pe1 = new PantallaEliminarHabitacion(a);
            }
        });
    }

}
