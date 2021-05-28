package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asistencias")
public class Asistencias {

	@Id
	private String idasistencia;
	
	@Column(name="idalumno")
	private String idalumno;
	
	@Column(name="inasist_justificada")
	private String inasist_justificada;
	
	@Column(name="inasist_injustificada")
	private String inasist_injustificada;
	
	@Column(name="tard_justificada")
	private String tard_justificada;
	
	@Column(name="tard_injustificada")
	private String tard_injustificada;

	public String getIdasistencia() {
		return idasistencia;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getInasist_justificada() {
		return inasist_justificada;
	}

	public String getInasist_injustificada() {
		return inasist_injustificada;
	}

	public String getTard_justificada() {
		return tard_justificada;
	}

	public String getTard_injustificada() {
		return tard_injustificada;
	}

	public void setIdasistencia(String idasistencia) {
		this.idasistencia = idasistencia;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setInasist_justificada(String inasist_justificada) {
		this.inasist_justificada = inasist_justificada;
	}

	public void setInasist_injustificada(String inasist_injustificada) {
		this.inasist_injustificada = inasist_injustificada;
	}

	public void setTard_justificada(String tard_justificada) {
		this.tard_justificada = tard_justificada;
	}

	public void setTard_injustificada(String tard_injustificada) {
		this.tard_injustificada = tard_injustificada;
	}

	public Asistencias(String idasistencia, String idalumno, String inasist_justificada, String inasist_injustificada,
			String tard_justificada, String tard_injustificada) {
		super();
		this.idasistencia = idasistencia;
		this.idalumno = idalumno;
		this.inasist_justificada = inasist_justificada;
		this.inasist_injustificada = inasist_injustificada;
		this.tard_justificada = tard_justificada;
		this.tard_injustificada = tard_injustificada;
	}

	public Asistencias() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
