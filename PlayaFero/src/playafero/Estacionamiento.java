package playafero;

public class Estacionamiento 
{
private final Auto[] autos = new Auto[10];

public boolean estacionarAuto(Auto auto) 
{
  for (int i = 0; i < autos.length; i++) 
  {
   if (autos[i] == null)
   {
    autos[i] = auto;
    return true;
   }
  }
  return false;
}
 
public boolean sacarAuto(String patente)
{
  for (int i = 0; i < autos.length; i++) 
  {
   if (autos[i] != null)
   {
    if (autos[i].getPatente().equals(patente))
    {
     autos[i] = null;
     return true;
    }
   }
  }
  return false;
}
public Auto buscarAuto(String patente)
 {
     for (Auto auto : autos) {
         if (auto != null) {
             if (auto.getPatente().equals(patente)) {
                 return auto;
             }
         }
     }
  return null;
 }
} 