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


        HashMap<Integer,Habitacion> a1 = hotel.getListaHabitaciones();
        a1.forEach((key, value) -> {
            comboBox1.addItem("numero: " + key + ", habitacion: " + value);
        });

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

                    //TRABAJAR CON JSON


                    String habSelec = (String) comboBox1.getSelectedItem();

                    System.out.println("\n---"+habSelec+"--\n");
                    Pattern pattern = Pattern.compile("\\d+");
                    // Creamos el matcher a partir de la cadena
                    Matcher matcher = pattern.matcher(habSelec);
                    // Si encontramos un número, intentamos devolverlo como entero
                        String numeroStr = matcher.group();
                        int aux= Integer.parseInt(numeroStr);


                    r1.asignarHabitacion(hotel.getHabitacion(aux)); //esta mal arreglar

                    hotel.agregarReserva(r1);
                    JOptionPane.showMessageDialog(null,"Alquiler completo");
                    JOptionPane.showMessageDialog(null,"detalles :"+ r1);
                    setVisible(false);

                }else {
                    JOptionPane.showMessageDialog(null,"Por favor seleccione una habitacion");
                }
            }
        });
    }


}
