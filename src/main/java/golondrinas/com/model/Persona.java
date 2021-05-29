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
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "direccion")
	private  String direccion;
	
	@Column(name = "telefono")
	private Integer telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "DNI")
	private Integer dni;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "estado")
	private String estado;

	public String getIdpersona() {
		return idpersona;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public Integer getDni() {
		return dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona(String idpersona, String nombres, String apellidos, String direccion, Integer telefono, String email,
			Integer dni, Integer edad, String genero, String estado) {
		super();
		this.idpersona = idpersona;
		this.nombres = nombres;
		this.apellidos = apellidos;
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