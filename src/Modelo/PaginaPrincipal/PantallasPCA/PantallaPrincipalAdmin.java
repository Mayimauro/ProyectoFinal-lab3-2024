package Modelo.PaginaPrincipal.PantallasPCA;

import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallaAgregarHabitacion;
import Modelo.PaginaPrincipal.PantallaEliminarHabitacion;
import Modelo.PaginaPrincipal.PantallasISRD.PantallaRegistro;

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
    private JButton pasarHuespedesAUnButton;
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

        agregarConserjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x=0;
                PantallaRegistro rc = new PantallaRegistro(x);
            }
        });
        quitarConserjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = new JTextField(10);
                Object[] message = {
                        "Introduce DNI de conserje a eliminar: ", textField
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Entrada de Texto", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String userInput = textField.getText();
                    boolean borrado = a.borrarUsuario(userInput);
                    if(borrado)
                    {
                        JOptionPane.showMessageDialog(null,"El usuario ha sido borrada con exito");
                    }else {
                        JOptionPane.showMessageDialog(null,"Error al borrar al usuario");
                    }

                }
            }
        });
        pasarHuespedesAUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.pasarHuespedesAJson();
                JOptionPane.showConfirmDialog(null,"pasajeros guardados exitosamente!");
            }
        });
    }

}
