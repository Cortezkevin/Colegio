package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteAsistenciaAlumnos {

	@Id
	@Column(name = "nombrealumno")
	private String nombrealumno;

	@Column(name = "asis")
	private Integer asis;

	@Column(name = "inasis")
	private Integer inasis;

	@Column(name = "tard")
	private Integer tard;

	public String getNombrealumno() {
		return nombrealumno;
	}

	public Integer getAsis() {
		return asis;
	}

	public Integer getInasis() {
		return inasis;
	}

	public Integer getTard() {
		return tard;
	}

	public void setNombrealumno(String nombrealumno) {
		this.nombrealumno = nombrealumno;
	}

	public void setAsis(Integer asis) {
		this.asis = asis;
	}

	public void setInasis(Integer inasis) {
		this.inasis = inasis;
	}

	public void setTard(Integer tard) {
		this.tard = tard;
	}

	public ReporteAsistenciaAlumnos(String nombrealumno, Integer asis, Integer inasis, Integer tard) {
		super();
		this.nombrealumno = nombrealumno;
		this.asis = asis;
		this.inasis = inasis;
		this.tard = tard;
	}

	public ReporteAsistenciaAlumnos() {
		super();
		// TODO Auto-generated constructor stub
	}

}
