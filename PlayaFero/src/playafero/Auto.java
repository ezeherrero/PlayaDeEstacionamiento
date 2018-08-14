package playafero;

public class Auto 
{
    private String patente;
    private String marca;
    private int modelo;
    

    public Auto(String patente, String marca, int modelo) 
    {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }
    

    public String getPatente() 
    {
        return patente;
    }

    public String getMarca() 
    {
        return marca;
    }


    public int getModelo() 
    {
        return modelo;
    }   

}  