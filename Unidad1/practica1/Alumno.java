public class Alumno {
    private String nombre;
    private Fecha fechaNac;
    private int edad;
    private int numControl;
    private float[] calif;

    public Alumno() {
        this.nombre = "";
        this.edad = 0;
        this.numControl = 0;
        this.calif = null;
    }

    public Alumno(String nombre, Fecha fechaNac, int numControl, float[] calif) {
        this.nombre = nombre;
        this.numControl = numControl;
        this.calif = calif;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Fecha getFechaNac() {
        return fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumControl() {
        return numControl;
    }

    public float[] getCalif() {
        return calif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public void setCalif(float[] calif) {
        this.calif = calif;
    }

    //promedio
    public float getPromedio() {
        int sum = 0;
        for(float cali : calif) sum += cali;
        return sum / calif.length;
    }

    //regresa las calificaciones como un string 
    public String getCalificaciones() {
        String calificaciones = "";
        for(int i=0; i<calif.length; i++) {
            if(i<calif.length-1) calificaciones += calif[i] + ", ";
            else calificaciones += calif[i];
        }

        return calificaciones;
    }

    //calcular edad
    public void calcularEdad(Fecha fechaActual) {
        if(fechaNac.getMes() < fechaActual.getMes()) this.edad = fechaActual.getAnio() - fechaNac.getAnio();
        else if (fechaNac.getMes() == fechaActual.getMes() && fechaNac.getDia() < fechaActual.getDia()) this.edad = fechaActual.getAnio() - fechaNac.getAnio();
        else this.edad = fechaActual.getAnio() - fechaNac.getAnio() - 1;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad + 
                "\nNumero Control: " + numControl + 
                "\nCalificaciones: " + this.getCalificaciones() + 
                "\nPromedio: " + this.getPromedio() +
                "\n" + fechaNac.toString();
    }
}
