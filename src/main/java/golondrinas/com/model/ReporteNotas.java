package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "reportenotas")
public class ReporteNotas {

	@Id
	@Column(name="curso")
	private String curso;
	
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

	public String getCurso() {
		return curso;
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

	public void setCurso(String curso) {
		this.curso = curso;
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

	public ReporteNotas(String curso, Double examen1, Double examen2, Double examen3, Double examen4, Double promedio) {
		super();
		this.curso = curso;
		this.examen1 = examen1;
		this.examen2 = examen2;
		this.examen3 = examen3;
		this.examen4 = examen4;
		this.promedio = promedio;
	}

	public ReporteNotas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
