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
	private String idpago;
	
	@Column(name="idmatricula")
	private String idmatricula;

	@Column(name="fechapago")
	private String fechapago;
	
	@Column(name="monto")
	private Double monto;
	
	@Column(name="estado")
	private String estado;

	public String getIdpago() {
		return idpago;
	}

	public String getIdmatricula() {
		return idmatricula;
	}

	public String getFechapago() {
		return fechapago;
	}

	public Double getMonto() {
		return monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdpago(String idpago) {
		this.idpago = idpago;
	}

	public void setIdmatricula(String idmatricula) {
		this.idmatricula = idmatricula;
	}

	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pago(String idpago, String idmatricula, String fechapago, Double monto, String estado) {
		super();
		this.idpago = idpago;
		this.idmatricula = idmatricula;
		this.fechapago = fechapago;
		this.monto = monto;
		this.estado = estado;
	}

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
