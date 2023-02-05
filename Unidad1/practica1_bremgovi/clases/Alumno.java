package clases;

import java.util.Arrays;

public class Alumno {
    //Atributos
    private String nombre;
    private int edad;
    private int numControl;
    private float  [] calif;
    private Fecha fechaNac;


    //Métodos
    public Alumno(String nombre, Fecha fechaNac, int edad, int numControl, float[] calif) {
        this.nombre = nombre;
        this.edad = edad;
        this.numControl = numControl;
        this.calif = calif;
        this.fechaNac = fechaNac;
    }
    public Alumno(){
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Fecha getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getNumControl() {
        return numControl;
    }
    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }
    public float[] getCalif() {
        return calif;
    }
    public void setCalif(float[] calif) {
        this.calif = calif;
    }
    public float calculaPromedio(){
        float suma = 0;
        int iteraciones = 0;
        for (int i = 0; i < calif.length; i++) {
            suma += calif[i];
            iteraciones++;
        }
        return suma / iteraciones;
    }
    public String toString(){
        return "{" + "Nombre: " + nombre + ", Edad: " + edad + "\n" +
                "Fecha de nacimiento: " + fechaNac + "\n" + 
                "Numero de control: " + numControl + "\n" +
                "Calificaciones: " +  Arrays.toString(calif) + ", Promedio: " + calculaPromedio() + "}";

    }
}
