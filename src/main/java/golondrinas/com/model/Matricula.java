package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Matriculas")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMatricula;
	
	@Column(name="idAlumno")
	private Integer idAlumno;
	
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Column(name="idNivel")
	private Integer idNivel;
	
	@Column(name="idGrado")
	private Integer idGrado;
	
	@Column(name="idSeccion")
	private Integer idSeccion;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha")
	private String fecha;

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Matricula(Integer idMatricula, Integer idAlumno, Integer idUsuario, Integer idNivel, Integer idGrado,
			Integer idSeccion, String estado, String fecha) {
		super();
		this.idMatricula = idMatricula;
		this.idAlumno = idAlumno;
		this.idUsuario = idUsuario;
		this.idNivel = idNivel;
		this.idGrado = idGrado;
		this.idSeccion = idSeccion;
		this.estado = estado;
		this.fecha = fecha;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
