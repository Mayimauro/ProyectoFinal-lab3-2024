package Modelo.PaginaPrincipal;

import Modelo.Habitaciones.Habitacion;
import Modelo.Habitaciones.HabitacionEconomica;
import Modelo.Hotel.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PantallaEliminarHabitacion extends JFrame {
    private JPanel eliminarPanel;
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JButton cancelarButton;


    public PantallaEliminarHabitacion(Hotel a){
        setTitle("Eliminar Habitacion");
        setSize(800,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(eliminarPanel);
        setLocationRelativeTo(null);


        String habitacion = a.mostrarHabitacionesConNumero();
        String[] habitacionSplit = habitacion.split("\n");

        for(String h : habitacionSplit) {
            comboBox1.addItem(h);
        }

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedIndex() != -1 ) {

                    String habSelec = (String) comboBox1.getSelectedItem();
                    System.out.println("\n---" + habSelec + "--\n");
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(habSelec);
                    if (matcher.find()) {
                        System.out.println("\n---El primer número encontrado es: " + matcher.group() + "--\n");
                        int aux = Integer.parseInt(matcher.group());
                        if(a.existeHabitacion(aux))
                        {
                         a.eliminarHabitacion(aux);
                            JOptionPane.showMessageDialog(null,"Habitacion eliminado exitosamente");
                            setVisible(false);
                        }else {
                            JOptionPane.showMessageDialog(null,"el numero de habitacion no existe");
                        }
                    }
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
