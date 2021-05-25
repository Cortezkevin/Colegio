package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notas")
public class Notas {

	@Id
	private String idnota; 
	
	@Column(name="idalumno")
	private String idalumno;
	
	@Column(name="idcurso")
	private String idcurso; 
	
	@Column(name="idseccion")
	private String idseccion; 
	
	@Column(name="idprofesor")
	private String idprofesor; 
	
	@Column(name="examen1")
	private Double examen1;
	
	@Column(name="examen2")
	private Double examen2;
	
	@Column(name="examen3")
	private Double examen3;
	
	@Column(name="examen4")
	private Double examen4;
	
	@Column(name = "estado")
	private String estado;

	public String getIdnota() {
		return idnota;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getIdcurso() {
		return idcurso;
	}

	public String getIdseccion() {
		return idseccion;
	}

	public String getIdprofesor() {
		return idprofesor;
	}

	public Double getExamen1() {
		return examen1;
	}

	public Double getExamen2() {
		return examen2;
	}

	public Double getExamen3() {
		return examen3;
	}

	public void setIdnota(String idnota) {
		this.idnota = idnota;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public void setIdseccion(String idseccion) {
		this.idseccion = idseccion;
	}

	public void setIdprofesor(String idprofesor) {
		this.idprofesor = idprofesor;
	}

	public void setExamen1(Double examen1) {
		this.examen1 = examen1;
	}

	public void setExamen2(Double examen2) {
		this.examen2 = examen2;
	}

	public void setExamen3(Double examen3) {
		this.examen3 = examen3;
	}



	public Double getExamen4() {
		return examen4;
	}

	public String getEstado() {
		return estado;
	}

	public void setExamen4(Double examen4) {
		this.examen4 = examen4;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Notas(String idnota, String idalumno, String idcurso, String idseccion, String idprofesor, Double examen1,
			Double examen2, Double examen3, Double examen4, String estado) {
		super();
		this.idnota = idnota;
		this.idalumno = idalumno;
		this.idcurso = idcurso;
		this.idseccion = idseccion;
		this.idprofesor = idprofesor;
		this.examen1 = examen1;
		this.examen2 = examen2;
		this.examen3 = examen3;
		this.examen4 = examen4;
		this.estado = estado;
	}

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
