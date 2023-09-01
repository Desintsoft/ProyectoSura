package org.example;


import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);

        //***********************************************************(arreglos)*****************************************
        String [] nombresEspecialistas = new String[100];
        String [] cedulasEspecialistas = new String[100];
        String [] especialidades = new String[100];
        String [] fechasIngresoEspecialistas = new String[100];
        Double [] salariosEspecialistas = new Double[100];
        //*********************************************************(declaracion de variables)***************************
        Double horasTrabajadasEspecialistas=0.0;
        Double tarifaHoraEspecialista = 150000.0;
        String opcion = "";
        Integer opcionRol = 0 ;
        Integer opcionAdmin = 0 ;
        Integer opcionEspecialista = 0 ;
        Integer opcionPaciente = 0 ;

        Integer contador = 0;
        Integer posicion = 0;
        String fechaRetiroEspecialista = null;
        String filtroCedula;
        //**********************************************************(Proceso)*******************************************

        System.out.println("\n\n");
        System.out.println("\u001B[44m\u001B[30m");
        System.out.println(" BIENVENIDO A EPS SURA \n");

        do {
         //**********************************do-while para menu general de roles*************************************
            System.out.println("\u001B[0m\n Apreciado usuario elije una de las siguientes opciones \n");

            System.out.println("\u001B[47m\u001B[30m");
            System.out.println(" 1------ADMINISTRADOR");
            System.out.println(" 2------ESPECIALISTA");
            System.out.println(" 3------PACIENTE");
            System.out.println(" 4------SALIR ");

            do {
                System.out.print("\u001B[0m Ingrese su opcion: ");
                opcion = teclado.next().toLowerCase(Locale.ROOT);

             //************************condicion que evalua si la opcion es valida o no******************************
                if (opcion.matches("1|2|3|4")){
                    System.out.print("\u001B[44m\u001B[30m");
                    System.out.print("");
                }else {
                    System.out.println("\u001B[0m\u001B[31m");
                    System.out.println(" Esta opcion es invalida por favor vuelve a intentarlo");
                }
            }while (!opcion.matches("1|2|3|4"));

            opcionRol = Integer.parseInt(opcion);


            switch (opcionRol){


                case 1:

                    String clave = "";

                    do {
                        System.out.println("\u001B[44m\u001B[30m Estas en la seccion de administradores  ");
                        System.out.println("\u001B[0m Ingrese la clave: ");
                        clave = teclado.next();

                        //********condicion que evalua si la opcion es valida o no**********
                        if (clave.matches("Juanjo2023.|Desarrollo2023")){

                            System.out.print("\n ");
                        }else {
                            System.out.println("\u001B[0m\u001B[31m");
                            System.out.println("Clave incorrecta");
                        }
                    }while (!clave.matches("Juanjo2023.|Desarrollo2023"));
                     do {
                        System.out.println(" ");
                        System.out.println("\u001B[30m\u001B[44m");
                        System.out.println(" ADMINISTRADOR ");
                        System.out.println("\u001B[47m\u001B[30m");
                        System.out.println(" 1------- Registrar especialista");
                        System.out.println(" 2------- Acceder a la base de datos de los especialidades");
                        System.out.println(" 3------- Acceder a la informacion de un especialista");
                        System.out.println(" 4------- Retirar especialista");
                        System.out.println(" 5--------Salir\n");

                        do {
                            System.out.print("\u001B[0m Ingrese su opcion: ");
                            opcion = teclado.next().toLowerCase(Locale.ROOT);

                            if (opcion.matches("1|2|3|4|5")){
                                System.out.println("\u001B[44m\u001B[30m");
                            }else {
                                System.out.println("\u001B[0m\u001B[31m");
                                System.out.println(" Esta opcion es invalida por favor vuelve a intentarlo");
                            }
                        }while (!opcion.matches("1|2|3|4|5"));

                        opcionAdmin = Integer.parseInt(opcion);

                         //nos descuenta una posicion ya que los arreglos empiezan en 0 esta variable permitira ingresar infomacion en esta posicion
                         if (opcionAdmin == 1){
                             contador = contador+1;
                             posicion = contador-1;
                         }


                         switch (opcionAdmin){
                            case 1:
                                System.out.println(" Nuevo registro");

                                System.out.print("\u001B[0m Ingrese cedula: ");
                                // Evalua que solo sean numeros
                                boolean numerocedula=false;
                                do {
                                    cedulasEspecialistas [posicion] = teclado.next();
                                    numerocedula = (cedulasEspecialistas[posicion] != null && cedulasEspecialistas[posicion].matches("[0-9]+"));
                                    if (numerocedula==true) {
                                        System.out.print(" ");
                                    }else{
                                        System.out.print("\u001B[0m\u001B[31m");
                                        System.out.println(" numero de cedula invalido, vuelva a ingresarlo");
                                        System.out.print("\u001B[0m Ingrese cedula: ");
                                    }
                                }while (numerocedula!=true);

                                System.out.print("\u001B[0mIngrese nombres y apellidos: ");
                                teclado=new Scanner(System.in);
                                nombresEspecialistas [posicion] = teclado.nextLine();

                                System.out.print(" Ingrese especialidad: ");
                                especialidades [posicion] = teclado.nextLine();

                                System.out.print(" SALARIO: Por favor ingrese el reporte de horas laboradas de este especialista: ");
                                horasTrabajadasEspecialistas= teclado.nextDouble();

                                salariosEspecialistas[posicion] = horasTrabajadasEspecialistas * tarifaHoraEspecialista;

                                System.out.print("\u001B[0m Ingrese fecha de ingreso: ");
                                teclado=new Scanner(System.in);
                                fechasIngresoEspecialistas [posicion] = teclado.nextLine();
                            break;

                            case 2:
                                System.out.println(" Base de datos de especialista \n");
                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                                }else {

                                    System.out.print("\n\u001B[0m\u001B[37m | NOMBRE        |   ESPECIALIDAD |\n");

                                    for (int especialista = 0; especialista <= posicion; especialista++) {
                                        if (cedulasEspecialistas[especialista].equals(" ")) {
                                            System.out.println("\u001B[0m retirado " + fechaRetiroEspecialista);
                                        } else {
                                            System.out.println(" \u001B[37m|  \u001B[36m" + nombresEspecialistas[especialista] + "  \u001B[37m|    \u001B[33m" + especialidades[especialista] + "  \u001B[37m|");
                                        }
                                    }
                                }
                            break;

                            case 3:
                                System.out.println(" Informacion detallada de un especialista ");

                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                                }else {
                                    System.out.print("\u001B[0m Ingrese el numero de cedula que desea consultar: ");

                                    numerocedula = false;
                                    do {
                                        filtroCedula = teclado.next();
                                        numerocedula = (filtroCedula != null && filtroCedula.matches("[0-9]+"));
                                        if (numerocedula == true) {
                                            System.out.print(" ");
                                        } else {
                                            System.out.print("\u001B[0m\u001B[31m");
                                            System.out.println(" numero de cedula invalido, vuelva a ingresarlo");
                                        }
                                    } while (numerocedula != true);


                                    for (int especialista = 0; especialista <= posicion; especialista++) {
                                        if (cedulasEspecialistas[especialista].equals(filtroCedula)) {
                                            System.out.println("\n\u001B[37m| \u001B[0mMEDICO           |  CEDULA    |   ESPECIALIDAD  |  SALARIO   |  FECHA-INGRESO \u001B[37m| \n");
                                            System.out.println("\u001B[37m| \u001B[36m" + nombresEspecialistas[especialista] +
                                                    "\u001B[37m|   \u001B[32m" + cedulasEspecialistas[especialista] +
                                                    "\u001B[37m|  \u001B[37m    \u001B[33m" + especialidades[especialista] +
                                                    "\u001B[37m|   \u001B[34m" + salariosEspecialistas[especialista] +
                                                    "\u001B[37m|  \u001B[35m" + fechasIngresoEspecialistas[especialista] + "  \u001B[37m|\n");
                                        }
                                    }
                                }
                            break;

                            case 4:
                                System.out.println(" Retiro de un especialista\n");

                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                                }else {

                                    System.out.print("\u001B[0m Ingrese cedula del especialista a retirar: ");
                                    filtroCedula = teclado.next();
                                    System.out.print(" Digite la fecha del retiro: ");
                                    fechaRetiroEspecialista = teclado.next();

                                    for (int especialista = 0; especialista <= posicion; especialista++) {

                                        if (cedulasEspecialistas[especialista].equals(filtroCedula)) {

                                            cedulasEspecialistas[especialista] = " ";
                                            nombresEspecialistas[especialista] = (" ");
                                            especialidades[especialista] = (" ");
                                            fechasIngresoEspecialistas[especialista] = (" ");
                                            salariosEspecialistas[especialista] = 0.0;
                                        }
                                    }
                                }
                            break;

                            case 5:
                                System.out.println(" Saliendo de seccion administradores");
                            break;

                            default:
                                System.out.print("\u001B[0m\u001B[31m");
                                System.out.println(" Opcion invalida por favor vuelve a intentarlo");
                            break;
                        }
                    }while (opcionAdmin!=5);
                break;

                case 2:
                    do {

                        System.out.print("\u001B[44m\u001B[30m");
                        System.out.println(" ESPECIALISTA ");
                        System.out.println("\u001B[47m\u001B[30m");
                        System.out.println(" 1-----Reporte de horas trabajadas este mes");
                        System.out.println(" 2-----Consultar nomina");
                        System.out.println(" 3-----Accede a la base de datos de los especialista");
                        System.out.println(" 4-----Salir");

                        do {
                            System.out.print("\u001B[0m Ingrese su opcion: ");
                            opcion = teclado.next().toLowerCase(Locale.ROOT);

                            if (opcion.matches("1|2|3|4")){
                                System.out.print("\u001B[44m\u001B[30m");
                            }else {
                                System.out.println("\u001B[0m\u001B[31m");
                                System.out.println(" Esta opcion es invalida por favor vuelve a intentarlo");
                            }
                        }while (!opcion.matches("1|2|3|4"));

                        opcionEspecialista = Integer.parseInt(opcion);


                        switch (opcionEspecialista) {


                            case 1:
                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");


                                } else {
                                    System.out.println(" Reporte de horas trabajadas este mes");
                                    System.out.println("\u001B[0m Las horas que tiene su reporte son:" + horasTrabajadasEspecialistas);
                                }
                            break;

                            case 2:
                                System.out.println(" Consultar nomina");

                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                                }else {
                                    Double salario = horasTrabajadasEspecialistas * tarifaHoraEspecialista;
                                    System.out.println("\u001B[0m Nomina $ " + salario);
                                    Double nomina = salario - (salario * 0.04);
                                    System.out.println("\u001B[0m Su nomina con retencion del 4% es de $ " + nomina);
                                }
                            break;

                            case 3:
                                System.out.println(" Acceso a base de datos de especialista");

                                if (contador==0){
                                    System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                                }else {

                                    System.out.print("\n\u001B[0m\u001B[37m | NOMBRE        |   ESPECIALIDAD |\n");

                                    for (int especialista = 0; especialista <= posicion; especialista++) {
                                        if (cedulasEspecialistas[especialista].equals(" ")) {
                                            System.out.println("\u001B[0m ");
                                        }  else {
                                            System.out.println(" \u001B[37m|  \u001B[36m" + nombresEspecialistas[especialista] + "  \u001B[37m|    \u001B[33m" + especialidades[especialista] + "  \u001B[37m|");
                                        }
                                    }
                                }
                            break;

                            case 4:
                                System.out.println(" Saliendo de seccion especialista");
                            break;


                            default:
                                System.out.println("\u001B[0m\u001B[31m");
                                System.out.println(" Opcion invalida por favor vuelve a intentarlo");
                                break;
                        }
                    }while (opcionEspecialista!=4);
                 break;


                case 3:
                    do{
                        System.out.print("\u001B[44m\u001B[30m");
                        System.out.println(" PACIENTES ");
                        System.out.println("\u001B[47m\u001B[30m");
                        System.out.println(" 1-----Acceder a la base de datos de los especialista");
                        System.out.println(" 2-----Salir");
                        do {
                            System.out.print("\u001B[0m Ingrese su opcion: ");
                            opcion = teclado.next().toLowerCase(Locale.ROOT);

                            if (opcion.matches("1|2")){
                                System.out.println("\u001B[44m\u001B[30m");
                            }else {
                                System.out.println("\u001B[0m\u001B[31m");
                                System.out.println(" Esta opcion es invalida por favor vuelve a intentar");
                            }
                        }while (!opcion.matches("1|2"));

                    opcionPaciente = Integer.parseInt(opcion);


                    switch (opcionPaciente) {


                        case 1:
                            System.out.println(" Acceso a base de datos de especialista");

                            if (contador==0){
                                System.out.println("\u001B[0m\n\u001B[31m Aun no hay registros en la base de datos\n");
                            }else {

                                System.out.print("\n\u001B[0m\u001B[37m | NOMBRE        |   ESPECIALIDAD |\n");

                                for (int especialista = 0; especialista <= posicion; especialista++) {
                                    if (cedulasEspecialistas[especialista].equals(" ")) {
                                        System.out.println("\u001B[0m ");
                                    } else {
                                        System.out.println(" \u001B[37m|  \u001B[36m" + nombresEspecialistas[especialista] + "  \u001B[37m|    \u001B[33m" + especialidades[especialista] + "  \u001B[37m|");
                                    }
                                }
                            }
                            break;

                        case 2:
                            System.out.println(" Saliendo de seccion pacientes");
                            break;
                        default:
                            System.out.println("\u001B[0m\u001B[31m");
                            System.out.println(" Opcion invalida por favor cuelva a intentar");
                        break;
                    }
                    }while (opcionPaciente!=2);
                break;

                case 4:
                    System.out.println(" FIN PROGRAMA");
                    System.out.println(" Saliendo");
                break;

                default:
                    System.out.println("\u001B[0m\u001B[31m");
                    System.out.println("Opcion invalida por favor vuelva a intentarlo");
                break;
            }
        }while (opcionRol!=4);








    }
}