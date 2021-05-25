package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleMatricula {
	
	//error de id 
	/*@Id
	private String idmatricula;*/
	@Id
	@Column(name="alumno")
	private String alumno;
	
	@Column(name="nivel")
	private String nivel;
	
	@Column(name="grado")
	private String grado;
	
	@Column(name="seccion")
	private String seccion;

	public String getAlumno() {
		return alumno;
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

	public void setAlumno(String alumno) {
		this.alumno = alumno;
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

	
	
}
