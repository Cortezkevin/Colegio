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

	public void setIdbimestre(String idbimestre) {
		this.idbimestre = idbimestre;
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

	public Bimestre(String idbimestre, String nombre) {
		super();
		this.idbimestre = idbimestre;
		this.nombre = nombre;
	}

	public Bimestre(String estado) {
		super();
		this.estado = estado;
	}

	public Bimestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
