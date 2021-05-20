package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notaBimestre")
public class NotaBimestre {
	
	@Id
	private String idNotaBimestre;
	
	@Column(name="promedio")
	private Double promedio;

	@Column(name="")
	private String idNota;

	public String getIdNotaBimestre() {
		return idNotaBimestre;
	}

	public Double getPromedio() {
		return promedio;
	}

	public String getIdNota() {
		return idNota;
	}

	public void setIdNotaBimestre(String idNotaBimestre) {
		this.idNotaBimestre = idNotaBimestre;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public void setIdNota(String idNota) {
		this.idNota = idNota;
	}

	public NotaBimestre(String idNotaBimestre, Double promedio, String idNota) {
		super();
		this.idNotaBimestre = idNotaBimestre;
		this.promedio = promedio;
		this.idNota = idNota;
	}

	public NotaBimestre() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
