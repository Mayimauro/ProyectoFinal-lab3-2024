package Modelo.PaginaPrincipal.PantallasAlquiler;

import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCancelarReserva extends JFrame{
    private JPanel JcancelarReserva;
    private JTextField textField1;
    private JButton cancelarReservaButton;
    private JButton salirButton;
    private JLabel reservas;
    private JComboBox comboBox1;


    public PantallaCancelarReserva(Hotel hotel, Persona persona) {
        setTitle("cancelar Reserva");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(JcancelarReserva);
        setLocationRelativeTo(null);




        for(Reserva r : hotel.listaReservaPasajero(persona)) {
            comboBox1.addItem(r);
        }

        cancelarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedIndex() != -1 )
                {

                    hotel.cancelarReserva((Reserva) comboBox1.getSelectedItem());
                    JOptionPane.showMessageDialog(null,"Reserva eliminada saticfactoriamente!");
                    setVisible(false);

                }else {
                    JOptionPane.showMessageDialog(null,"Por favor seleccione una reserva");
                }

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
