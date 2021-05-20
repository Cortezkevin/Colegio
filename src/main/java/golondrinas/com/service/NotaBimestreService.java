package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotaBimestreRepository;
import golondrinas.com.model.NotaBimestre;

@Service
public class NotaBimestreService {

	@Autowired
	private NotaBimestreRepository repository;

	public List<NotaBimestre> listarNotaBimestre() {
		return repository.findAll();
	}

	public void registrarNotaBimestre(NotaBimestre n) {
		repository.save(n);
	}

	public Optional<NotaBimestre> BuscarPorId(Integer id) {
		return repository.findById(id);
	}
}
