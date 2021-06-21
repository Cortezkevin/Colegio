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
	
	@Column(name="idbimestre")
	private String idbimestre; 
	
	@Column(name="examen1")
	private Double examen1;
	
	@Column(name="examen2")
	private Double examen2;
	
	@Column(name="examen3")
	private Double examen3;
	
	@Column(name="examen4")
	private Double examen4;
	
	@Column(name="promedio")
	private Double promedio;
	
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

	public String getIdbimestre() {
		return idbimestre;
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

	public Double getExamen4() {
		return examen4;
	}

	public Double getPromedio() {
		return promedio;
	}

	public String getEstado() {
		return estado;
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

	public void setIdbimestre(String idbimestre) {
		this.idbimestre = idbimestre;
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

	public void setExamen4(Double examen4) {
		this.examen4 = examen4;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Notas(String idnota, String idalumno, String idcurso, String idbimestre, Double examen1, Double examen2,
			Double examen3, Double examen4, Double promedio, String estado) {
		super();
		this.idnota = idnota;
		this.idalumno = idalumno;
		this.idcurso = idcurso;
		this.idbimestre = idbimestre;
		this.examen1 = examen1;
		this.examen2 = examen2;
		this.examen3 = examen3;
		this.examen4 = examen4;
		this.promedio = promedio;
		this.estado = estado;
	}

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
