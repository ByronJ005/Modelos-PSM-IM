/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 15 "model.ump"
// line 71 "model.ump"
public class Rol
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Rol Attributes
  private String nombreRol;
  private String descripcion;

  //Rol Associations
  private Usuario usuario;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Rol(String aNombreRol, String aDescripcion, Usuario aUsuario)
  {
    nombreRol = aNombreRol;
    descripcion = aDescripcion;
    boolean didAddUsuario = setUsuario(aUsuario);
    if (!didAddUsuario)
    {
      throw new RuntimeException("Unable to create rol due to usuario. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombreRol(String aNombreRol)
  {
    boolean wasSet = false;
    nombreRol = aNombreRol;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescripcion(String aDescripcion)
  {
    boolean wasSet = false;
    descripcion = aDescripcion;
    wasSet = true;
    return wasSet;
  }

  public String getNombreRol()
  {
    return nombreRol;
  }

  public String getDescripcion()
  {
    return descripcion;
  }
  /* Code from template association_GetOne */
  public Usuario getUsuario()
  {
    return usuario;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setUsuario(Usuario aUsuario)
  {
    boolean wasSet = false;
    //Must provide usuario to rol
    if (aUsuario == null)
    {
      return wasSet;
    }

    if (usuario != null && usuario.numberOfRols() <= Usuario.minimumNumberOfRols())
    {
      return wasSet;
    }

    Usuario existingUsuario = usuario;
    usuario = aUsuario;
    if (existingUsuario != null && !existingUsuario.equals(aUsuario))
    {
      boolean didRemove = existingUsuario.removeRol(this);
      if (!didRemove)
      {
        usuario = existingUsuario;
        return wasSet;
      }
    }
    usuario.addRol(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Usuario placeholderUsuario = usuario;
    this.usuario = null;
    if(placeholderUsuario != null)
    {
      placeholderUsuario.removeRol(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombreRol" + ":" + getNombreRol()+ "," +
            "descripcion" + ":" + getDescripcion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "usuario = "+(getUsuario()!=null?Integer.toHexString(System.identityHashCode(getUsuario())):"null");
  }
}