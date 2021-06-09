package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	private String idalumno;

	@Column(name = "idpersona")
	private String idpersona;
	
	@Column(name = "idusuario")
	private String idusuario;

	@Column(name = "idmatricula")
	private String idmatricula;
	
	@Column(name = "nivel")
	private String nivel;

	@Column(name = "grado")
	private String grado;
	
	@Column(name = "seccion")
	private String seccion;
	
	@Column(name = "apoderado")
	private String apoderado;
	
	@Column(name="nombrecompleto")
	private String nombrecompleto;
	
	@Column(name = "estado")
	private String estado;

	public String getIdalumno() {
		return idalumno;
	}

	public String getIdpersona() {
		return idpersona;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public String getIdmatricula() {
		return idmatricula;
	}

	public String getNivel() {
		return nivel;
	}

	public String getGrado() {
		return grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getApoderado() {
		return apoderado;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setIdpersona(String idpersona) {
		this.idpersona = idpersona;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public void setIdmatricula(String idmatricula) {
		this.idmatricula = idmatricula;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Alumno(String idalumno, String idpersona, String idusuario, String idmatricula, String nivel, String grado,
			String seccion, String apoderado, String nombrecompleto, String estado) {
		super();
		this.idalumno = idalumno;
		this.idpersona = idpersona;
		this.idusuario = idusuario;
		this.idmatricula = idmatricula;
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
		this.apoderado = apoderado;
		this.nombrecompleto = nombrecompleto;
		this.estado = estado;
	}

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
