package golondrinas.com.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seccion")
public class Seccion {

	@Id
	private String idseccion;

	@Column(name = "nombre")
	private String nombre;
/*
	@OneToMany(mappedBy = "seccion")
	private Collection<Matricula> itemsMatricula = new ArrayList<>();
*/
	@Column(name="estado")
	private String estado;
	public String getIdseccion() {
		return idseccion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setIdseccion(String idseccion) {
		this.idseccion = idseccion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Seccion(String idseccion, String nombre, String estado) {
		super();
		this.idseccion = idseccion;
		this.nombre = nombre;
		this.estado = estado;
	}
	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
