package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bimestre")
public class Bimestres {

	@Id
	private String idbimestre;
	
	@Column(name = "nombre")
	private String nombre;

	public String getIdbimestre() {
		return idbimestre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdbimestre(String idbimestre) {
		this.idbimestre = idbimestre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Bimestres(String idbimestre, String nombre) {
		super();
		this.idbimestre = idbimestre;
		this.nombre = nombre;
	}

	public Bimestres() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
