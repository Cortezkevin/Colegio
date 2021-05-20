package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notas")
public class Notas {

	@Id
	private String idNota; 
	
	@Column(name="idAlumno")
	private String idAlumno;
	
	@Column(name="idCurso")
	private String idCurso; 
	
	@Column(name="idSeccion")
	private String idSeccion; 
	
	@Column(name="idProfesor")
	private String idProfesor; 
	
	@Column(name="examen1")
	private String examen1;
	
	@Column(name="examen2")
	private String examen2;
	
	@Column(name="examen3")
	private String examen3;

	public String getIdNota() {
		return idNota;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public String getIdSeccion() {
		return idSeccion;
	}

	public String getIdProfesor() {
		return idProfesor;
	}

	public String getExamen1() {
		return examen1;
	}

	public String getExamen2() {
		return examen2;
	}

	public String getExamen3() {
		return examen3;
	}

	public void setIdNota(String idNota) {
		this.idNota = idNota;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public void setIdSeccion(String idSeccion) {
		this.idSeccion = idSeccion;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public void setExamen1(String examen1) {
		this.examen1 = examen1;
	}

	public void setExamen2(String examen2) {
		this.examen2 = examen2;
	}

	public void setExamen3(String examen3) {
		this.examen3 = examen3;
	}

	public Notas(String idNota, String idAlumno, String idCurso, String idSeccion, String idProfesor, String examen1,
			String examen2, String examen3) {
		super();
		this.idNota = idNota;
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
		this.idSeccion = idSeccion;
		this.idProfesor = idProfesor;
		this.examen1 = examen1;
		this.examen2 = examen2;
		this.examen3 = examen3;
	}

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
