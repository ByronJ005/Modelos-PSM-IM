/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 42 "model.ump"
// line 98 "model.ump"
public class Ruta
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ruta Attributes
  private String origen;
  private String destino;
  private double precio;
  private double duracionHoras;

  //Ruta Associations
  private List<Turno> turnos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ruta(String aOrigen, String aDestino, double aPrecio, double aDuracionHoras)
  {
    origen = aOrigen;
    destino = aDestino;
    precio = aPrecio;
    duracionHoras = aDuracionHoras;
    turnos = new ArrayList<Turno>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrigen(String aOrigen)
  {
    boolean wasSet = false;
    origen = aOrigen;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestino(String aDestino)
  {
    boolean wasSet = false;
    destino = aDestino;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrecio(double aPrecio)
  {
    boolean wasSet = false;
    precio = aPrecio;
    wasSet = true;
    return wasSet;
  }

  public boolean setDuracionHoras(double aDuracionHoras)
  {
    boolean wasSet = false;
    duracionHoras = aDuracionHoras;
    wasSet = true;
    return wasSet;
  }

  public String getOrigen()
  {
    return origen;
  }

  public String getDestino()
  {
    return destino;
  }

  public double getPrecio()
  {
    return precio;
  }

  public double getDuracionHoras()
  {
    return duracionHoras;
  }
  /* Code from template association_GetMany */
  public Turno getTurno(int index)
  {
    Turno aTurno = turnos.get(index);
    return aTurno;
  }

  public List<Turno> getTurnos()
  {
    List<Turno> newTurnos = Collections.unmodifiableList(turnos);
    return newTurnos;
  }

  public int numberOfTurnos()
  {
    int number = turnos.size();
    return number;
  }

  public boolean hasTurnos()
  {
    boolean has = turnos.size() > 0;
    return has;
  }

  public int indexOfTurno(Turno aTurno)
  {
    int index = turnos.indexOf(aTurno);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTurnosValid()
  {
    boolean isValid = numberOfTurnos() >= minimumNumberOfTurnos();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTurnos()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Turno addTurno(String aFechaSalida, String aHoraSalida, int aCuposDisponibles, Turno.EstadoTurno aEstadoTurno, Bus aBus, Cooperativa aCooperativa)
  {
    Turno aNewTurno = new Turno(aFechaSalida, aHoraSalida, aCuposDisponibles, aEstadoTurno, aBus, this, aCooperativa);
    return aNewTurno;
  }

  public boolean addTurno(Turno aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Ruta existingRuta = aTurno.getRuta();
    boolean isNewRuta = existingRuta != null && !this.equals(existingRuta);

    if (isNewRuta && existingRuta.numberOfTurnos() <= minimumNumberOfTurnos())
    {
      return wasAdded;
    }
    if (isNewRuta)
    {
      aTurno.setRuta(this);
    }
    else
    {
      turnos.add(aTurno);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTurno(Turno aTurno)
  {
    boolean wasRemoved = false;
    //Unable to remove aTurno, as it must always have a ruta
    if (this.equals(aTurno.getRuta()))
    {
      return wasRemoved;
    }

    //ruta already at minimum (1)
    if (numberOfTurnos() <= minimumNumberOfTurnos())
    {
      return wasRemoved;
    }

    turnos.remove(aTurno);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTurnoAt(Turno aTurno, int index)
  {  
    boolean wasAdded = false;
    if(addTurno(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTurnoAt(Turno aTurno, int index)
  {
    boolean wasAdded = false;
    if(turnos.contains(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTurnoAt(aTurno, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=turnos.size(); i > 0; i--)
    {
      Turno aTurno = turnos.get(i - 1);
      aTurno.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "origen" + ":" + getOrigen()+ "," +
            "destino" + ":" + getDestino()+ "," +
            "precio" + ":" + getPrecio()+ "," +
            "duracionHoras" + ":" + getDuracionHoras()+ "]";
  }
}