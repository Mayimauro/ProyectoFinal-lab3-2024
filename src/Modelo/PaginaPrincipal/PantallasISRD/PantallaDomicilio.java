package Modelo.PaginaPrincipal.PantallasISRD;

import Modelo.Persona.Domicilio;
import Modelo.Persona.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDomicilio extends JFrame{
    private JPanel pantallaDomicilio;
    private JTextField calle;
    private JTextField altura;
    private JTextField descripcion;
    private JTextField provincia;
    private JTextField localidad;
    private JTextField zipcode;
    private JButton finalizarButton;
    private JButton salirButton;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private ButtonGroup radioGroup;


    public PantallaDomicilio(Persona persona) {
        radioGroup = new ButtonGroup();
        radioGroup.add(siRadioButton);
        radioGroup.add(noRadioButton);
        radioGroup.add(finalizarButton);

        setTitle("Domicilio");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pantallaDomicilio);
        setLocationRelativeTo(null);


        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calle.getText().isEmpty() && !altura.getText().isEmpty() && !descripcion.getText().isEmpty() && !provincia.getText().isEmpty()
                        && !localidad.getText().isEmpty() && !zipcode.getText().isEmpty()){
                    if(siRadioButton.isSelected()) {
                        String sCalle = calle.getText();
                        String sAltura = altura.getText();
                        String sDescripcion = descripcion.getText();
                        String sProvincia = provincia.getText();
                        String sLocalidad = localidad.getText();
                        String sZipcode = zipcode.getText();
                        Domicilio d1 = new Domicilio(sCalle,sAltura,true,sDescripcion,sProvincia,sLocalidad,sZipcode);

                        persona.agregarDomicilio(d1);
                        persona.agregarAlArchivo(persona);
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                        JOptionPane.showMessageDialog(null,"persona: "+persona);
                        System.exit(0);
                        //falta haer que la persona creada persista

                    } else if (noRadioButton.isSelected()) {
                        String sCalle = calle.getText();
                        String sAltura = altura.getText();
                        String sProvincia = provincia.getText();
                        String sLocalidad = localidad.getText();
                        String sZipcode = zipcode.getText();
                        Domicilio d1 = new Domicilio(sCalle,sAltura,false,"0",sProvincia,sLocalidad,sZipcode);

                        persona.agregarDomicilio(d1);
                        persona.agregarAlArchivo(persona);
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                        JOptionPane.showMessageDialog(null,"persona: "+persona);

                        System.exit(0);
                        //falta haer que la persona creada persista
                    }else {
                        JOptionPane.showMessageDialog(null,"Por favor seleccione una opcion");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Faltan campos por completar");
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
