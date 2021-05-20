package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	private String idalumno;

	@Column(name = "idpersona")
	private String idpersona;

	@Column(name = "idusuario")
	private String idusuario;

	@Column(name = "idnivel")
	private String idnivel;

	@Column(name = "idgrado")
	private String idgrado;

	@Column(name = "estado")
	private String estado;

	public String getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
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

	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public String getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Alumno(String idalumno, String idpersona, String idusuario, String idnivel, String idgrado, String estado) {
		super();
		this.idalumno = idalumno;
		this.idpersona = idpersona;
		this.idusuario = idusuario;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.estado = estado;
	}

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub

	}
}
