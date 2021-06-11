package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleMatricula {
	
	@Id
	@Column(name="persona")
	private String persona;
	
	@Column(name="apoderado")
	private String apoderado;
	
	@Column(name="nivel")
	private String nivel;
	
	@Column(name="grado")
	private String grado;
	
	@Column(name="seccion")
	private String seccion;

	@Column(name="usuario")
	private String usuario;

	public String getPersona() {
		return persona;
	}

	public String getApoderado() {
		return apoderado;
	}

	public String getNivel() {
		return nivel;
	}

	public String getGrado() {
		return grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	
}
