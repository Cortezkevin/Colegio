package golondrinas.com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asistenciaalumno")
public class AsistenciaAlumno {

	@Id
	private String idasistencia;
	
	@Column(name="idalumno")
	private String idalumno;
	
	@Column(name = "nombrealumno")
	private String nombrealumno;

	@Column(name = "fecha")
	private String fecha;
	/*@Column(name="asis")
	private Integer asis;
	
	@Column(name="inasis")
	private Integer inasis;
	
	@Column(name="dias")
	private Integer dias;*/
	
	@Column(name="estado")
	private String estado;
	
	@Column(name = "comentario")
	private String comentario;

	public String getIdasistencia() {
		return idasistencia;
	}

	public String getIdalumno() {
		return idalumno;
	}

	public String getNombrealumno() {
		return nombrealumno;
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

	public void setIdasistencia(String idasistencia) {
		this.idasistencia = idasistencia;
	}

	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}

	public void setNombrealumno(String nombrealumno) {
		this.nombrealumno = nombrealumno;
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

	public AsistenciaAlumno(String idasistencia, String idalumno, String nombrealumno, String fecha, String estado,
			String comentario) {
		super();
		this.idasistencia = idasistencia;
		this.idalumno = idalumno;
		this.nombrealumno = nombrealumno;
		this.fecha = fecha;
		this.estado = estado;
		this.comentario = comentario;
	}

	public AsistenciaAlumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
