package Modelo.PaginaPrincipal.PantallasPCA;

import Enums.EEstadoHabitacion;
import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasAlquiler.PantallaReserva;
import Modelo.PaginaPrincipal.PantallasISRD.PantallaRegistro;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PantallaPrincipalConserje extends JFrame {


    private JPanel jpanelConserje;
    private JLabel textBienvenida;
    private JButton realizarCheckinButton;
    private JButton crearPasajeroButton;
    private JButton realizarCheckOutButton;
    private JButton verHabitacionesOcupadasButton;
    private JButton cambiarEstadoDeHabitacionButton;
    private JButton salirButton;
    private JButton realizarReservaButton;

    public PantallaPrincipalConserje(Hotel hotel,String nombre) {
        setTitle("Conserje Hotel");
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(jpanelConserje);
        setLocationRelativeTo(null);

        textBienvenida.setText("Bienvenido conserje "+nombre+"!");


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        crearPasajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaRegistro pr1 = new PantallaRegistro();
            }
        });
        realizarCheckinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = new JTextField(10);
                Object[] message = {
                        "Introduce DNI para confirmar checkIn: ", textField
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Entrada de Texto", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String userInput = textField.getText();

                  boolean confirmada =  hotel.confirmarEstadia(userInput);
                  if(confirmada)
                  {
                      JOptionPane.showMessageDialog(null, "Estadia confirmada con exito");
                  }else {
                      JOptionPane.showMessageDialog(null, "Estadia incorrecta");
                  }

                }
            }
        });
        verHabitacionesOcupadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "todas las habitaciones: "+hotel.mostrarHabitacionesNoDisponibles());
            }
        });

        cambiarEstadoDeHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String habitacion = hotel.mostrarHabitacionesConNumero();
                String[] habitacionSplit = habitacion.split("\n");
                JComboBox<String> comboBox = new JComboBox<>(habitacionSplit);
                JComboBox<EEstadoHabitacion> comboBox1 = new JComboBox<>(EEstadoHabitacion.values());

                Object[] message = {
                        "Selecciona una opción:", comboBox,
                        "Seleccione una opción:", comboBox1
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Entrada de ComboBox y Texto", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    EEstadoHabitacion selectedOption1 = (EEstadoHabitacion) comboBox1.getSelectedItem();

                    String habSelec = (String) comboBox.getSelectedItem();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(habSelec);

                    if (matcher.find()) {
                        int aux = Integer.parseInt(matcher.group());
                        hotel.cambiarEstadoHabitacion(aux, selectedOption1);
                        JOptionPane.showMessageDialog(null, "estado cambiado con exito!");
                    }
                }
            }
        });
        realizarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = new JTextField(10);
                Object[] message = {
                        "Introduce DNI para confirmar checkIn: ", textField
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Entrada de Texto", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String userInput = textField.getText();

                    Persona persona = hotel.buscarPersonaxDNI(userInput);

                    if(persona!=null)
                    {
                        PantallaReserva r1 = new PantallaReserva(hotel,persona);

                    }else {
                        JOptionPane.showMessageDialog(null, "DNI no encontrado");
                    }




                }
            }
        });
    }
}
