/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

/**
 * Unable to update umple code due to error at null
 */
// line 3 "model.ump"
// line 61 "model.ump"
public class Usuario
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Usuario Attributes
  private String nombres;
  private String apellidos;
  private String nombreUsuario;
  private String clave;
  private boolean activo;
  private String telefonoContacto;
  private String numeroIdentificacion;

  //Usuario Associations
  private List<Rol> rols;
  private List<Reserva> reservas;
  private Cooperativa cooperativa;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Usuario(String aNombres, String aApellidos, String aNombreUsuario, String aClave, boolean aActivo, String aTelefonoContacto, String aNumeroIdentificacion, Cooperativa aCooperativa)
  {
    nombres = aNombres;
    apellidos = aApellidos;
    nombreUsuario = aNombreUsuario;
    clave = aClave;
    activo = aActivo;
    telefonoContacto = aTelefonoContacto;
    numeroIdentificacion = aNumeroIdentificacion;
    rols = new ArrayList<Rol>();
    reservas = new ArrayList<Reserva>();
    if (aCooperativa == null || aCooperativa.getUsuario() != null)
    {
      throw new RuntimeException("Unable to create Usuario due to aCooperativa. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cooperativa = aCooperativa;
  }

  public Usuario(String aNombres, String aApellidos, String aNombreUsuario, String aClave, boolean aActivo, String aTelefonoContacto, String aNumeroIdentificacion, String aNombreForCooperativa, String aUrlSitioForCooperativa, String aTelefonoContactoForCooperativa, boolean aActivaForCooperativa)
  {
    nombres = aNombres;
    apellidos = aApellidos;
    nombreUsuario = aNombreUsuario;
    clave = aClave;
    activo = aActivo;
    telefonoContacto = aTelefonoContacto;
    numeroIdentificacion = aNumeroIdentificacion;
    rols = new ArrayList<Rol>();
    reservas = new ArrayList<Reserva>();
    cooperativa = new Cooperativa(aNombreForCooperativa, aUrlSitioForCooperativa, aTelefonoContactoForCooperativa, aActivaForCooperativa, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombres(String aNombres)
  {
    boolean wasSet = false;
    nombres = aNombres;
    wasSet = true;
    return wasSet;
  }

  public boolean setApellidos(String aApellidos)
  {
    boolean wasSet = false;
    apellidos = aApellidos;
    wasSet = true;
    return wasSet;
  }

  public boolean setNombreUsuario(String aNombreUsuario)
  {
    boolean wasSet = false;
    nombreUsuario = aNombreUsuario;
    wasSet = true;
    return wasSet;
  }

  public boolean setClave(String aClave)
  {
    boolean wasSet = false;
    clave = aClave;
    wasSet = true;
    return wasSet;
  }

  public boolean setActivo(boolean aActivo)
  {
    boolean wasSet = false;
    activo = aActivo;
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

  public boolean setNumeroIdentificacion(String aNumeroIdentificacion)
  {
    boolean wasSet = false;
    numeroIdentificacion = aNumeroIdentificacion;
    wasSet = true;
    return wasSet;
  }

  public String getNombres()
  {
    return nombres;
  }

  public String getApellidos()
  {
    return apellidos;
  }

  public String getNombreUsuario()
  {
    return nombreUsuario;
  }

  public String getClave()
  {
    return clave;
  }

  public boolean getActivo()
  {
    return activo;
  }

  public String getTelefonoContacto()
  {
    return telefonoContacto;
  }

  public String getNumeroIdentificacion()
  {
    return numeroIdentificacion;
  }
  /* Code from template association_GetMany */
  public Rol getRol(int index)
  {
    Rol aRol = rols.get(index);
    return aRol;
  }

  public List<Rol> getRols()
  {
    List<Rol> newRols = Collections.unmodifiableList(rols);
    return newRols;
  }

  public int numberOfRols()
  {
    int number = rols.size();
    return number;
  }

  public boolean hasRols()
  {
    boolean has = rols.size() > 0;
    return has;
  }

  public int indexOfRol(Rol aRol)
  {
    int index = rols.indexOf(aRol);
    return index;
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
  public Cooperativa getCooperativa()
  {
    return cooperativa;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfRolsValid()
  {
    boolean isValid = numberOfRols() >= minimumNumberOfRols();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRols()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Rol addRol(String aNombreRol, String aDescripcion)
  {
    Rol aNewRol = new Rol(aNombreRol, aDescripcion, this);
    return aNewRol;
  }

  public boolean addRol(Rol aRol)
  {
    boolean wasAdded = false;
    if (rols.contains(aRol)) { return false; }
    Usuario existingUsuario = aRol.getUsuario();
    boolean isNewUsuario = existingUsuario != null && !this.equals(existingUsuario);

    if (isNewUsuario && existingUsuario.numberOfRols() <= minimumNumberOfRols())
    {
      return wasAdded;
    }
    if (isNewUsuario)
    {
      aRol.setUsuario(this);
    }
    else
    {
      rols.add(aRol);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRol(Rol aRol)
  {
    boolean wasRemoved = false;
    //Unable to remove aRol, as it must always have a usuario
    if (this.equals(aRol.getUsuario()))
    {
      return wasRemoved;
    }

    //usuario already at minimum (1)
    if (numberOfRols() <= minimumNumberOfRols())
    {
      return wasRemoved;
    }

    rols.remove(aRol);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRolAt(Rol aRol, int index)
  {  
    boolean wasAdded = false;
    if(addRol(aRol))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRols()) { index = numberOfRols() - 1; }
      rols.remove(aRol);
      rols.add(index, aRol);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRolAt(Rol aRol, int index)
  {
    boolean wasAdded = false;
    if(rols.contains(aRol))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRols()) { index = numberOfRols() - 1; }
      rols.remove(aRol);
      rols.add(index, aRol);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRolAt(aRol, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReservas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Reserva addReserva(String aFecha, String aHora, int aAsiento, Reserva.EstadoReserva aEstadoReserva, Turno aTurno)
  {
    return new Reserva(aFecha, aHora, aAsiento, aEstadoReserva, this, aTurno);
  }

  public boolean addReserva(Reserva aReserva)
  {
    boolean wasAdded = false;
    if (reservas.contains(aReserva)) { return false; }
    Usuario existingUsuario = aReserva.getUsuario();
    boolean isNewUsuario = existingUsuario != null && !this.equals(existingUsuario);
    if (isNewUsuario)
    {
      aReserva.setUsuario(this);
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
    //Unable to remove aReserva, as it must always have a usuario
    if (!this.equals(aReserva.getUsuario()))
    {
      reservas.remove(aReserva);
      wasRemoved = true;
    }
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

  public void delete()
  {
    for(int i=rols.size(); i > 0; i--)
    {
      Rol aRol = rols.get(i - 1);
      aRol.delete();
    }
    for(int i=reservas.size(); i > 0; i--)
    {
      Reserva aReserva = reservas.get(i - 1);
      aReserva.delete();
    }
    Cooperativa existingCooperativa = cooperativa;
    cooperativa = null;
    if (existingCooperativa != null)
    {
      existingCooperativa.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombres" + ":" + getNombres()+ "," +
            "apellidos" + ":" + getApellidos()+ "," +
            "nombreUsuario" + ":" + getNombreUsuario()+ "," +
            "clave" + ":" + getClave()+ "," +
            "activo" + ":" + getActivo()+ "," +
            "telefonoContacto" + ":" + getTelefonoContacto()+ "," +
            "numeroIdentificacion" + ":" + getNumeroIdentificacion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cooperativa = "+(getCooperativa()!=null?Integer.toHexString(System.identityHashCode(getCooperativa())):"null");
  }
}