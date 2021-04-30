package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profesores")
public class ProfesoresForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	
	@Column(name="idPersona")
	private Integer idPersona;
	
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Column(name="Estado")
	private String Estado;

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public ProfesoresForm(Integer idProfesor, Integer idPersona, Integer idUsuario, String estado) {
		super();
		this.idProfesor = idProfesor;
		this.idPersona = idPersona;
		this.idUsuario = idUsuario;
		Estado = estado;
	}

	public ProfesoresForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	 
	
}
