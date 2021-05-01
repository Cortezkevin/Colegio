package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cursoProgramado")
public class CursoProgramado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCursoProgamado;
	
	@Column(name="idCurso")
	private Integer idCurso;
	
	@Column(name="idSeccion")
	private Integer idSeccion;
	
	@Column(name="idProfesor")
	private Integer idProfesor;

	public Integer getIdCursoProgamado() {
		return idCursoProgamado;
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

	public void setIdCursoProgamado(Integer idCursoProgamado) {
		this.idCursoProgamado = idCursoProgamado;
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

	public CursoProgramado(Integer idCursoProgamado, Integer idCurso, Integer idSeccion, Integer idProfesor) {
		super();
		this.idCursoProgamado = idCursoProgamado;
		this.idCurso = idCurso;
		this.idSeccion = idSeccion;
		this.idProfesor = idProfesor;
	}

	public CursoProgramado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
