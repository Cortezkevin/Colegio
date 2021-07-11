package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="justificaciones")
public class Justificaciones {

	@Id
	private String idjustificacion;
	
	@Column(name="idasistencia")
	private String idasistencia;
	
	@Column(name="fecha_falta")
	private String fecha_falta;
	
	@Column(name="fecha_justi")
	private String fecha_justi;
	
	@Column(name="descripcion")
	private String descripcion;

	public String getIdjustificacion() {
		return idjustificacion;
	}

	public String getIdasistencia() {
		return idasistencia;
	}

	public String getFecha_falta() {
		return fecha_falta;
	}

	public String getFecha_justi() {
		return fecha_justi;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIdjustificacion(String idjustificacion) {
		this.idjustificacion = idjustificacion;
	}

	public void setIdasistencia(String idasistencia) {
		this.idasistencia = idasistencia;
	}

	public void setFecha_falta(String fecha_falta) {
		this.fecha_falta = fecha_falta;
	}

	public void setFecha_justi(String fecha_justi) {
		this.fecha_justi = fecha_justi;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Justificaciones(String idjustificacion, String idasistencia, String fecha_falta, String fecha_justi,
			String descripcion) {
		super();
		this.idjustificacion = idjustificacion;
		this.idasistencia = idasistencia;
		this.fecha_falta = fecha_falta;
		this.fecha_justi = fecha_justi;
		this.descripcion = descripcion;
	}

	public Justificaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
