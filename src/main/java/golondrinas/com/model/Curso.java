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
	private String idCurso;
	
	@Column(name="idNivel")
	private String idNivel;
	
	@Column(name="idGrado")
	private String idGrado;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private String estado;

	public String getIdCurso() {
		return idCurso;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public String getIdGrado() {
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

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}

	public void setIdGrado(String idGrado) {
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

	public Curso(String idCurso, String idNivel, String idGrado, String nombre, String descripcion, String estado) {
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
