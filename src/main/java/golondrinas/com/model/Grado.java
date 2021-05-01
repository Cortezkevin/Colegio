package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grado")
public class Grado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGrado;
	
	@Column(name="nombre")
	private String nombre;

	public Integer getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grado(Integer idGrado, String nombre) {
		super();
		this.idGrado = idGrado;
		this.nombre = nombre;
	}

	public Grado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
