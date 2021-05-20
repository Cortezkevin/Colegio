package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargo") 
public class Cargo {

	@Id
	private String idcargo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private String estado;

	public String getIdcargo() {
		return idcargo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cargo(String idcargo, String nombre, String estado) {
		super();
		this.idcargo = idcargo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
