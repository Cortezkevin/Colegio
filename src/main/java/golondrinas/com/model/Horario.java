package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

	@Id
	private String idhorario;
	
	@Column(name="nivel")
	private String nivel;
	
	@Column(name="grado")
	private String grado;
	
	@Column(name="seccion")
	private String seccion;
	
	@Column(name="dia")
	private String dia;
	
	@Column(name="curso")
	private String curso;
	
	@Column(name="hora_inicio")
	private String hora_inicio;
	
	@Column(name="hora_fin")
	private String hora_fin;
	
	@Column(name="estado")
	private String estado;

	public String getIdhorario() {
		return idhorario;
	}

	public String getNivel() {
		return nivel;
	}

	public String getGrado() {
		return grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getDia() {
		return dia;
	}

	public String getCurso() {
		return curso;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdhorario(String idhorario) {
		this.idhorario = idhorario;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Horario(String idhorario, String nivel, String grado, String seccion, String dia, String curso,
			String hora_inicio, String hora_fin, String estado) {
		super();
		this.idhorario = idhorario;
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
		this.dia = dia;
		this.curso = curso;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.estado = estado;
	}

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
