package golondrinas.com.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	private String idusuario;
	
	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="idcargo")
	private String idcargo;

	@Column(name="idpersona")
	private String idpersona;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="foto")
    private String foto;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_role",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Cargo> roles;
	
	
	
	
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}
	public String getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	public Set<Cargo> getRoles() {
		return roles;
	}
	public void setRoles(Set<Cargo> roles) {
		this.roles = roles;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String idusuario, String nombreusuario, String contrasena, String idcargo, String idpersona,
			String estado, String foto) {
		super();
		this.idusuario = idusuario;
		this.nombreusuario = nombreusuario;
		this.contrasena = contrasena;
		this.idcargo = idcargo;
		this.idpersona = idpersona;
		this.estado = estado;
		this.foto = foto;
	}
	
	

	
}