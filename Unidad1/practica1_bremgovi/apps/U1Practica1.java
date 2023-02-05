package apps;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Calendar;
import java.text.Normalizer;

//Nota: Las clases Alumno y Fecha estan dentro de un paquete llamado "clases".
import clases.*;

public class U1Practica1 {
    public static void main(String[] args){
        String[] menu = { "1. Alta de un alumno", "2. Mostrar alumnos", "3. Alumnos menores de edad",
                "4. Alumnos con promedio reprobado", "5. Aumentar puntos", "6. Alumnos que nacieron en FEB/2002",
                "7. Salir" };
        Alumno[] alumnos = new Alumno[10];
        String opcion;
        do {
            opcion = (String) JOptionPane.showInputDialog(null, "Elige una opción", "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null, menu, menu[0]);
            if (opcion == null) {
                break;
            }
            switch (opcion) {
                case "1. Alta de un alumno":
                    int dia = 0, mes = 0, anio = 0;
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición del alumno"));
                    if (pos < 0 || pos >= alumnos.length) {
                        JOptionPane.showMessageDialog(null, "La posición esta fuera del vector", "Aviso",
                        JOptionPane.ERROR_MESSAGE);
                    } else if (alumnos[pos] == null) {
                        // Nombre
                        String nombre = JOptionPane.showInputDialog("Ingresa nombre");
                        nombre = Normalizer.normalize(nombre, Normalizer.Form.NFD);
                        nombre = nombre.replaceAll("\\p{M}", "");
                        // Fecha
                        JTextField diaCampo = new JTextField();
                        JTextField mesCampo = new JTextField();
                        JTextField anioCampo = new JTextField();
                        Object[] mensaje = {
                                "dia:", diaCampo,
                                "mes:", mesCampo,
                                "año:", anioCampo
                        };
                        int resultado = JOptionPane.showConfirmDialog(null, mensaje, "Fecha de nacimiento",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (resultado == JOptionPane.OK_OPTION) {
                            dia = Integer.parseInt(diaCampo.getText());
                            mes = Integer.parseInt(mesCampo.getText());
                            anio = Integer.parseInt(anioCampo.getText());
                        }
                        if(mes > 12){
                            JOptionPane.showMessageDialog(null, "El mes no es valido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        Fecha fechaNac = new Fecha(dia, mes, anio);
                        // Edad
                        Calendar cal = Calendar.getInstance();
                        int anioActual = cal.get(Calendar.YEAR);
                        int mesActual = cal.get(Calendar.MONTH);
                        int diaActual = cal.get(Calendar.DAY_OF_MONTH);
                        int edad;
                        if (mes > mesActual) {
                            edad = anioActual - anio - 1;
                        } else if (mes == mesActual && dia < diaActual) {
                            edad = anioActual - anio;
                        } else {
                            edad = anioActual - anio;
                        }
                        // Num de control
                        int numControl = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de control"));
                        // Calificaciones
                        float[] calificaciones = new float[3];
                        for (int i = 0; i < calificaciones.length; i++) {
                            calificaciones[i] = Float
                                    .parseFloat(JOptionPane.showInputDialog("Ingrese una calificación"));
                        }
                        alumnos[pos] = new Alumno(nombre, fechaNac, edad, numControl, calificaciones);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta posición ya esta ocupada", "Aviso",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "2. Mostrar alumnos":
                    int indice = 0;
                    String lista = "";
                    for (Alumno alumno : alumnos) {
                        if (alumno != null) {
                            lista = lista + alumno.toString() + "\nPosición: " + indice + "\n" + "\n";
                        }
                        indice++;
                    }
                    if(lista.equals("")){
                        JOptionPane.showMessageDialog(null, "Aún no se han añadido alumnos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    JOptionPane.showMessageDialog(null, lista, "Lista de alumnos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3. Alumnos menores de edad":
                    lista = "";
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.getEdad() < 18) {
                            lista = lista + alumno.getNombre() + "\n" + "\n";
                        }
                    }
                    if(lista.equals("")){
                        JOptionPane.showMessageDialog(null, "No hay alumnos menores de edad", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    JOptionPane.showMessageDialog(null, lista, "Alumnos menores de edad",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4. Alumnos con promedio reprobado":
                    lista = "";
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.calculaPromedio() < 70) {
                            lista = lista + alumno.getNombre() + "\n" + Arrays.toString(alumno.getCalif()) + "\n"
                                    + "\n";
                        }
                    }
                    if(lista.equals("")){
                        JOptionPane.showMessageDialog(null, "No hay alumnos reprobados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    JOptionPane.showMessageDialog(null, lista, "Alumnos reprobados", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5. Aumentar puntos":
                    String busqueda = JOptionPane.showInputDialog("Ingresa el nombre del alumno a buscar: ");
                    busqueda = Normalizer.normalize(busqueda, Normalizer.Form.NFD);
                    busqueda = busqueda.replaceAll("\\p{M}", "").toLowerCase();

                    float[] calificaciones;
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && busqueda.equals(alumno.getNombre().toLowerCase())) {
                            calificaciones = alumno.getCalif();
                            for (int i = 0; i < calificaciones.length; i++) {
                                calificaciones[i] += 5;
                            }
                            JOptionPane.showMessageDialog(null, "Las calificaciones han sido actualizadas", "Aviso",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "El alumno no fue encontrado", "Aviso",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    break;
                case "6. Alumnos que nacieron en FEB/2002":
                    lista = "";
                    for (Alumno alumno : alumnos) {
                        if ((alumno != null) && (alumno.getFechaNac().getMes() == 2)
                                && (alumno.getFechaNac().getAnio() == 2002)) {
                            lista = lista + alumno.getNombre() + "\n" + "\n";
                        }
                    }
                    if(lista.equals("")){
                        JOptionPane.showMessageDialog(null, "No hay alumnos nacidos en FEB/2022", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    JOptionPane.showMessageDialog(null, lista, "Nacidos FEB/2002", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (opcion != "7. Salir");
    }
}
