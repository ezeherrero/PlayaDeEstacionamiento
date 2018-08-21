package playafero;

import javax.swing.*;

public class ControlEstacionamiento{
    
    Estacionamiento estacionar = new Estacionamiento();

    public void estacionarAuto() 
    {
            String patente = JOptionPane.showInputDialog("Patente del auto:");

            if (estacionar.buscarAuto(patente) == null) 
            {
                String marca = JOptionPane.showInputDialog("Marca del auto:");
                String modeloCadena = JOptionPane.showInputDialog("Modelo del auto:");
                int modelo = Integer.parseInt(modeloCadena);
                Auto nuevo = new Auto(patente, marca, modelo);
                boolean pudoEstacionar = estacionar.estacionarAuto(nuevo);
                if (pudoEstacionar) 
                {
                   JOptionPane.showMessageDialog(null,"El auto fue estacionado exitosamente.");
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"No fue posible estacionar el auto. Intente más tarde");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Ya hay un auto estacionado con esa patente.");
            }
    }

    public void buscarAuto() {
        String patente = JOptionPane.showInputDialog("Patente del auto:");
        Auto auto = estacionar.buscarAuto(patente);
        if (auto == null) 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra estacionado un auto con esa patente");
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Los datos del auto son:  \n" +
                                    "Patente: "+ auto.getPatente() + "\n"+
                                    "Marca: "+ auto.getMarca());
        }
    }


    public void sacarAuto() {
        String patente = JOptionPane.showInputDialog("Patente del auto:");
        boolean pudoSacar = estacionar.sacarAuto(patente);
        if (pudoSacar) 
        {
            JOptionPane.showMessageDialog(null,"El auto se retiró del estacionamiento exitosamente");
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra estacionado un auto con esa patente");
        }
    }


    public void menu() {
        
        int opcion=-1;
        do {
            // Menú con las opciones disponibles
            String valorSeleccionado = 
            JOptionPane.showInputDialog(" ---- MENU ESTACIONAMIENTO ---  \n" +
                        "1.Estacionar un auto    \n" +
                        "2.Buscar un auto  \n" +
                        "3.Sacar un auto   \n" +
                        "0.Terminar     \n\n" +
                        "Opción seleccionada: ");
            try 
            {
                opcion = Integer.parseInt(valorSeleccionado);
                switch (opcion){
 
                    case 1: estacionarAuto();
                            break;
                    
                    // Opcion 2: Buscar un carro y mostrar sus datos 
                    case 2: buscarAuto();
                            break;
                    
                    // Opcion 3: Sacar un carro del parqueadero
                    case 3: sacarAuto();
                            break;
    
                    case 0: break;
                    
                    default: JOptionPane.showMessageDialog(null,"Opción no disponible");    
                }
            }
            catch (NumberFormatException errorIngreso)
            {
                JOptionPane.showMessageDialog(null,"Dato ingresado incorrecto. Debe ser numérico");   
            }
        }
        while (opcion != 0);
        JOptionPane.showMessageDialog(null," - Terminación exitosa -");

    }

}  