public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    //constructors

    public Fecha() {
        this.dia = 0;
        this.mes = 0;
        this.anio = 0;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //getters

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAnio() {
        return this.anio;
    }

    //setters

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    //to String
    @Override
    public String toString() {
        String[] meses = {"Enero",  "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        return "Fecha de nacimiento: " + dia + " de " + meses[mes-1] + " de " + anio;
    }
}
