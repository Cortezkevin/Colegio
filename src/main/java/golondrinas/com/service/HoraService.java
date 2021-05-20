package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.HoraRepository;
import golondrinas.com.model.Hora;

@Service
public class HoraService {

	@Autowired
	private HoraRepository repository;

	public List<Hora> listarHora() {
		return repository.findAll();
	}

	public void registrarHora(Hora h) {
		repository.save(h);
	}

	public Optional<Hora> BuscarPorId(Integer id) {
		return repository.findById(id);
	}
}
