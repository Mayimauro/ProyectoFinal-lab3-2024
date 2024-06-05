package Modelo.PaginaPrincipal.PantallasAlquiler;

import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.Persona.Persona;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class PantallaReserva extends JFrame{
    private JPanel reservaPanel;
    private JPanel jPanelCalendarioDesde;
    private JPanel jPanelCalendarioHasta;
    private JButton siguienteButton;
    private JButton cancelarButton;

    JCalendar calendario = new JCalendar();
    JCalendar calendario2 = new JCalendar();

    public PantallaReserva(Hotel hotel, Persona p) {


        setTitle("Fechas reserva");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(reservaPanel);
        setVisible(true);
        setLocationRelativeTo(null);

        jPanelCalendarioDesde.add(calendario);
        jPanelCalendarioHasta.add(calendario2);


        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d1 = calendario.getDate();

              LocalDate ld1 = Instant.ofEpochMilli(d1.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                Date d2 = calendario2.getDate();
                LocalDate ld2 = Instant.ofEpochMilli(d2.getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                Reserva r1 = new Reserva(ld1,ld2,p);
                if(r1.calcularDias()<0)
                {
                    JOptionPane.showMessageDialog(null, "Reserva fallida-seleccione fechas validas");
                }else{
                    AlquilarHabitacion alquilarHabitacion = new AlquilarHabitacion(hotel,p,r1);
                    setVisible(false);
                }

            }
        });
    }
}
