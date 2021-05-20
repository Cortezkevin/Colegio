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
	private String idPago;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fechaPago")
	private String fechaPago;
	
	@Column(name="idGrado")
	private String idGrado;
	
	@Column(name="idSeccion")
	private String idSeccion;
	
	@Column(name="idNivel")
	private String idNivel;

	public String getIdPago() {
		return idPago;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public String getIdGrado() {
		return idGrado;
	}

	public String getIdSeccion() {
		return idSeccion;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public void setIdGrado(String idGrado) {
		this.idGrado = idGrado;
	}

	public void setIdSeccion(String idSeccion) {
		this.idSeccion = idSeccion;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}

	public Pago(String idPago, String estado, String fechaPago, String idGrado, String idSeccion, String idNivel) {
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
