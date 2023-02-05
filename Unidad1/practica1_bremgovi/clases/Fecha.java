package clases;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    String [] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
   
    public Fecha(){

    }
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String toString(){
        if(anio >= 2000){
            return dia + " de " + meses[mes-1] + " del " + anio;
        }else{
            return dia + " de " + meses[mes-1] + " de " + anio;
        }
        
    }

    
}
