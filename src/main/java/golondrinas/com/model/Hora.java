package golondrinas.com.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hora")
public class Hora {

	@Id
	private String idhora;

	@Column(name="horainicio")
	private String horainicio;

	@Column(name="horafin")
	private String horafin;

	@Column(name="dia")
	private String dia;

	public String getIdhora() {
		return idhora;
	}

	public String getHorainicio() {
		return horainicio;
	}

	public String getHorafin() {
		return horafin;
	}

	public String getDia() {
		return dia;
	}

	public void setIdhora(String idhora) {
		this.idhora = idhora;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Hora(String idhora, String horainicio, String horafin, String dia) {
		super();
		this.idhora = idhora;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.dia = dia;
	}

	public Hora() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
