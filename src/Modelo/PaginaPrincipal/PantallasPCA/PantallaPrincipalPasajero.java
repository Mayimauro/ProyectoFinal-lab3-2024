package Modelo.PaginaPrincipal.PantallasPCA;

import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasAlquiler.PantallaReserva;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipalPasajero extends JFrame {


    private JPanel pasajeorPanel;
    private JButton alquilarUnaHabitacionButton;
    private JButton alquileresButton;
    private JButton frigobarButton;
    private JButton servicioAlCuartoButton1;
    private JButton realizarCheckInButton;
    private JButton verGastosButton;
    private JButton salirButton;
    private JButton cancelarReservaButton;

    public PantallaPrincipalPasajero(Hotel hotel, Persona p) {

        setTitle("Bienvenido "+p.getNombre()+"!");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pasajeorPanel);
        setLocationRelativeTo(null);

        alquilarUnaHabitacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaReserva reserva = new PantallaReserva(hotel,p);
            }
        });
        realizarCheckInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //completar
            }
        });
        alquileresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,hotel.mostrarAlquileresPorPasajero(p));
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
