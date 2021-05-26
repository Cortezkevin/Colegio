package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.PagoRepository;
import golondrinas.com.model.Pago;

@Service
public class PagoService {

	@Autowired
	private PagoRepository repository;
	
	public List<Pago> listarPago(){
		return repository.listadoPagos();
	}
	
	public void registrarPago(Pago p) {
		if(p.getIdpago() == null) {
			repository.RegistrarPago(p.getIdmatricula(), p.getFechapago(), p.getMonto());
		}else {
			repository.ActualizarPago(p.getIdpago(),p.getIdmatricula(), p.getFechapago(), p.getMonto());
		}
	}
	
	public void eliminarPago(Pago p){
	 repository.EliminarPago(p.getIdpago());
	}
	
	
}
