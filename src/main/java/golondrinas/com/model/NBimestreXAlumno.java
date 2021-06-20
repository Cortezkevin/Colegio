package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NBimestreXAlumno {

	@Id
	private String idnotabimestre;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name = "idalumno")
	private String idalumno;
	
	@Column(name = "idcurso")
	private String idcurso;
	
	@Column(name="nota_bimestre1")
	private Double nota_bimestre1;

	@Column(name="nota_bimestre2")
	private Double nota_bimestre2;

	@Column(name="nota_bimestre3")
	private Double nota_bimestre3;

	@Column(name="nota_bimestre4")
	private Double nota_bimestre4;

	@Column(name="promedio_anual")
	private Double promedio_anual;

	public String getIdnotabimestre() {
		return idnotabimestre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getIdcurso() {
		return idcurso;
	}

	public Double getNota_bimestre1() {
		return nota_bimestre1;
	}

	public Double getNota_bimestre2() {
		return nota_bimestre2;
	}

	public Double getNota_bimestre3() {
		return nota_bimestre3;
	}

	public Double getNota_bimestre4() {
		return nota_bimestre4;
	}

	public Double getPromedio_anual() {
		return promedio_anual;
	}

	public void setIdnotabimestre(String idnotabimestre) {
		this.idnotabimestre = idnotabimestre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public void setNota_bimestre1(Double nota_bimestre1) {
		this.nota_bimestre1 = nota_bimestre1;
	}

	public void setNota_bimestre2(Double nota_bimestre2) {
		this.nota_bimestre2 = nota_bimestre2;
	}

	public void setNota_bimestre3(Double nota_bimestre3) {
		this.nota_bimestre3 = nota_bimestre3;
	}

	public void setNota_bimestre4(Double nota_bimestre4) {
		this.nota_bimestre4 = nota_bimestre4;
	}

	public void setPromedio_anual(Double promedio_anual) {
		this.promedio_anual = promedio_anual;
	}

	public NBimestreXAlumno(String idnotabimestre, String nombre, String idalumno, String idcurso,
			Double nota_bimestre1, Double nota_bimestre2, Double nota_bimestre3, Double nota_bimestre4,
			Double promedio_anual) {
		super();
		this.idnotabimestre = idnotabimestre;
		this.nombre = nombre;
		this.idalumno = idalumno;
		this.idcurso = idcurso;
		this.nota_bimestre1 = nota_bimestre1;
		this.nota_bimestre2 = nota_bimestre2;
		this.nota_bimestre3 = nota_bimestre3;
		this.nota_bimestre4 = nota_bimestre4;
		this.promedio_anual = promedio_anual;
	}

	public NBimestreXAlumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
