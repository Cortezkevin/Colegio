package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bimestre")
public class Bimestre {

	@Id
	private String idbimestre;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private String estado;

	public String getIdbimestre() {
		return idbimestre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdbimestre(String idbimestre) {
		this.idbimestre = idbimestre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Bimestre(String idbimestre, String nombre, String estado) {
		super();
		this.idbimestre = idbimestre;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Bimestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
