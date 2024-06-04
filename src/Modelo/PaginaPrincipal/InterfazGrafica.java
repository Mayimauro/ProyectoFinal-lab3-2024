package Modelo.PaginaPrincipal;

import Modelo.Hotel.Hotel;
import Modelo.Persona.Domicilio;
import Modelo.Persona.Persona;

import java.util.Scanner;


public class InterfazGrafica {
    private Scanner teclado;

    public InterfazGrafica() {
        this.teclado = new Scanner(System.in);;
    }

    public void Pantalla1()
    {
        System.out.printf("\n--Bienvenido a ConoComodin--\n");
        System.out.printf("\n--que desea hacer?--\n");
        System.out.printf("\n1)Iniciar secion.\n");
        System.out.printf("\n2)Registrarse.\n");
        System.out.printf("\n3)Salir.\n");
        int opcion = teclado.nextInt();
        switch (opcion){
            case 1:
                iniciarSecion();
                PantallaPasajero();
                break;
                case 2:
                    registro();
                    Pantalla1();
                    break;
                    case 3:
                        System.exit(0);
                        break;

        }
    }

    private void PantallaPasajero()
    {
        /**
         * Verificar si la persona registrada ya esta alquilando o esta por alquilar una habitacion
         */
        System.out.printf("\t\t\tBienvenido pasajero\n");
        System.out.printf("\t\t\tQue le gustaria hacer?\n");
        System.out.printf("\t\t\t1)Alquilar una habitacion.\n");
        System.out.printf("\t\t\t1)Alquilar una habitacion.\n");
        System.out.printf("\t\t\t2)Salir.\n");
        int opcion = teclado.nextInt();
        switch (opcion){
            case 1:

        }
    }



    private void iniciarSecion()
    {
        System.out.printf("\t\t\tEmal: ");
        String email = teclado.next();
        System.out.printf("\t\t\tContraseña: ");
        String pass = teclado.next();

        /***
         * completar contrasenaIncorrectaExeption
         * completar metodos para verificar persona
         * podemos hacer por mail para verificar admin y conserjes  osea
         * @admin.com y @conserje.com para los mails y que los que se registran no puedan usar esos mails
         *
         *falta
         * if(pasajero)
         *                 {
         *                     PantallaPasajero();
         *                 } else if (Conserje) {
         *                     PantallaConserje
         *                 }else {
         *                     PantallaAdmin
         *                 }
         */
    }

    private void registro()
    {
        System.out.printf("\nnombre: ");
        String nombre = teclado.next();
        System.out.printf("\napellido: ");
        String apellido = teclado.next();
        System.out.printf("\nMail: ");
        String mail = teclado.next();
        /**
         * todas las verificar se pueden pasar a una funcion aparte (trabajito para mas tarde)
         */
        if(verificarEmail(mail).contains("admin.com") || verificarEmail(mail).contains("conserje.com"))
        {
            System.out.printf("\nEl email no puede tener ese dominio\n"); //podemos crear excepcion
            System.out.printf("\nPorfavor ingrese uno valido\n");
            do {
                System.out.printf("\nMail: ");
                mail = teclado.next();
            }while(verificarEmail(mail).contains("admin.com") || verificarEmail(mail).contains("conserje.com"));
        }

        System.out.printf("\nContraseña: ");
        String contrasena = teclado.next();
        System.out.printf("\nVerificar Contraseña: ");
        String contraVerificar = teclado.next();

        /**
         * todas las verificar se pueden pasar a una funcion aparte (trabajito para mas tarde)
         */

        if(!contraVerificar.equals(contrasena))
        {
            System.out.printf("\nLas contraseñas no coinciden\n");
            do{
                System.out.printf("\nContraseña: ");
                contrasena = teclado.next();
                System.out.printf("\nVerificar Contraseña: ");
                contraVerificar = teclado.next();
            }while(!contraVerificar.equals(contrasena));
        }
        System.out.printf("\nDNI: ");
        String dni = teclado.next();


        System.out.printf("\nDomicilio: ");
        System.out.printf("\nCalle: ");
        String calle = teclado.next();
        System.out.printf("\naltura: ");
        String altura = teclado.next();
        System.out.printf("\nes departamento?");
        String esDepartamento = teclado.next();//si o no
        esDepartamento.toLowerCase();
        String departamento="/";
        boolean depto = false;
        if(esDepartamento.equals("si"))
        {
            System.out.printf("\nDepartamento: ");
            departamento = teclado.next();
            depto=true;
        }else {
            depto=false;
        }
        System.out.printf("\nLocalidad: ");
        String localidad = teclado.next();
        System.out.printf("\nProvincia: ");
        String provincia = teclado.next();
        System.out.printf("\nCodigo Postal: ");
        String codigoPostal = teclado.next();

    }


    public static String verificarEmail(String email) {
        if (email == null || !email.contains("@")) {
            return null;
        }
        String[] partes = email.split("@");
        if (partes.length != 2) {
            return null;
        }
        return partes[1];
    }


}
