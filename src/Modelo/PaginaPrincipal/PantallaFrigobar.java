package Modelo.PaginaPrincipal;

import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Hotel.ServicioHabitacion;

import javax.swing.*;

public class PantallaFrigobar extends JFrame {


    private JPanel Jfrigobar;
    private JButton cancelarButton;
    private JButton confirmarButton;
    private JRadioButton cocuchaRadioButton;
    private JRadioButton snackRadioButton;
    private JRadioButton gomitasRadioButton;
    private JLabel StockCoca;
    private JLabel StockSnak;
    private JLabel StockGomitas;
    private ButtonGroup radiogroup;

    public PantallaFrigobar(ServicioHabitacion sh){


        radiogroup.add(cocuchaRadioButton);
        radiogroup.add(snackRadioButton);
        radiogroup.add(gomitasRadioButton);
        radiogroup.add(confirmarButton);


        setTitle("Frigobar");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(Jfrigobar);
        setLocationRelativeTo(null);


        StockCoca.setText("Stock: "+ sh.verStock(0));
        StockSnak.setText("Stock: "+ sh.verStock(1));
        StockGomitas.setText("Stock: "+ sh.verStock(2));






    }
}
