import java.util.ArrayList;
import java.util.Collections;
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
        boolean sKey= true;
        int controller= 0;

        //Declaraciones ejercicio 1
        ArrayList<Double> temperaturasMeses= new ArrayList<Double>();
        String meses[]= new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        double inputTemp= 0;

        //Decalraciones ejercicio 2
        ArrayList<Integer> mesas= new ArrayList<Integer>();
        int numClientes= 0;
        boolean compMesa= false;
        int numMesa= 0;


        //Declaraciones ejercicio 3
        ArrayList<String> daw1= new ArrayList<String>();
        ArrayList<String> daw2= new ArrayList<String>();
        ArrayList<String> dam1= new ArrayList<String>();
        String nomGrupos[]= new String[] {"1ºDAW", "2ºDAW", "1ºDAM"};
        String grupoEnUso= new String();
        String nombreAlumno= new String();
        int posAlumno= -1;
        String auxOrden= new String();


        do {
            System.out.println("Que ejercicio quiere realizar?(-1 para salir del programa)");
            try{
                nav= Integer.parseInt(entrance.nextLine());
            }
            catch (RuntimeException e){
                nav= Integer.MIN_VALUE;
                entrance.nextLine();
            }

            System.out.println("-------------------------------------------------");
            switch (nav){
                //Ejercicio 1
                case 1:
                    temperaturasMeses.clear();

                    System.out.println("Ejercicio 1");

                    //Pedimos la temperatura media de los meses
                    for (int i = 0; i < meses.length; i++) {
                        System.out.println("Introduce la temperatura media de "+meses[i].toLowerCase()+"?");
                        try {
                            inputTemp= Double.parseDouble(entrance.nextLine());
                        }
                        catch (RuntimeException e){
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
                    mesas.clear();
                    sKey= true;

                    System.out.println("Ejercicio 2");


                    //Añadimos 5 comensales
                    for (int i = 0; i < 5; i++) {
                        mesas.add((int) (Math.random()*5));
                    }

                    //Empieza el menu
                    System.out.println("Bienvenido!");
                    do {
                        System.out.println("Que quieres hacer?");
                        System.out.println("1- Mostrar mesas actuales\n2- Pedir mesa\n3- Salir");
                        try{
                            controller= Integer.parseInt(entrance.nextLine());
                        }
                        catch (RuntimeException e){
                            controller= Integer.MIN_VALUE;
                            entrance.nextLine();
                        }

                        switch (controller){
                            //Salir del programa
                            case 3:
                                sKey= false;
                                System.out.println("Adios!");
                                break;

                            //Mostrar mesas
                            case 1:
                                System.out.print("| Num mesa     ");
                                for (int i = 1; i <= mesas.size(); i++) {
                                    System.out.print("| "+i+" ");
                                }
                                System.out.print("|\n| Num clientes ");
                                for (int i = 0; i < mesas.size(); i++) {
                                    if (i<9){
                                        System.out.print("| "+mesas.get(i)+" ");
                                    }
                                    else {
                                        System.out.print("| "+mesas.get(i)+"  ");
                                    }
                                }
                                System.out.println("|");
                                break;

                            //Pedir mesa
                            case 2:
                                compMesa= false;

                                if (mesas.size()<15){

                                    //Pedimos el número
                                    System.out.println("Introduce el numero de personas que son:");
                                    try{
                                        numClientes= Integer.parseInt(entrance.nextLine());
                                    }
                                    catch (RuntimeException e){
                                        numClientes= Integer.MIN_VALUE;
                                        entrance.nextLine();
                                    }

                                    //Comprobamos el número de comensales introducidos
                                    if (numClientes == Integer.MIN_VALUE){
                                        System.out.println("ERROR, no se reconoce ese valor");
                                    }
                                    else if (numClientes<1){
                                        System.out.println("El número minimo de clientes debe de ser 1");
                                    }
                                    else if (numClientes>4){
                                        System.out.println("Lo siento, no admitimos grupos de "+numClientes+", haga grupos de 4 personas como máximo e intente de nuevo”");
                                    }
                                    else {

                                        //Buscamos si hay sitio libre y asignamos el sitio
                                        for (int i = 0; i < mesas.size(); i++) {
                                            if (mesas.get(i)+numClientes <= 4){
                                                mesas.set(i, mesas.get(i)+numClientes);
                                                compMesa= true;
                                                System.out.println("Sientense en la mesa Nº"+(i+1));
                                                break;
                                            }
                                        }

                                        //Si no hay sitio libre se introduce una nueva mesa
                                        if (!compMesa){
                                            System.out.println("No le hemos podido encontrar mesa, le pondremos una");
                                            mesas.add(numClientes);
                                        }

                                        //Mostramos las mesas
                                        System.out.print("| Num mesa     ");
                                        for (int i = 1; i <= mesas.size(); i++) {
                                            System.out.print("| "+i+" ");
                                        }
                                        System.out.print("|\n| Num clientes ");
                                        for (int i = 0; i < mesas.size(); i++) {
                                            if (i<9){
                                                System.out.print("| "+mesas.get(i)+" ");
                                            }
                                            else {
                                                System.out.print("| "+mesas.get(i)+"  ");
                                            }
                                        }
                                        System.out.println("|");
                                    }
                                }
                                else {
                                    System.out.println("No queda hueco en el restaurante, intentelo de nuevo más tarde");
                                }

                                break;

                            //Instruccion invalida
                            default:
                                System.out.println("No se reconoce esa orden");
                        }

                    }while (sKey);

                    break;
                //Ejercicio 3
                case 3:
                    controller= 0;
                    daw1.clear();
                    daw2.clear();
                    dam1.clear();
                    sKey= true;

                    System.out.println("Ejercicio 3");

                    //Inicio del programa
                    do {
                        //Se piden ordenes
                        System.out.println("Que grupo quieres hacer?\n1- Modificar 1ºDAW\n2- Modificar 2ºDAW\n3- Modificar 1ºDAM\n4- Salir");
                        try{
                            controller= Integer.parseInt(entrance.nextLine());
                        }
                        catch (RuntimeException e){
                            controller= Integer.MIN_VALUE;
                            entrance.nextLine();
                        }

                        //Se comprueba que la orden existe
                        switch (controller){

                            case 4:
                                System.out.println("Adios!");
                                sKey= false;
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
                            //Se piden nuevas ordenes
                            System.out.println("Que quieres hcaer con "+grupoEnUso+"?\n1- Dar alta a un alumno\n2- Dar baja a un alumno" +
                                    "\n3- Cambiar el nombre de un alumno\n4- Mostrar la lista de alumnos\n5- Mostrar las plazas bacantes\n6- Salir");

                            try{
                                controller= Integer.parseInt(entrance.nextLine());
                            }
                            catch (RuntimeException e){
                                controller= Integer.MIN_VALUE;
                                entrance.nextLine();
                            }

                            //Ordenar las listas usando el metodo burbuja
//                            if (daw1.size() > 1){
//                                if (daw1.size() == 2){
//                                    if (daw1.get(0).compareTo(daw1.get(1)) > 0){
//                                        auxOrden= daw1.get(0);
//                                        daw1.set(0, daw1.get(1));
//                                        daw1.set(1, auxOrden);
//                                    }
//                                }
//                                else {
//                                    for (int i = 0; i < daw1.size() - 1; i++) {
//                                        for (int j = 0; j < daw1.size() - i - 1; j++) {
//                                            if (daw1.get(j).compareTo(daw1.get(j+1)) > 0){
//                                                auxOrden= daw1.get(j);
//                                                daw1.set(j, daw1.get(j+1));
//                                                daw1.set(j+1, auxOrden);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            if (daw2.size() > 1){
//                                if (daw2.size() == 2){
//                                    if (daw2.get(0).compareTo(daw2.get(1)) > 0){
//                                        auxOrden= daw2.get(0);
//                                        daw2.set(0, daw2.get(1));
//                                        daw2.set(1, auxOrden);
//                                    }
//                                }
//                                else {
//                                    for (int i = 0; i < daw2.size() - 1; i++) {
//                                        for (int j = 0; j < daw2.size() - i - 1; j++) {
//                                            if (daw2.get(j).compareTo(daw2.get(j+1)) > 0){
//                                                auxOrden= daw2.get(j);
//                                                daw2.set(j, daw2.get(j+1));
//                                                daw2.set(j+1, auxOrden);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            if (dam1.size() > 1){
//                                if (dam1.size() == 2){
//                                    if (dam1.get(0).compareTo(dam1.get(1)) > 0){
//                                        auxOrden= dam1.get(0);
//                                        dam1.set(0, dam1.get(1));
//                                        dam1.set(1, auxOrden);
//                                    }
//                                }
//                                else {
//                                    for (int i = 0; i < dam1.size() - 1; i++) {
//                                        for (int j = 0; j < dam1.size() - i - 1; j++) {
//                                            if (dam1.get(j).compareTo(dam1.get(j+1)) > 0){
//                                                auxOrden= dam1.get(j);
//                                                dam1.set(j, dam1.get(j+1));
//                                                dam1.set(j+1, auxOrden);
//                                            }
//                                        }
//                                    }
//                                }
//                            }

                            //Ordenar las arraylist
                            Collections.sort(daw1);
                            Collections.sort(daw2);
                            Collections.sort(dam1);

                            switch (controller){
                                //Salir del grupo
                                case 6:
                                    System.out.println("Saliendo!");
                                    sKey= false;
                                    controller= Integer.MAX_VALUE;
                                    break;
                                //Dar alta alumno
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
                                //Dar baja alumno
                                case 2:
                                    posAlumno= -1;
                                    System.out.println("Introduce el nombre del alumno que quieres dar de baja:");
                                    nombreAlumno= entrance.nextLine();
                                    if (grupoEnUso.equals("1ºDAW")){
                                        if (daw1.isEmpty()){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (daw1.size() == 1){
                                            if (daw1.get(0).equals(nombreAlumno)){
                                                daw1.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
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
                                        if (daw2.isEmpty()){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (daw2.size() == 1){
                                            if (daw2.get(0).equals(nombreAlumno)){
                                                daw2.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
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
                                        if (dam1.isEmpty()){
                                            System.out.println("No puedes eliminar alumnos, porque en este curso no hay alumnos");
                                        }
                                        else if (dam1.size() == 1){
                                            if (dam1.get(0).equals(nombreAlumno)){
                                                dam1.clear();
                                                System.out.println("Alumno dado de baja, ya no hay alumnos en el curso!");
                                            }
                                            else {
                                                System.out.println("Ese alumno no existe en el curso");
                                            }
                                        }
                                        else {
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
                                //Cambiar nombre alumno
                                case 3:
                                    posAlumno= -1;
                                    System.out.println("A que alumno le quieres cambiar el nombre:");
                                    nombreAlumno= entrance.nextLine();
                                    if (grupoEnUso.equals("1ºDAW")){
                                        for (int i = 0; i < daw1.size(); i++) {
                                            if (nombreAlumno.trim().equals(daw1.get(i))){
                                                posAlumno= i;
                                            }
                                        }
                                        if (posAlumno != -1){
                                            System.out.println("A que nombre quieres cambiarlo?");
                                            nombreAlumno= entrance.nextLine();
                                            daw1.set(posAlumno, nombreAlumno.trim());
                                            System.out.println("Nombre cambiado!");
                                        }
                                        else {
                                            System.out.println("El alumno no existe dentro del programa");
                                        }
                                    }
                                    else if (grupoEnUso.equals("2ºDAW")){
                                        for (int i = 0; i < daw2.size(); i++) {
                                            if (nombreAlumno.trim().equals(daw2.get(i))){
                                                posAlumno= i;
                                            }
                                        }
                                        if (posAlumno != -1){
                                            System.out.println("A que nombre quieres cambiarlo?");
                                            nombreAlumno= entrance.nextLine();
                                            daw2.set(posAlumno, nombreAlumno.trim());
                                            System.out.println("Nombre cambiado!");
                                        }
                                        else {
                                            System.out.println("El alumno no existe dentro del programa");
                                        }
                                    }
                                    else {
                                        for (int i = 0; i < dam1.size(); i++) {
                                            if (nombreAlumno.trim().equals(dam1.get(i))){
                                                posAlumno= i;
                                            }
                                        }
                                        if (posAlumno != -1){
                                            System.out.println("A que nombre quieres cambiarlo?");
                                            nombreAlumno= entrance.nextLine();
                                            dam1.set(posAlumno, nombreAlumno.trim());
                                            System.out.println("Nombre cambiado!");
                                        }
                                        else {
                                            System.out.println("El alumno no existe dentro del programa");
                                        }
                                    }
                                    break;
                                //Mostrar lista alumnos
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
                                //Mostrar plazas bacantes curso
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
                                //Instruccion no valida
                                default:
                                    System.out.println("No se reconoce la orden");
                            }

                            //Evitar que termine el ejercicio
                            if (sKey){
                                System.out.println("-------------------------------------------");
                            }
                        }while (sKey);


                        if (controller == Integer.MAX_VALUE){
                            sKey= true;
                        }
                        System.out.println("-------------------------------------------");

                    }while (sKey);
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