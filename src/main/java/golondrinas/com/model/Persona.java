package golondrinas.com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	public String idpersona;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellido")
	private String apellido;
	
	@Column(name = "Direccion")
	private  String direccion;
	
	@Column(name = "Telefono")
	private Integer telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "DNI")
	private Integer dni;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "Genero")
	private String genero;
	
	@Column(name = "Estado")
	private String estado;

	public String getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona(String idpersona, String nombre, String apellido, String direccion, Integer telefono, String email,
			Integer dni, Integer edad, String genero, String estado) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
		this.edad = edad;
		this.genero = genero;
		this.estado = estado;
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

   
	
	
	
	
	
	
	
	
	
	
	

}