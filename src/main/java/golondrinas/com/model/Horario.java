package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

	@Id
	private String idHorario;
	
	@Column(name="idNivel")
	private String idNivel;
	
	@Column(name="idGrado")
	private String idGrado;
	
	@Column(name="idCursoProgramado")
	private String idCursoProgramado;
	
	@ManyToOne
	@JoinColumn(name="id_hora", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_hora) references hora(id_hora)"))
	private Hora hor;
	
	@Column(name="estado")
	private String estado;

	public String getIdHorario() {
		return idHorario;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public String getIdGrado() {
		return idGrado;
	}

	public String getIdCursoProgramado() {
		return idCursoProgramado;
	}

	public Hora getHor() {
		return hor;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}

	public void setIdGrado(String idGrado) {
		this.idGrado = idGrado;
	}

	public void setIdCursoProgramado(String idCursoProgramado) {
		this.idCursoProgramado = idCursoProgramado;
	}

	public void setHor(Hora hor) {
		this.hor = hor;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Horario(String idHorario, String idNivel, String idGrado, String idCursoProgramado, Hora hor,
			String estado) {
		super();
		this.idHorario = idHorario;
		this.idNivel = idNivel;
		this.idGrado = idGrado;
		this.idCursoProgramado = idCursoProgramado;
		this.hor = hor;
		this.estado = estado;
	}

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
