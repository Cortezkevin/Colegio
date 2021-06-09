package golondrinas.com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="matricula")
public class Matricula{

	@Id
	private String idmatricula;
	
	@Column(name="idpersona")
	private String idpersona;

	@Column(name="idapoderado")
	private String idapoderado;
	
	@Column(name="idnivel")
	private String idnivel;
	
	@Column(name="idgrado")
	private String idgrado;
	
	@Column(name="idseccion")
	private String idseccion;

	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name="fecha")
	private Date fecha;

	@Column(name="estado")
	private String estado;
	
	public String getIdmatricula() {
		return idmatricula;
	}

	public String getIdpersona() {
		return idpersona;
	}

	public String getIdapoderado() {
		return idapoderado;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public String getIdgrado() {
		return idgrado;
	}

	public String getIdseccion() {
		return idseccion;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public Double getMonto() {
		return monto;
	}

	public String getEstado() {
		return estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setIdmatricula(String idmatricula) {
		this.idmatricula = idmatricula;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public void setIdapoderado(String idpoderado) {
		this.idapoderado = idpoderado;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public void setIdseccion(String idseccion) {
		this.idseccion = idseccion;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Matricula(String idmatricula, String idpersona, String idapoderado, String idnivel, String idgrado,
			String idseccion, String nombreusuario, String contrasena, Double monto, String estado, Date fecha) {
		super();
		this.idmatricula = idmatricula;
		this.idpersona = idpersona;
		this.idapoderado = idapoderado;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.idseccion = idseccion;
		this.nombreusuario = nombreusuario;
		this.contrasena = contrasena;
		this.monto = monto;
		this.estado = estado;
		this.fecha = fecha;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
}
