package Modelo.PaginaPrincipal.PantallasAlquiler;

import Modelo.Habitaciones.Habitacion;
import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlquilarHabitacion extends JFrame{
    private JPanel alquilarHabi;
    private JComboBox<String> comboBox1;
    private JLabel habitacionSeleccionada;
    private JButton siguienteButton;
    private JButton cancelarButton;
    private JLabel habitaciones;

    public AlquilarHabitacion(Hotel hotel, Persona p, Reserva r1) {



        String habitacion = hotel.mostrarHabitacionesDisponibles();
        String[] habitacionSplit = habitacion.split("\n");

        String habitacionesxFecha = hotel.mostrarHabitacionesDisponiblesXFecha(r1.getFechaIngreso(),r1.getFechaSalida());
        String[] habitacionSplit2 = habitacionesxFecha.split("\n");


        for(String h : habitacionSplit) {
            comboBox1.addItem(h);
        }

        for(String h : habitacionSplit2) {
            comboBox1.addItem(h);
        }

        setTitle("Alquilar Habitacion");
        setSize(900,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(alquilarHabi);
        setLocationRelativeTo(null);



        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox1.getSelectedItem();
                habitacionSeleccionada.setText("selecciono la : "+seleccion);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedIndex() != -1 ){

                    String habSelec = (String) comboBox1.getSelectedItem();

                    System.out.println("\n---"+habSelec+"--\n");
                    Pattern pattern = Pattern.compile("\\d+");

                    Matcher matcher = pattern.matcher(habSelec);

                    if (matcher.find()) {
                        System.out.println("\n---El primer número encontrado es: " + matcher.group()+"--\n");
                        int aux = Integer.parseInt(matcher.group());
                        r1.asignarHabitacion(hotel.getHabitacion(aux)); //esta mal arreglar
                    } else {
                        System.out.println("No se encontraron números en el texto.");
                    }

                    hotel.agregarReserva(r1);
                    JOptionPane.showMessageDialog(null,"Alquiler completo");
                    JOptionPane.showMessageDialog(null,"precio final de la reserva: "+ r1.precioFinal());
                    setVisible(false);

                }else {
                    JOptionPane.showMessageDialog(null,"Por favor seleccione una habitacion");
                }
            }
        });
    }


}
