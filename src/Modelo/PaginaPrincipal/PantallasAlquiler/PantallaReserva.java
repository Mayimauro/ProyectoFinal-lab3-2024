package Modelo.PaginaPrincipal.PantallasAlquiler;

import Modelo.Hotel.Hotel;
import Modelo.Persona.Persona;
import com.toedter.calendar.JCalendar;

import javax.swing.*;


public class PantallaReserva extends JFrame{
    private JPanel reservaPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel jPanelCalendario;

    public PantallaReserva(Hotel hotel, Persona p) {
        setTitle("Fechas reserva");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(reservaPanel);
        setLocationRelativeTo(null);

        JCalendar calendario = new JCalendar();
        jPanelCalendario.add(calendario);




    }
}
