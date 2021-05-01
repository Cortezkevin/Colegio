package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hora")
public class Hora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHora;

	@Column(name="horaInicio")
	private String horaInicio;

	@Column(name="horaFin")
	private String horaFin;

	@Column(name="dia")
	private String dia;

	public Integer getIdHora() {
		return idHora;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Hora(Integer idHora, String horaInicio, String horaFin, String dia) {
		super();
		this.idHora = idHora;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
	}

	public Hora() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
