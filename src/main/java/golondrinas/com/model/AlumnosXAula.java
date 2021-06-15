package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlumnosXAula {

	@Id
	private String idalumno;
	
	@Column(name = "nombrecompleto")
	private String nombrecompleto;
	
	@Column(name = "apoderado")
	private String apoderado;

	public String getIdalumno() {
		return idalumno;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public String getApoderado() {
		return apoderado;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	public AlumnosXAula(String idalumno, String nombrecompleto, String apoderado) {
		super();
		this.idalumno = idalumno;
		this.nombrecompleto = nombrecompleto;
		this.apoderado = apoderado;
	}

	public AlumnosXAula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
