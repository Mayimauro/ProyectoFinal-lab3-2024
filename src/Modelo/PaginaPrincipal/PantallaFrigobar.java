package Modelo.PaginaPrincipal;

import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Habitaciones.Frigobar.Producto;
import Modelo.Hotel.ServicioHabitacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        radiogroup = new ButtonGroup();

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


        StockCoca.setText("Stock: "+ sh.verStock(1));
        StockSnak.setText("Stock: "+ sh.verStock(2));
        StockGomitas.setText("Stock: "+ sh.verStock(3));


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radiogroup.getSelection() != null){
                    if(cocuchaRadioButton.isSelected()){
                        sh.consumirProducto("Cocucha");
                        JOptionPane.showMessageDialog(null,"Gracias, el gasto se vera reflejado en el boton gastos");
                    } else if (snackRadioButton.isSelected()) {
                        sh.consumirProducto("Snack");
                        JOptionPane.showMessageDialog(null,"Gracias, el gasto se vera reflejado en el boton gastos");
                    }else if (gomitasRadioButton.isSelected()) {
                        sh.consumirProducto("Gomitas");
                        JOptionPane.showMessageDialog(null,"Gracias, el gasto se vera reflejado en el boton gastos");
                    }
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"seleccione una opcion a consumir");
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
