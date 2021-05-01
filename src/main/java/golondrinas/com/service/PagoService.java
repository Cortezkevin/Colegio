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
		return repository.findAll();
	}
	
	public void registrarPago(Pago p) {
		repository.save(p);
	}
	
	public Optional<Pago> BuscarPorId(Integer id){
		return repository.findById(id);
	}
	
}
