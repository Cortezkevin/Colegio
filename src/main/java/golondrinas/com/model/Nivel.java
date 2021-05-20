package golondrinas.com.model;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="nivel") 
public class Nivel{

	@Id
	private String idnivel;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private String estado;
/*
	@OneToMany(mappedBy = "nivel")
	private Collection<Matricula> itemsMatricula=new ArrayList<>();
*/

	public String getIdnivel() {
		return idnivel;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Nivel(String idnivel, String nombre, String estado) {
		super();
		this.idnivel = idnivel;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Nivel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
