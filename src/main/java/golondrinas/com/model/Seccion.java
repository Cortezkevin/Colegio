package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seccion")
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSeccion;
	
	@Column(name="nombre")
	private String nombre;

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Seccion(Integer idSeccion, String nombre) {
		super();
		this.idSeccion = idSeccion;
		this.nombre = nombre;
	}

	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
