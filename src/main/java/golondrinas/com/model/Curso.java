package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	private String idcurso;
	
	@Column(name="idnivel")
	private String idnivel;
	
	@Column(name="idgrado")
	private String idgrado;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private String estado;

	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public String getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Curso(String idcurso, String idnivel, String idgrado, String nombre, String descripcion, String estado) {
		super();
		this.idcurso = idcurso;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
    

}


