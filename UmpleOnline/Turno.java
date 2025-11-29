/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 26 "model.ump"
// line 86 "model.ump"
public class Turno
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum EstadoTurno { PROGRAMADO, ENCURSO, FINALIZADO, CANCELADO }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Turno Attributes
  private String fechaSalida;
  private String horaSalida;
  private int cuposDisponibles;
  private EstadoTurno estadoTurno;

  //Turno Associations
  private List<Reserva> reservas;
  private Bus bus;
  private Ruta ruta;
  private Cooperativa cooperativa;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Turno(String aFechaSalida, String aHoraSalida, int aCuposDisponibles, EstadoTurno aEstadoTurno, Bus aBus, Ruta aRuta, Cooperativa aCooperativa)
  {
    fechaSalida = aFechaSalida;
    horaSalida = aHoraSalida;
    cuposDisponibles = aCuposDisponibles;
    estadoTurno = aEstadoTurno;
    reservas = new ArrayList<Reserva>();
    boolean didAddBus = setBus(aBus);
    if (!didAddBus)
    {
      throw new RuntimeException("Unable to create turno due to bus. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddRuta = setRuta(aRuta);
    if (!didAddRuta)
    {
      throw new RuntimeException("Unable to create turno due to ruta. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCooperativa = setCooperativa(aCooperativa);
    if (!didAddCooperativa)
    {
      throw new RuntimeException("Unable to create turno due to cooperativa. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFechaSalida(String aFechaSalida)
  {
    boolean wasSet = false;
    fechaSalida = aFechaSalida;
    wasSet = true;
    return wasSet;
  }

  public boolean setHoraSalida(String aHoraSalida)
  {
    boolean wasSet = false;
    horaSalida = aHoraSalida;
    wasSet = true;
    return wasSet;
  }

  public boolean setCuposDisponibles(int aCuposDisponibles)
  {
    boolean wasSet = false;
    cuposDisponibles = aCuposDisponibles;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstadoTurno(EstadoTurno aEstadoTurno)
  {
    boolean wasSet = false;
    estadoTurno = aEstadoTurno;
    wasSet = true;
    return wasSet;
  }

  public String getFechaSalida()
  {
    return fechaSalida;
  }

  public String getHoraSalida()
  {
    return horaSalida;
  }

  public int getCuposDisponibles()
  {
    return cuposDisponibles;
  }

  public EstadoTurno getEstadoTurno()
  {
    return estadoTurno;
  }
  /* Code from template association_GetMany */
  public Reserva getReserva(int index)
  {
    Reserva aReserva = reservas.get(index);
    return aReserva;
  }

  public List<Reserva> getReservas()
  {
    List<Reserva> newReservas = Collections.unmodifiableList(reservas);
    return newReservas;
  }

  public int numberOfReservas()
  {
    int number = reservas.size();
    return number;
  }

  public boolean hasReservas()
  {
    boolean has = reservas.size() > 0;
    return has;
  }

  public int indexOfReserva(Reserva aReserva)
  {
    int index = reservas.indexOf(aReserva);
    return index;
  }
  /* Code from template association_GetOne */
  public Bus getBus()
  {
    return bus;
  }
  /* Code from template association_GetOne */
  public Ruta getRuta()
  {
    return ruta;
  }
  /* Code from template association_GetOne */
  public Cooperativa getCooperativa()
  {
    return cooperativa;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfReservasValid()
  {
    boolean isValid = numberOfReservas() >= minimumNumberOfReservas();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReservas()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Reserva addReserva(String aFecha, String aHora, int aAsiento, Reserva.EstadoReserva aEstadoReserva, Usuario aUsuario)
  {
    Reserva aNewReserva = new Reserva(aFecha, aHora, aAsiento, aEstadoReserva, aUsuario, this);
    return aNewReserva;
  }

  public boolean addReserva(Reserva aReserva)
  {
    boolean wasAdded = false;
    if (reservas.contains(aReserva)) { return false; }
    Turno existingTurno = aReserva.getTurno();
    boolean isNewTurno = existingTurno != null && !this.equals(existingTurno);

    if (isNewTurno && existingTurno.numberOfReservas() <= minimumNumberOfReservas())
    {
      return wasAdded;
    }
    if (isNewTurno)
    {
      aReserva.setTurno(this);
    }
    else
    {
      reservas.add(aReserva);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReserva(Reserva aReserva)
  {
    boolean wasRemoved = false;
    //Unable to remove aReserva, as it must always have a turno
    if (this.equals(aReserva.getTurno()))
    {
      return wasRemoved;
    }

    //turno already at minimum (1)
    if (numberOfReservas() <= minimumNumberOfReservas())
    {
      return wasRemoved;
    }

    reservas.remove(aReserva);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReservaAt(Reserva aReserva, int index)
  {  
    boolean wasAdded = false;
    if(addReserva(aReserva))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReservas()) { index = numberOfReservas() - 1; }
      reservas.remove(aReserva);
      reservas.add(index, aReserva);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReservaAt(Reserva aReserva, int index)
  {
    boolean wasAdded = false;
    if(reservas.contains(aReserva))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReservas()) { index = numberOfReservas() - 1; }
      reservas.remove(aReserva);
      reservas.add(index, aReserva);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReservaAt(aReserva, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setBus(Bus aBus)
  {
    boolean wasSet = false;
    //Must provide bus to turno
    if (aBus == null)
    {
      return wasSet;
    }

    if (bus != null && bus.numberOfTurnos() <= Bus.minimumNumberOfTurnos())
    {
      return wasSet;
    }

    Bus existingBus = bus;
    bus = aBus;
    if (existingBus != null && !existingBus.equals(aBus))
    {
      boolean didRemove = existingBus.removeTurno(this);
      if (!didRemove)
      {
        bus = existingBus;
        return wasSet;
      }
    }
    bus.addTurno(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setRuta(Ruta aRuta)
  {
    boolean wasSet = false;
    //Must provide ruta to turno
    if (aRuta == null)
    {
      return wasSet;
    }

    if (ruta != null && ruta.numberOfTurnos() <= Ruta.minimumNumberOfTurnos())
    {
      return wasSet;
    }

    Ruta existingRuta = ruta;
    ruta = aRuta;
    if (existingRuta != null && !existingRuta.equals(aRuta))
    {
      boolean didRemove = existingRuta.removeTurno(this);
      if (!didRemove)
      {
        ruta = existingRuta;
        return wasSet;
      }
    }
    ruta.addTurno(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setCooperativa(Cooperativa aCooperativa)
  {
    boolean wasSet = false;
    //Must provide cooperativa to turno
    if (aCooperativa == null)
    {
      return wasSet;
    }

    if (cooperativa != null && cooperativa.numberOfTurnos() <= Cooperativa.minimumNumberOfTurnos())
    {
      return wasSet;
    }

    Cooperativa existingCooperativa = cooperativa;
    cooperativa = aCooperativa;
    if (existingCooperativa != null && !existingCooperativa.equals(aCooperativa))
    {
      boolean didRemove = existingCooperativa.removeTurno(this);
      if (!didRemove)
      {
        cooperativa = existingCooperativa;
        return wasSet;
      }
    }
    cooperativa.addTurno(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=reservas.size(); i > 0; i--)
    {
      Reserva aReserva = reservas.get(i - 1);
      aReserva.delete();
    }
    Bus placeholderBus = bus;
    this.bus = null;
    if(placeholderBus != null)
    {
      placeholderBus.removeTurno(this);
    }
    Ruta placeholderRuta = ruta;
    this.ruta = null;
    if(placeholderRuta != null)
    {
      placeholderRuta.removeTurno(this);
    }
    Cooperativa placeholderCooperativa = cooperativa;
    this.cooperativa = null;
    if(placeholderCooperativa != null)
    {
      placeholderCooperativa.removeTurno(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "fechaSalida" + ":" + getFechaSalida()+ "," +
            "horaSalida" + ":" + getHoraSalida()+ "," +
            "cuposDisponibles" + ":" + getCuposDisponibles()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "estadoTurno" + "=" + (getEstadoTurno() != null ? !getEstadoTurno().equals(this)  ? getEstadoTurno().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bus = "+(getBus()!=null?Integer.toHexString(System.identityHashCode(getBus())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ruta = "+(getRuta()!=null?Integer.toHexString(System.identityHashCode(getRuta())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cooperativa = "+(getCooperativa()!=null?Integer.toHexString(System.identityHashCode(getCooperativa())):"null");
  }
}