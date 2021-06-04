package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profesores")
public class Profesor{

	@Id
	private String idprofesor;
	
	@Column(name="idpersona")
	private String idpersona;
	
	@Column(name="idusuario")
	private String idusuario;
	
	@Column(name="nombrecompleto")
	private String nombreusario;
	
	public String getNombreusario() {
		return nombreusario;
	}

	public void setNombreusario(String nombreusario) {
		this.nombreusario = nombreusario;
	}

	@Column(name="estado")
	private String estado;

	public String getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(String idprofesor) {
		this.idprofesor = idprofesor;
	}

	public String getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	public Profesor(String idprofesor, String idpersona, String idusuario, String nombrecompleto, String estado) {
		super();
		this.idprofesor = idprofesor;
		this.idpersona = idpersona;
		this.idusuario = idusuario;
		this.nombreusario = nombrecompleto;
		this.estado = estado;
	}

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
