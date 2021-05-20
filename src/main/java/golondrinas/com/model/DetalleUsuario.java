package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleUsuario {

	@Id
	private String idusuario;
	
	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@Column(name="contraseña")
	private String password;
	
	@Column(name="cargo")
	private String cargo;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;

	public String getIdusuario() {
		return idusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public String getPassword() {
		return password;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


}
