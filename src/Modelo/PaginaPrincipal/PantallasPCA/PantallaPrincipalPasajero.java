package Modelo.PaginaPrincipal.PantallasPCA;

import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasAlquiler.PantallaCancelarReserva;
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
        alquileresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hotel.mostrarAlquileresPorPasajero(p).isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "No hay reservas hechas");
                }else{
                    JOptionPane.showMessageDialog(null,hotel.mostrarAlquileresPorPasajero(p));
                }

            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cancelarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(hotel.verificarQueTieneReserva(p))
                {
                    PantallaCancelarReserva cr1 = new PantallaCancelarReserva(hotel,p);
                }else {
                    JOptionPane.showMessageDialog(null,"no tenes reservas para cancelar");
                }
            }
        });

        frigobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hotel.verificarEstadia(p.getDNI())==1)
                {

                } else if(hotel.verificarEstadia(p.getDNI())==-1) {

                    JOptionPane.showMessageDialog(null,"La habitacion no cuenta con frigobar");
                }else {
                    JOptionPane.showMessageDialog(null,"No estas en el hotel todavia");
                }

            }
        });
        servicioAlCuartoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verGastosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
