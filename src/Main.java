import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main
 * Actividades de Programacion del I.E.S. Ana Luisa Benitez sobre las Arraylist en Java
 * @author Leonardo Jesús Figueroa Valdivia
 * @since 02/03/2003
 */
public class Main {
    public static void main(String[] args) {

        //Declaraciones globales
        Scanner entrance= new Scanner(System.in);
        boolean key= true;
        int nav;

        //Declaraciones ejercicio 1
        ArrayList<Double> temperaturasMeses= new ArrayList<Double>();
        String meses[]= new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        double inputTemp;

        //Decalraciones ejercicio 2

        //Declaraciones ejercicio 3
        boolean keyEj3= true;
        ArrayList<String> daw1= new ArrayList<String>();
        ArrayList<String> daw2= new ArrayList<String>();
        ArrayList<String> dam1= new ArrayList<String>();
        int controller;
        String nomGrupos[]= new String[] {"1ºDAW", "2ºDAW", "1ºDAM"};
        String grupoEnUso= new String();

        do {
            System.out.println("Que ejercicio quiere realizar?(-1 para salir del programa)");
            try{
                nav= Integer.parseInt(entrance.nextLine());
            }
            catch (InputMismatchException e){
                nav= Integer.MIN_VALUE;
                entrance.nextLine();
            }

            System.out.println("-------------------------------------------------");
            switch (nav){
                //Ejercicio 1
                case 1:
                    //Limpiamis la Arraylis, por si se repite el ejercicio
                    temperaturasMeses.clear();

                    System.out.println("Ejercicio 1");

                    //Pedimos la temperatura media de los meses
                    for (int i = 0; i < meses.length; i++) {
                        System.out.println("Introduce la temperatura media de "+meses[i].toLowerCase()+"?");
                        try {
                            inputTemp= Double.parseDouble(entrance.nextLine());
                        }
                        catch (InputMismatchException e){
                            inputTemp= Integer.MIN_VALUE;
                            entrance.nextLine();
                            i--;
                            System.out.println("ERROR, No se reconoce ese valor, intentelo de nuevo");
                        }
                        if (inputTemp!= Integer.MIN_VALUE){
                            temperaturasMeses.add(inputTemp);
                        }
                    }

                    //Mostramos el grafico de temperaturas por mes
                    for (int i = 0; i < meses.length; i++) {
                        System.out.print(meses[i]);
                        for (int j = 0; j < 14-meses[i].length(); j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < Math.abs(temperaturasMeses.get(i)); j++) {
                            if (temperaturasMeses.get(i)>0){
                                System.out.print("*");
                            }
                            else if (temperaturasMeses.get(i)<0) {
                                System.out.print("-");
                            }
                        }
                        System.out.println();
                    }
                    break;
                //Ejercicio 2
                case 2:
                    System.out.println("Ejercicio 2");
                    break;
                //Ejercicio 3
                case 3:
                    System.out.println("Ejercicio 3");

                    //Inicio del programa
                    do {
                        //Se piden ordenes
                        System.out.println("Que grupo quieres hacer?\n1- Modificar 1ºDAW\n2- Modificar 2ºDAW\n3- Modificar 1ºDAM\n4- Salir");
                        try{
                            controller= Integer.parseInt(entrance.nextLine());
                        }
                        catch (InputMismatchException e){
                            controller= Integer.MIN_VALUE;
                            entrance.nextLine();
                        }

                        //Se comprueba que la orden existe
                        switch (controller){

                            case 4:
                                System.out.println("Adios!");
                                keyEj3= false;
                                continue;

                            case 1:
                                System.out.println("Modificando 1ºDAW");
                                grupoEnUso= nomGrupos[0];
                                break;

                            case 2:
                                System.out.println("Modificando 2ºDAW");
                                grupoEnUso= nomGrupos[1];
                                break;

                            case 3:
                                System.out.println("Modificando 1ºDAM");
                                grupoEnUso= nomGrupos[2];
                                break;

                            default:
                                System.out.println("No se reconoce la orden");
                                System.out.println("-------------------------------------------");
                                continue;
                        }

                        System.out.println("-------------------------------------------");
                        do {
                            System.out.println("Que quieres hcaer con "+grupoEnUso+"?\n1- Dar alta a un alumno\n2- Dar baja a un alumno" +
                                    "\n3- Cambiar el nombre de un alumno\n4- Mostrar la lista de alumnos\n5- Mostrar las plazas bacantes\n6- Salir");

                            try{
                                controller= Integer.parseInt(entrance.nextLine());
                            }
                            catch (InputMismatchException e){
                                controller= Integer.MIN_VALUE;
                                entrance.nextLine();
                            }

                            switch (controller){
                                case 6:
                                    System.out.println("Saliendo!");
                                    keyEj3= false;
                                    controller= Integer.MAX_VALUE;
                                    break;

                                case 1:
                                    System.out.println("Opcion 1");
                                    break;

                                default:
                                    System.out.println("No se reconoce la orden");
                            }

                            if (keyEj3){
                                System.out.println("-------------------------------------------");
                            }
                        }while (keyEj3);


                        if (controller == Integer.MAX_VALUE){
                            keyEj3= true;
                        }
                        System.out.println("-------------------------------------------");

                    }while (keyEj3);
                    break;
                //Salir del programa
                case -1:
                    key= false;
                    System.out.println("ADIOS!");
                    break;
                //Caso de error
                case Integer.MIN_VALUE:
                    System.out.println("ERROR, No se reconoce ese valor");
                    break;
                //Se introduce un caso no especificado
                default:
                    System.out.println("No existe ese ejercicio");
            }

            System.out.println("-------------------------------------------------");

        }while(key);
    }
}