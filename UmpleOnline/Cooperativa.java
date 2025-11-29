/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 49 "model.ump"
// line 104 "model.ump"
public class Cooperativa
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cooperativa Attributes
  private String nombre;
  private String urlSitio;
  private String telefonoContacto;
  private boolean activa;

  //Cooperativa Associations
  private List<Turno> turnos;
  private Usuario usuario;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cooperativa(String aNombre, String aUrlSitio, String aTelefonoContacto, boolean aActiva, Usuario aUsuario)
  {
    nombre = aNombre;
    urlSitio = aUrlSitio;
    telefonoContacto = aTelefonoContacto;
    activa = aActiva;
    turnos = new ArrayList<Turno>();
    if (aUsuario == null || aUsuario.getCooperativa() != null)
    {
      throw new RuntimeException("Unable to create Cooperativa due to aUsuario. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    usuario = aUsuario;
  }

  public Cooperativa(String aNombre, String aUrlSitio, String aTelefonoContacto, boolean aActiva, String aNombresForUsuario, String aApellidosForUsuario, String aNombreUsuarioForUsuario, String aClaveForUsuario, boolean aActivoForUsuario, String aTelefonoContactoForUsuario, String aNumeroIdentificacionForUsuario)
  {
    nombre = aNombre;
    urlSitio = aUrlSitio;
    telefonoContacto = aTelefonoContacto;
    activa = aActiva;
    turnos = new ArrayList<Turno>();
    usuario = new Usuario(aNombresForUsuario, aApellidosForUsuario, aNombreUsuarioForUsuario, aClaveForUsuario, aActivoForUsuario, aTelefonoContactoForUsuario, aNumeroIdentificacionForUsuario, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setUrlSitio(String aUrlSitio)
  {
    boolean wasSet = false;
    urlSitio = aUrlSitio;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelefonoContacto(String aTelefonoContacto)
  {
    boolean wasSet = false;
    telefonoContacto = aTelefonoContacto;
    wasSet = true;
    return wasSet;
  }

  public boolean setActiva(boolean aActiva)
  {
    boolean wasSet = false;
    activa = aActiva;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getUrlSitio()
  {
    return urlSitio;
  }

  public String getTelefonoContacto()
  {
    return telefonoContacto;
  }

  public boolean getActiva()
  {
    return activa;
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
  /* Code from template association_GetOne */
  public Usuario getUsuario()
  {
    return usuario;
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
  public Turno addTurno(String aFechaSalida, String aHoraSalida, int aCuposDisponibles, Turno.EstadoTurno aEstadoTurno, Bus aBus, Ruta aRuta)
  {
    Turno aNewTurno = new Turno(aFechaSalida, aHoraSalida, aCuposDisponibles, aEstadoTurno, aBus, aRuta, this);
    return aNewTurno;
  }

  public boolean addTurno(Turno aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Cooperativa existingCooperativa = aTurno.getCooperativa();
    boolean isNewCooperativa = existingCooperativa != null && !this.equals(existingCooperativa);

    if (isNewCooperativa && existingCooperativa.numberOfTurnos() <= minimumNumberOfTurnos())
    {
      return wasAdded;
    }
    if (isNewCooperativa)
    {
      aTurno.setCooperativa(this);
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
    //Unable to remove aTurno, as it must always have a cooperativa
    if (this.equals(aTurno.getCooperativa()))
    {
      return wasRemoved;
    }

    //cooperativa already at minimum (1)
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
    Usuario existingUsuario = usuario;
    usuario = null;
    if (existingUsuario != null)
    {
      existingUsuario.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "urlSitio" + ":" + getUrlSitio()+ "," +
            "telefonoContacto" + ":" + getTelefonoContacto()+ "," +
            "activa" + ":" + getActiva()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "usuario = "+(getUsuario()!=null?Integer.toHexString(System.identityHashCode(getUsuario())):"null");
  }
}