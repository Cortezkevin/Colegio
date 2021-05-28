package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleAlumno {

	@Id
	@Column(name="apoderado")
	private String apoderado;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@Column(name="nivel")
	private String nivel;
	
	@Column(name="grado")
	private String grado;

	public String getApoderado() {
		return apoderado;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public String getNivel() {
		return nivel;
	}

	public String getGrado() {
		return grado;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	
}
