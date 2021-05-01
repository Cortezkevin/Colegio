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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNota; 
	
	@Column(name="idAlumno")
	private Integer idAlumno;
	
	@Column(name="idCurso")
	private Integer idCurso; 
	
	@Column(name="idSeccion")
	private Integer idSeccion; 
	
	@Column(name="idProfesor")
	private Integer idProfesor; 
	
	@Column(name="examen1")
	private String examen1;
	
	@Column(name="examen2")
	private String examen2;
	
	@Column(name="examen3")
	private String examen3;

	public Integer getIdNota() {
		return idNota;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public Integer getIdProfesor() {
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

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public void setIdProfesor(Integer idProfesor) {
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

	public Notas(Integer idNota, Integer idAlumno, Integer idCurso, Integer idSeccion, Integer idProfesor,
			String examen1, String examen2, String examen3) {
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
