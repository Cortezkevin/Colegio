package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotaXCurso {

	@Id
	private String idnotas;
	
	@Column(name = "idalumno")
	private String idalumno;
	
	@Column(name = "idcurso")
	private String idcurso;
	
	@Column(name="nombre")
	private String nombre;
	
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

	public String getIdnotas() {
		return idnotas;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getIdcurso() {
		return idcurso;
	}

	public String getNombre() {
		return nombre;
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

	public void setIdnotas(String idnotas) {
		this.idnotas = idnotas;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public NotaXCurso(String idnotas, String idalumno, String idcurso, String nombre, Double examen1, Double examen2,
			Double examen3, Double examen4, Double promedio) {
		super();
		this.idnotas = idnotas;
		this.idalumno = idalumno;
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.examen1 = examen1;
		this.examen2 = examen2;
		this.examen3 = examen3;
		this.examen4 = examen4;
		this.promedio = promedio;
	}

	public NotaXCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
