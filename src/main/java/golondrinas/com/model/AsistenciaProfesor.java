package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asistenciaprofesor")
public class AsistenciaProfesor {
	
	@Id
	private String idasistenciap;
	
	@Column(name="idprofesor")
	private String idprofesor;
	
	@Column(name="nombreprofesor")
	private String nombreprofesor;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="comentario")
	private String comentario;

	public String getIdasistenciap() {
		return idasistenciap;
	}

	public String getIdprofesor() {
		return idprofesor;
	}

	public String getNombreprofesor() {
		return nombreprofesor;
	}

	public String getFecha() {
		return fecha;
	}

	public String getEstado() {
		return estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setIdasistenciap(String idasistenciap) {
		this.idasistenciap = idasistenciap;
	}

	public void setIdprofesor(String idprofesor) {
		this.idprofesor = idprofesor;
	}

	public void setNombreprofesor(String nombreprofesor) {
		this.nombreprofesor = nombreprofesor;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public AsistenciaProfesor(String idasistenciap, String idprofesor, String nombreprofesor, String fecha,
			String estado, String comentario) {
		super();
		this.idasistenciap = idasistenciap;
		this.idprofesor = idprofesor;
		this.nombreprofesor = nombreprofesor;
		this.fecha = fecha;
		this.estado = estado;
		this.comentario = comentario;
	}

	public AsistenciaProfesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
