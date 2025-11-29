/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 34 "model.ump"
// line 92 "model.ump"
public class Bus
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum EstadoBus { DISPONIBLE, ENMANTENIMIENTO, FUERADESERVICIO }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bus Attributes
  private String placa;
  private String modelo;
  private int capacidad;
  private EstadoBus estadoBus;

  //Bus Associations
  private List<Turno> turnos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bus(String aPlaca, String aModelo, int aCapacidad, EstadoBus aEstadoBus)
  {
    placa = aPlaca;
    modelo = aModelo;
    capacidad = aCapacidad;
    estadoBus = aEstadoBus;
    turnos = new ArrayList<Turno>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlaca(String aPlaca)
  {
    boolean wasSet = false;
    placa = aPlaca;
    wasSet = true;
    return wasSet;
  }

  public boolean setModelo(String aModelo)
  {
    boolean wasSet = false;
    modelo = aModelo;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacidad(int aCapacidad)
  {
    boolean wasSet = false;
    capacidad = aCapacidad;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstadoBus(EstadoBus aEstadoBus)
  {
    boolean wasSet = false;
    estadoBus = aEstadoBus;
    wasSet = true;
    return wasSet;
  }

  public String getPlaca()
  {
    return placa;
  }

  public String getModelo()
  {
    return modelo;
  }

  public int getCapacidad()
  {
    return capacidad;
  }

  public EstadoBus getEstadoBus()
  {
    return estadoBus;
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
  public Turno addTurno(String aFechaSalida, String aHoraSalida, int aCuposDisponibles, Turno.EstadoTurno aEstadoTurno, Ruta aRuta, Cooperativa aCooperativa)
  {
    Turno aNewTurno = new Turno(aFechaSalida, aHoraSalida, aCuposDisponibles, aEstadoTurno, this, aRuta, aCooperativa);
    return aNewTurno;
  }

  public boolean addTurno(Turno aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Bus existingBus = aTurno.getBus();
    boolean isNewBus = existingBus != null && !this.equals(existingBus);

    if (isNewBus && existingBus.numberOfTurnos() <= minimumNumberOfTurnos())
    {
      return wasAdded;
    }
    if (isNewBus)
    {
      aTurno.setBus(this);
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
    //Unable to remove aTurno, as it must always have a bus
    if (this.equals(aTurno.getBus()))
    {
      return wasRemoved;
    }

    //bus already at minimum (1)
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
            "placa" + ":" + getPlaca()+ "," +
            "modelo" + ":" + getModelo()+ "," +
            "capacidad" + ":" + getCapacidad()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "estadoBus" + "=" + (getEstadoBus() != null ? !getEstadoBus().equals(this)  ? getEstadoBus().toString().replaceAll("  ","    ") : "this" : "null");
  }
}