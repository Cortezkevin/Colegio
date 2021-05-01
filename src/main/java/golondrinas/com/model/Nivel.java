package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nivel") 
public class Nivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNivel;
	
	@Column(name="nombre")
	private String nombre;

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel(Integer idNivel, String nombre) {
		super();
		this.idNivel = idNivel;
		this.nombre = nombre;
	}

	public Nivel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
