package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "apoderado")
public class Apoderado {

	@Id
	private String idapoderado;
	
	@Column(name = "idpersona")
	private String idpersona;
	
	@Column(name= "nombrecompleto")
	private String nombrecompleto;
	
	@Column(name = "estado")
	private String estado;

	public String getIdapoderado() {
		return idapoderado;
	}

	public String getIdpersona() {
		return idpersona;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdapoderado(String idapoderado) {
		this.idapoderado = idapoderado;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Apoderado(String idapoderado, String idpersona, String nombrecompleto, String estado) {
		super();
		this.idapoderado = idapoderado;
		this.idpersona = idpersona;
		this.nombrecompleto = nombrecompleto;
		this.estado = estado;
	}

	public Apoderado() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
