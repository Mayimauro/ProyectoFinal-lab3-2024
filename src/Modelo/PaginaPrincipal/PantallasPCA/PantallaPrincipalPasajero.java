package Modelo.PaginaPrincipal.PantallasPCA;

import Enums.ETipoComida;
import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasAlquiler.PantallaCancelarReserva;
import Modelo.PaginaPrincipal.PantallasAlquiler.PantallaReserva;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.*;
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
    private JButton recargarFrigobarButton;

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

                    JLabel label1 = new JLabel(String.valueOf(hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(0)));
                    JLabel label2 = new JLabel(String.valueOf(hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(1)));
                    JLabel label3 = new JLabel(String.valueOf(hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(2)));

                    // Crear botones de radio
                    JRadioButton coca = new JRadioButton("Snack");
                    JRadioButton snack = new JRadioButton("Cocucha");
                    JRadioButton gomitas = new JRadioButton("Gomitas");

                    // Agrupar los botones de radio para que solo se pueda seleccionar uno
                    ButtonGroup group = new ButtonGroup();
                    group.add(coca);
                    group.add(snack);
                    group.add(gomitas);

                    // Crear panel y añadir componentes
                    JPanel panel = new JPanel(new GridLayout(4, 2));
                    panel.add(label1);
                    panel.add(coca);
                    panel.add(label2);
                    panel.add(snack);
                    panel.add(label3);
                    panel.add(gomitas);

                    // Añadir botones de confirmación y cancelación
                    int result = JOptionPane.showConfirmDialog(null, panel, "Custom Dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    // Manejar el resultado del diálogo
                    if (result == JOptionPane.OK_OPTION) {
                        String selectedOption = null;
                        if (coca.isSelected() && (hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(0) !=0)) {
                            selectedOption = coca.getText();
                            hotel.getEstadia(p.getDNI()).getServicioHabitacion().consumirProducto(selectedOption);
                            hotel.guardarEstadias();
                        } else if (snack.isSelected() && (hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(1) !=0))  {
                            selectedOption = snack.getText();
                            hotel.getEstadia(p.getDNI()).getServicioHabitacion().consumirProducto(selectedOption);
                            hotel.guardarEstadias();
                        } else if (gomitas.isSelected() && (hotel.getEstadia(p.getDNI()).getServicioHabitacion().verStock(2) !=0))  {
                            selectedOption = gomitas.getText();
                            hotel.getEstadia(p.getDNI()).getServicioHabitacion().consumirProducto(selectedOption);
                            hotel.guardarEstadias();
                        }else {
                            JOptionPane.showMessageDialog(null, "no hay stock");
                        }
                    } else {

                    }

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

                if(hotel.verificarEstadia(p.getDNI())==1 || hotel.verificarEstadia(p.getDNI())==-1)
                {
                    JComboBox<ETipoComida> comboBox = new JComboBox<>(ETipoComida.values());

                    int option =  JOptionPane.showConfirmDialog(null, comboBox, "Que desea pedir? ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (option == JOptionPane.OK_OPTION) {

                        boolean confirmado =  hotel.getEstadia(p.getDNI()).getServicioHabitacion().pedirComida((ETipoComida) comboBox.getSelectedItem());
                        if(confirmado)
                        {
                            JOptionPane.showMessageDialog(null,"La/el "+comboBox.getSelectedItem().toString()+" ha sido recibido y esta en preparacion, pronto lo enviaremos a su habitación.");
                            hotel.guardarEstadias();

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

                JOptionPane.showMessageDialog(null,"Consumos del frigobar y servicios a la habitación: $"+frigoConsumo
                        +"\nPrecio reserva: "+estadiaPrecio
                        +"\nPrecio final a pagar: $"+total);

            }
        });
        recargarFrigobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hotel.verificarEstadia(p.getDNI())==1)
                {

                    hotel.obtenerFrigobar(p).recargarFrigobar();
                    hotel.guardarEstadias();
                    JOptionPane.showMessageDialog(null,"Frigobar recargado con exito");


                } else if(hotel.verificarEstadia(p.getDNI())==-1) {
                JOptionPane.showMessageDialog(null,"La habitacion no cuenta con frigobar");
                }else {
                JOptionPane.showMessageDialog(null,"No estas en el hotel");
                }
            }
        });
    }
}
