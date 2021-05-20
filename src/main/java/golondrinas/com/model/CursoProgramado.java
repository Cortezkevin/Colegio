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
	private String idCursoProgamado;
	
	@Column(name="idCurso")
	private String idCurso;
	
	@Column(name="idSeccion")
	private String idSeccion;
	
	@Column(name="idProfesor")
	private String idProfesor;

	public String getIdCursoProgamado() {
		return idCursoProgamado;
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

	public void setIdCursoProgamado(String idCursoProgamado) {
		this.idCursoProgamado = idCursoProgamado;
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

	public CursoProgramado(String idCursoProgamado, String idCurso, String idSeccion, String idProfesor) {
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
