package Modelo.PaginaPrincipal.PantallasPCA;

import Enums.ETipoComida;
import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallaFrigobar;
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
                    PantallaFrigobar pf1 = new PantallaFrigobar(hotel.obtenerFrigobar(p));
                } else if(hotel.verificarEstadia(p.getDNI())==-1) {

                    JOptionPane.showMessageDialog(null,"La habitacion no cuenta con frigobar");
                }else {
                    JOptionPane.showMessageDialog(null,"No estas en el hotel");
                }

            }
        });
        servicioAlCuartoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(hotel.verificarEstadia(p.getDNI())==1)
                {
                    JComboBox<ETipoComida> comboBox = new JComboBox<>(ETipoComida.values());

                    int option =  JOptionPane.showConfirmDialog(null, comboBox, "Que desea pedir? ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (option == JOptionPane.OK_OPTION) {

                        boolean confirmado =  hotel.getEstadia(p.getDNI()).getServicioHabitacion().pedirComida((ETipoComida) comboBox.getSelectedItem());
                        if(confirmado)
                        {
                            JOptionPane.showMessageDialog(null,"la/el"+comboBox.getSelectedItem().toString()+" ha sido recibido y esta en preparacion, pronto le llegara a su habitacion");

                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"No estas en el hotel");
                }
            }
        });
        verGastosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              double frigoConsumo = hotel.getEstadia(p.getDNI()).getServicioHabitacion().getPrecioFinal();

              double estadiaPrecio = hotel.getEstadia(p.getDNI()).getPrecioFinal();

              double total = estadiaPrecio + frigoConsumo;

                JOptionPane.showMessageDialog(null,"consumos del frigobar y servicios al cuarto: "+frigoConsumo
                        +"\nTotal estadia: "+estadiaPrecio
                        +"\nPrecio final a pagar: "+total);

            }
        });
    }
}
