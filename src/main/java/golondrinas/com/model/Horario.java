package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorario;
	
	@Column(name="idNivel")
	private Integer idNivel;
	
	@Column(name="idGrado")
	private Integer idGrado;
	
	@Column(name="idCursoProgramado")
	private Integer idCursoProgramado;
	
	@Column(name="idHora")
	private Integer idHora;
	
	@Column(name="estado")
	private String estado;

	public Integer getIdHorario() {
		return idHorario;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public Integer getIdCursoProgramado() {
		return idCursoProgramado;
	}

	public Integer getIdHora() {
		return idHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public void setIdCursoProgramado(Integer idCursoProgramado) {
		this.idCursoProgramado = idCursoProgramado;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Horario(Integer idHorario, Integer idNivel, Integer idGrado, Integer idCursoProgramado, Integer idHora,
			String estado) {
		super();
		this.idHorario = idHorario;
		this.idNivel = idNivel;
		this.idGrado = idGrado;
		this.idCursoProgramado = idCursoProgramado;
		this.idHora = idHora;
		this.estado = estado;
	}

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
