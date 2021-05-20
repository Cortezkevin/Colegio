package golondrinas.com.model;



import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "grado")
public class Grado {

	@Id
	private String idgrado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "estado")
	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Grado(String idgrado, String nombre, String estado) {
		super();
		this.idgrado = idgrado;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Grado() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
