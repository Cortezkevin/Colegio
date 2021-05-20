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
	private String idHora;

	@Column(name="horaInicio")
	private String horaInicio;

	@Column(name="horaFin")
	private String horaFin;

	@Column(name="dia")
	private String dia;

	@OneToMany(mappedBy = "hor")
	private Collection<Horario> itemsHorario=new ArrayList<>();

	public String getIdHora() {
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

	public Collection<Horario> getItemsHorario() {
		return itemsHorario;
	}

	public void setIdHora(String idHora) {
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

	public void setItemsHorario(Collection<Horario> itemsHorario) {
		this.itemsHorario = itemsHorario;
	}

	public Hora(String idHora, String horaInicio, String horaFin, String dia, Collection<Horario> itemsHorario) {
		super();
		this.idHora = idHora;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
		this.itemsHorario = itemsHorario;
	}

	public Hora() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
