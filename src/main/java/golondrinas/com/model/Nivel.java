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
	private String idNivel;
	
	@Column(name="nombre")
	private String nombre;

	@OneToMany(mappedBy = "nivel")
	private Collection<Matricula> itemsMatricula=new ArrayList<>();

	public String getIdNivel() {
		return idNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public Collection<Matricula> getItemsMatricula() {
		return itemsMatricula;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setItemsMatricula(Collection<Matricula> itemsMatricula) {
		this.itemsMatricula = itemsMatricula;
	}

	public Nivel(String idNivel, String nombre, Collection<Matricula> itemsMatricula) {
		super();
		this.idNivel = idNivel;
		this.nombre = nombre;
		this.itemsMatricula = itemsMatricula;
	}

	public Nivel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
