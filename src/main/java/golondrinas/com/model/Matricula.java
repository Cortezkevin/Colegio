package golondrinas.com.model;

import javax.persistence.ForeignKey;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="matricula")
public class Matricula{

	@Id
	private String idmatricula;
	
	@Column(name="idalumno")
	private String idalumno;
	/*
	@Column(name="idusuario")
	private String idusuario;
	*/
	@Column(name="idnivel")
	private String idnivel;
	
	@Column(name="idgrado")
	private String idgrado;
	
	@Column(name="idseccion")
	private String idseccion;
	/*
	@ManyToOne
	@JoinColumn(name="id_nivel", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_nivel) references nivel(id_nivel)"))
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name="id_grado", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_grado) references grado(id_grado)"))
	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name="id_seccion", nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_seccion) references seccion(id_seccion)"))
	private Seccion seccion;
	*/
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha")
	private String fecha;

	public String getIdmatricula() {
		return idmatricula;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public String getIdgrado() {
		return idgrado;
	}

	public String getIdseccion() {
		return idseccion;
	}

	public String getEstado() {
		return estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setIdmatricula(String idmatricula) {
		this.idmatricula = idmatricula;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public void setIdseccion(String idseccion) {
		this.idseccion = idseccion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Matricula(String idmatricula, String idalumno, String idnivel, String idgrado, String idseccion,
			String estado, String fecha) {
		super();
		this.idmatricula = idmatricula;
		this.idalumno = idalumno;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.idseccion = idseccion;
		this.estado = estado;
		this.fecha = fecha;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
