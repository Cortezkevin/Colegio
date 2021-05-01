package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pago")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPago;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fechaPago")
	private String fechaPago;
	
	@Column(name="idGrado")
	private Integer idGrado;
	
	@Column(name="idSeccion")
	private Integer idSeccion;
	
	@Column(name="idNivel")
	private Integer idNivel;

	public Integer getIdPago() {
		return idPago;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public Pago(Integer idPago, String estado, String fechaPago, Integer idGrado, Integer idSeccion, Integer idNivel) {
		super();
		this.idPago = idPago;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.idGrado = idGrado;
		this.idSeccion = idSeccion;
		this.idNivel = idNivel;
	}

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
