package golondrinas.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

	@Id
	private String idhorario;
	
	@Column(name="idnivel")
	private String idnivel;
	
	@Column(name="idgrado")
	private String idgrado;
	
	@Column(name="idcursoprogramado")
	private String idcursoprogramado;
	
	@Column(name="estado")
	private String estado;

	public String getIdhorario() {
		return idhorario;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public String getIdgrado() {
		return idgrado;
	}

	public String getIdcursoprogramado() {
		return idcursoprogramado;
	}

	public String getEstado() {
		return estado;
	}

	public void setIdhorario(String idhorario) {
		this.idhorario = idhorario;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public void setIdgrado(String idgrado) {
		this.idgrado = idgrado;
	}

	public void setIdcursoprogramado(String idcursoprogramado) {
		this.idcursoprogramado = idcursoprogramado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Horario(String idhorario, String idnivel, String idgrado, String idcursoprogramado, String estado) {
		super();
		this.idhorario = idhorario;
		this.idnivel = idnivel;
		this.idgrado = idgrado;
		this.idcursoprogramado = idcursoprogramado;
		this.estado = estado;
	}

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
