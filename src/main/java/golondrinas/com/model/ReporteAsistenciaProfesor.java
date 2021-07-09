package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="reporteasistenciaprofesor")
public class ReporteAsistenciaProfesor {

	@Id
	@Column(name="nombreprofesor")
	private String nombreprofesor;
	
	@Column(name="asis")
	private Integer asis;
	
	@Column(name="inasis")
	private Integer inasis;
	
	@Column(name="tard")
	private Integer tard;

	public String getNombreprofesor() {
		return nombreprofesor;
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

	public void setNombreprofesor(String nombreprofesor) {
		this.nombreprofesor = nombreprofesor;
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

	public ReporteAsistenciaProfesor(String nombreprofesor, Integer asis, Integer inasis, Integer tard) {
		super();
		this.nombreprofesor = nombreprofesor;
		this.asis = asis;
		this.inasis = inasis;
		this.tard = tard;
	}

	public ReporteAsistenciaProfesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
