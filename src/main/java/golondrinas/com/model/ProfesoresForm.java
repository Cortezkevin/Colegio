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
	private String idProfesor;
	
	@Column(name="idPersona")
	private String idPersona;
	
	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="Estado")
	private String Estado;

	public String getIdProfesor() {
		return idProfesor;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public String getEstado() {
		return Estado;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public ProfesoresForm(String idProfesor, String idPersona, String idUsuario, String estado) {
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
