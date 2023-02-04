import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class practica1 {
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //vector con 10 alumnos
        Alumno[] alumnos = new Alumno[10];

        int opcion = 0;

        //fecha de nacimiento
        System.out.print("Camptura el día actual\nDia: ");
        int dia = Integer.parseInt(input.readLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(input.readLine());
        System.out.print("Año: ");
        int anio = Integer.parseInt(input.readLine());
        Fecha fechaActual = new Fecha(dia, mes, anio);

        do {

            limpiarPantalla();

            System.out.print("Ingrese alguna de las siguientes opciones: " + 
                                        "\n1.- Alta de un alumno" + 
                                        "\n2.- Mostrar un alumno" +
                                        "\n3.- Alumnos de menor edad" + 
                                        "\n4.- Alumnos con promedio reprobado" + 
                                        "\n5.- Aumentar puntos" +
                                        "\n6.- Alumnos que nacieron en febrero de 2002" +
                                        "\n7.- Salir\n\n");
            opcion = Integer.parseInt(input.readLine());
            

            switch(opcion) {
                case 1: // Dar de alta alumnos
                        limpiarPantalla();
                        //nombre
                        System.out.print("Ingrese el nombre: ");
                        String nombre = input.readLine();
                        //numero de control
                        System.out.print("Ingrese el numero de control: ");
                        int numControl = Integer.parseInt(input.readLine());
                        //calificaciones
                        float califs[] = new float[3];
                        //fecha de nacimiento
                        System.out.print("Fecha de nacimiento\nDia: ");
                        dia = Integer.parseInt(input.readLine());
                        System.out.print("Mes: ");
                        mes = Integer.parseInt(input.readLine());
                        System.out.print("Año: ");
                        anio = Integer.parseInt(input.readLine());

                        for(int i=0; i<califs.length; i++) {
                            do {
                                System.out.print("Ingrese la calificacion " + (i+1) + ": ");
                                califs[i] = Float.parseFloat(input.readLine());
                                if(califs[i] > 100) System.out.println("No puede asignar una califación por encima de 100");
                            }while(califs[i] > 100);
                        }

                        //creando el objeto alumno
                        int pos;
                        do {
                            System.out.print("Ingresa la posicion en que quieres guardar el alumno: ");
                            pos = Integer.parseInt(input.readLine());
                            if(alumnos[pos] == null) {
                                alumnos[pos] = new Alumno(nombre, new Fecha(dia, mes, anio), numControl, califs);
                                break;
                            } else System.out.println("La casilla está ocupada");
                        }while(alumnos[pos] != null);

                        alumnos[pos].calcularEdad(fechaActual);
                        break;

                case 2: limpiarPantalla();
                        //Mostrar alumnos
                        for(int i=0; i<alumnos.length; i++) 
                            if(alumnos[i] != null) System.out.println(alumnos[i].toString() + "\nIndice: " + (i) + "\n" + "-".repeat(10) + "\n");
                        break;
                        
                case 3: limpiarPantalla();
                        //Nombres de alumnos con edad mayor a 18
                        for(Alumno alumno : alumnos) 
                            if(alumno.getEdad() >= 18) System.out.println(alumno.getNombre());
                        break;

                case 4: limpiarPantalla();
                        //Despliega nombre y calif de alumnos con calificación reprobatoria
                        System.out.println("Alumnos con promedio reprobado \n" + "-".repeat(10));
                        for(Alumno alumno : alumnos) {
                            if(alumno != null){
                                if(alumno.getPromedio() < 70) System.out.println("\nNombre: " + alumno.getNombre() 
                                                                            +"\nCalificaciones: " + alumno.getCalificaciones()
                                                                            +"\nPromedio: " + alumno.getPromedio()
                                                                            +"\n" + "-".repeat(10) + "\n");
                            }
                        }
                        break;

                case 5: limpiarPantalla();
                        //aumentar puntos
                        System.out.println("Nombre del alumno que busca: ");
                        String busca = input.readLine();
                        for(int i=0; i<alumnos.length; i++) {
                            if(alumnos[i].getNombre().equals(busca)){
                                aumentarPuntos(alumnos[i]);
                                System.out.println("Puntos aumentados");
                                break;
                            }
                        }

                        break;

                case 6: limpiarPantalla();
                        //Alumnos que nacieron en feb 2002
                        System.out.println("Alumnos que nacieron en febrero de 2002");
                        for(int i=0; i<alumnos.length; i++) {
                            if(alumnos[i].getFechaNac().getAnio() == 2002
                            && alumnos[i].getFechaNac().getMes() == 2) System.out.println(alumnos[i].toString());
                        }
                        break;

                case 7: limpiarPantalla();
                        //salir de la aplicación
                        break;

                default: System.out.println("Ingresa una opción valida"); break;
            } 
            System.out.println("presione enter para continuar");
            input.readLine();
        } while (opcion != 7);

        System.out.println(alumnos[0].toString());
    }
    
    //limpiar la pantalla de la consola
    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    //aumentar puntos a cada alumno
    static void aumentarPuntos(Alumno alumno) {
        float[] calif = alumno.getCalif();
        for(int i=0; i<calif.length; i++) {
            if(calif[i] <= 95) calif[i] += 5;
            else calif[i] += 100 - calif[i];
        }
    }
}
