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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHora;
	
	@Column(name="promedio")
	private Double promedio;

	@Column(name="")
	private Integer idNota;

	public Integer getIdHora() {
		return idHora;
	}

	public Double getPromedio() {
		return promedio;
	}

	public Integer getIdNota() {
		return idNota;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	public NotaBimestre(Integer idHora, Double promedio, Integer idNota) {
		super();
		this.idHora = idHora;
		this.promedio = promedio;
		this.idNota = idNota;
	}

	public NotaBimestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
