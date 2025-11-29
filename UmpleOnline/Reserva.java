/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 19 "model.ump"
// line 81 "model.ump"
public class Reserva
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum EstadoReserva { PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Reserva Attributes
  private String fecha;
  private String hora;
  private int asiento;
  private EstadoReserva estadoReserva;

  //Reserva Associations
  private Usuario usuario;
  private Turno turno;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Reserva(String aFecha, String aHora, int aAsiento, EstadoReserva aEstadoReserva, Usuario aUsuario, Turno aTurno)
  {
    fecha = aFecha;
    hora = aHora;
    asiento = aAsiento;
    estadoReserva = aEstadoReserva;
    boolean didAddUsuario = setUsuario(aUsuario);
    if (!didAddUsuario)
    {
      throw new RuntimeException("Unable to create reserva due to usuario. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTurno = setTurno(aTurno);
    if (!didAddTurno)
    {
      throw new RuntimeException("Unable to create reserva due to turno. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFecha(String aFecha)
  {
    boolean wasSet = false;
    fecha = aFecha;
    wasSet = true;
    return wasSet;
  }

  public boolean setHora(String aHora)
  {
    boolean wasSet = false;
    hora = aHora;
    wasSet = true;
    return wasSet;
  }

  public boolean setAsiento(int aAsiento)
  {
    boolean wasSet = false;
    asiento = aAsiento;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstadoReserva(EstadoReserva aEstadoReserva)
  {
    boolean wasSet = false;
    estadoReserva = aEstadoReserva;
    wasSet = true;
    return wasSet;
  }

  public String getFecha()
  {
    return fecha;
  }

  public String getHora()
  {
    return hora;
  }

  public int getAsiento()
  {
    return asiento;
  }

  public EstadoReserva getEstadoReserva()
  {
    return estadoReserva;
  }
  /* Code from template association_GetOne */
  public Usuario getUsuario()
  {
    return usuario;
  }
  /* Code from template association_GetOne */
  public Turno getTurno()
  {
    return turno;
  }
  /* Code from template association_SetOneToMany */
  public boolean setUsuario(Usuario aUsuario)
  {
    boolean wasSet = false;
    if (aUsuario == null)
    {
      return wasSet;
    }

    Usuario existingUsuario = usuario;
    usuario = aUsuario;
    if (existingUsuario != null && !existingUsuario.equals(aUsuario))
    {
      existingUsuario.removeReserva(this);
    }
    usuario.addReserva(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setTurno(Turno aTurno)
  {
    boolean wasSet = false;
    //Must provide turno to reserva
    if (aTurno == null)
    {
      return wasSet;
    }

    if (turno != null && turno.numberOfReservas() <= Turno.minimumNumberOfReservas())
    {
      return wasSet;
    }

    Turno existingTurno = turno;
    turno = aTurno;
    if (existingTurno != null && !existingTurno.equals(aTurno))
    {
      boolean didRemove = existingTurno.removeReserva(this);
      if (!didRemove)
      {
        turno = existingTurno;
        return wasSet;
      }
    }
    turno.addReserva(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Usuario placeholderUsuario = usuario;
    this.usuario = null;
    if(placeholderUsuario != null)
    {
      placeholderUsuario.removeReserva(this);
    }
    Turno placeholderTurno = turno;
    this.turno = null;
    if(placeholderTurno != null)
    {
      placeholderTurno.removeReserva(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "fecha" + ":" + getFecha()+ "," +
            "hora" + ":" + getHora()+ "," +
            "asiento" + ":" + getAsiento()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "estadoReserva" + "=" + (getEstadoReserva() != null ? !getEstadoReserva().equals(this)  ? getEstadoReserva().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "usuario = "+(getUsuario()!=null?Integer.toHexString(System.identityHashCode(getUsuario())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "turno = "+(getTurno()!=null?Integer.toHexString(System.identityHashCode(getTurno())):"null");
  }
}