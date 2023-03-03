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
        double inputTemp= 0;

        //Decalraciones ejercicio 2

        //Declaraciones ejercicio 3
        boolean keyEj3= true;
        ArrayList<String> daw1= new ArrayList<String>();
        ArrayList<String> daw2= new ArrayList<String>();
        ArrayList<String> dam1= new ArrayList<String>();
        int controller;
        String nomGrupos[]= new String[] {"1ºDAW", "2ºDAW", "1ºDAM"};
        String grupoEnUso= new String();
        String nombreAlumno= new String();
        int posAlumno= -1;

        do {
            System.out.println("Que ejercicio quiere realizar?(-1 para salir del programa)");
            try{
                nav= Integer.parseInt(entrance.nextLine());
            }
            catch (InputMismatchException e){
                nav= Integer.MIN_VALUE;
                entrance.nextLine();
            }
            catch (NumberFormatException e){
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
                        catch (NumberFormatException e){
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
                        catch (NumberFormatException e){
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
                            catch (NumberFormatException e){
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
                                    if (grupoEnUso.equals("1ºDAW")){
                                        if (daw1.size()<30){
                                            System.out.println("Introduce el nombre del alumno:");
                                            nombreAlumno= entrance.nextLine();
                                            daw1.add(nombreAlumno);
                                            System.out.println("Alumno añadido!");
                                        }
                                        else {
                                            System.out.println("El grupo esta lleno");
                                        }
                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){
                                        if (daw2.size()<30){
                                            System.out.println("Introduce el nombre del alumno:");
                                            nombreAlumno= entrance.nextLine();
                                            daw2.add(nombreAlumno);
                                            System.out.println("Alumno añadido!");
                                        }
                                        else {
                                            System.out.println("El grupo esta lleno");
                                        }
                                    }
                                    else {
                                        if (dam1.size()<30){
                                            System.out.println("Introduce el nombre del alumno:");
                                            nombreAlumno= entrance.nextLine();
                                            dam1.add(nombreAlumno);
                                            System.out.println("Alumno añadido!");
                                        }
                                        else {
                                            System.out.println("El grupo esta lleno");
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Introduce el nombre del alumno que quieres dar de baja:");
                                    nombreAlumno= entrance.nextLine();
                                    if (grupoEnUso.equals("1ºDAW")){
                                        if (daw1.size()< 1){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (daw1.size() < 2){
                                            if (daw1.get(0).equals(nombreAlumno)){
                                                daw1.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
                                            posAlumno= -1;
                                            for (int i = 0; i < daw1.size(); i++) {
                                                if (daw1.get(i).equals(nombreAlumno)){
                                                    posAlumno= i;
                                                }
                                            }

                                            daw1.remove(posAlumno);
                                            System.out.println("Alumno dado de baja!");
                                        }
                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){
                                        if (daw2.size()< 1){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (daw2.size() < 2){
                                            if (daw2.get(0).equals(nombreAlumno)){
                                                daw2.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
                                            posAlumno= -1;
                                            for (int i = 0; i < daw2.size(); i++) {
                                                if (daw2.get(i).equals(nombreAlumno)){
                                                    posAlumno= i;
                                                }
                                            }

                                            daw2.remove(posAlumno);
                                            System.out.println("Alumno dado de baja!");
                                        }
                                    }
                                    else {
                                        if (dam1.size()< 1){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (dam1.size() < 2){
                                            if (dam1.get(0).equals(nombreAlumno)){
                                                dam1.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
                                            posAlumno= -1;
                                            for (int i = 0; i < dam1.size(); i++) {
                                                if (dam1.get(i).equals(nombreAlumno)){
                                                    posAlumno= i;
                                                }
                                            }

                                            dam1.remove(posAlumno);
                                            System.out.println("Alumno dado de baja!");
                                        }
                                    }
                                    break;

                                case 3:
                                    if (grupoEnUso.equals("1ºDAW")){

                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){

                                    }
                                    else {

                                    }
                                    break;

                                case 4:
                                    if (grupoEnUso.equals("1ºDAW")){
                                        if (daw1.size()>0){
                                            for (String e : daw1) {
                                                System.out.println("- "+e);
                                            }
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este curso");
                                        }
                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){
                                        if (daw2.size()>0){
                                            for (String e : daw2) {
                                                System.out.println("- "+e);
                                            }
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este curso");
                                        }
                                    }
                                    else {
                                        if (dam1.size()>0){
                                            for (String e : dam1) {
                                                System.out.println("- "+e);
                                            }
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este curso");
                                        }
                                    }
                                    break;

                                case 5:
                                    if (grupoEnUso.equals("1ºDAW")){
                                        if (daw1.size()>0){
                                            System.out.println("Todavia quedan "+(30-daw1.size())+" plazas libres en este curso");
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este grupo, todas las plazas estan libres");
                                        }
                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){
                                        if (daw2.size()>0){
                                            System.out.println("Todavia quedan "+(30-daw2.size())+" plazas libres en este curso");
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este grupo, todas las plazas estan libres");
                                        }
                                    }
                                    else {
                                        if (dam1.size()>0){
                                            System.out.println("Todavia quedan "+(30-dam1.size())+" plazas libres en este curso");
                                        }
                                        else {
                                            System.out.println("No hay alumnos en este grupo, todas las plazas estan libres");
                                        }
                                    }
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