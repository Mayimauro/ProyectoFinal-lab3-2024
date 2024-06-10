package Modelo.PaginaPrincipal;

import Enums.ETipoHabitacion;
import Modelo.Habitaciones.HabitacionEconomica;
import Modelo.Hotel.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaAgregarHabitacion extends JFrame {
    private JRadioButton economicaRadioButton;
    private JRadioButton estandarRadioButton;
    private JRadioButton premiumRadioButton;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton siRadioButton1;
    private JRadioButton noRadioButton1;
    private JRadioButton siRadioButton2;
    private JRadioButton noRadioButton2;
    private JRadioButton siRadioButton3;
    private JRadioButton noRadioButton3;
    private JPanel pantallaAgHab;
    private JButton finalizarButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private ButtonGroup radioGroupTipoHab;
    private ButtonGroup radioGroupAire;
    private ButtonGroup radioGroupVistaMar;
    private ButtonGroup radioGroupBañera;
    private ButtonGroup radioGroupJacuzzi;


    public PantallaAgregarHabitacion(Hotel a){
        setTitle("Agregar Habitacion");
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pantallaAgHab);
        setLocationRelativeTo(null);

        radioGroupAire = new ButtonGroup();
        radioGroupVistaMar = new ButtonGroup();
        radioGroupBañera = new ButtonGroup();
        radioGroupJacuzzi = new ButtonGroup();
        radioGroupTipoHab = new ButtonGroup();
        radioGroupTipoHab.add(economicaRadioButton);
        radioGroupTipoHab.add(estandarRadioButton);
        radioGroupTipoHab.add(premiumRadioButton);
        radioGroupAire.add(siRadioButton);
        radioGroupAire.add(noRadioButton);
        radioGroupVistaMar.add(siRadioButton1);
        radioGroupVistaMar.add(noRadioButton1);
        radioGroupBañera.add(siRadioButton2);
        radioGroupBañera.add(noRadioButton2);
        radioGroupJacuzzi.add(siRadioButton3);
        radioGroupJacuzzi.add(noRadioButton3);
        radioGroupAire.add(finalizarButton);
        radioGroupVistaMar.add(finalizarButton);
        radioGroupBañera.add(finalizarButton);
        radioGroupJacuzzi.add(finalizarButton);
        radioGroupTipoHab.add(finalizarButton);


        comboBox1.addItem(ETipoHabitacion.CUADRUPLE_TIPO_1);
        comboBox1.addItem(ETipoHabitacion.CUADRUPLE_TIPO_2);
        comboBox1.addItem(ETipoHabitacion.DOBLE_TIPO_1);
        comboBox1.addItem(ETipoHabitacion.DOBLE_TIPO_2);
        comboBox1.addItem(ETipoHabitacion.TRIPLE);


        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int numHab = a.numeroHabitacion();

                if(economicaRadioButton.isSelected()){
                    if(siRadioButton1.isSelected()){
                        HabitacionEconomica a1 = new HabitacionEconomica(numHab, (ETipoHabitacion) comboBox1.getSelectedItem(),true);
                        a.agregarHabitacion(numHab,a1);
                    }else {
                        HabitacionEconomica a1 = new HabitacionEconomica(numHab, (ETipoHabitacion) comboBox1.getSelectedItem(),true);
                    }


                } else if (estandarRadioButton.isSelected()) {

                }else {

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
