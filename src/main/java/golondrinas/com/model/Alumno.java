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
	
	@Column(name = "idapoderado")
	private String idapoderado;

	@Column(name = "idusuario")
	private String idusuario;

	@Column(name = "idnivel")
	private String idnivel;

	@Column(name = "idgrado")
	private String idgrado;

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

	public String getIdapoderado() {
		return idapoderado;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public String getIdgrado() {
		return idgrado;
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

	public void setIdapoderado(String idapoderado) {
		this.idapoderado = idapoderado;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Alumno(String idalumno, String idpersona, String idapoderado, String idusuario, String idnivel,
			String idgrado, String nombrecompleto, String estado) {
		super();
		this.idalumno = idalumno;
		this.idpersona = idpersona;
		this.idapoderado = idapoderado;
		this.idusuario = idusuario;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.nombrecompleto = nombrecompleto;
		this.estado = estado;
	}

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
