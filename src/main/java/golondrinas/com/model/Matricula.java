package golondrinas.com.model;

import javax.persistence.ForeignKey;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="matricula")
public class Matricula{

	@Id
	private String idMatricula;
	
	@Column(name="idAlumno")
	private String idAlumno;
	
	@Column(name="idUsuario")
	private String idUsuario;
	
	@ManyToOne
	@JoinColumn(name="id_nivel", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_nivel) references nivel(id_nivel)"))
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name="id_grado", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_grado) references grado(id_grado)"))
	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name="id_seccion", nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_seccion) references seccion(id_seccion)"))
	private Seccion seccion;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha")
	private String fecha;

	public String getIdMatricula() {
		return idMatricula;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public Grado getGrado() {
		return grado;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public String getEstado() {
		return estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setIdMatricula(String idMatricula) {
		this.idMatricula = idMatricula;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Matricula(String idMatricula, String idAlumno, String idUsuario, Nivel nivel, Grado grado, Seccion seccion,
			String estado, String fecha) {
		super();
		this.idMatricula = idMatricula;
		this.idAlumno = idAlumno;
		this.idUsuario = idUsuario;
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
		this.estado = estado;
		this.fecha = fecha;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
