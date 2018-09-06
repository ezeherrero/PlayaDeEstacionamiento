package playafero;

public class Auto 
{
    private final String patente;
    private final String marca;
    private final int modelo;
    
    public Auto(String patente, String marca, int modelo) 
    {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }
    
    @Override
    public String toString() {
        return "Patente=" + patente + ", Marca=" + marca + ", Año=" + modelo + '\n';
    }
}