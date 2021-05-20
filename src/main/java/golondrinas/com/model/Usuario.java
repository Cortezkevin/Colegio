package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	private String idusuario;
	
	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@Column(name="contraseña")
	private String password;
	
	@Column(name="idcargo")	
	private String idcargo;

	@Column(name="idpersona")
	private String idpersona;
	
	@Column(name="estado")
	private String estado;

	public String getIdusuario() {
		return idusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public String getPassword() {
		return password;
	}

	public String getIdcargo() {
		return idcargo;
	}

	public String getIdpersona() {
		return idpersona;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}