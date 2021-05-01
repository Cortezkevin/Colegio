package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	
	@Column(name="idNivel")
	private Integer idNivel;
	
	@Column(name="idGrado")
	private Integer idGrado;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private String estado;

	public Integer getIdCurso() {
		return idCurso;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Curso(Integer idCurso, Integer idNivel, Integer idGrado, String nombre, String descripcion, String estado) {
		super();
		this.idCurso = idCurso;
		this.idNivel = idNivel;
		this.idGrado = idGrado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
