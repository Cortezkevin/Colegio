package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotasRepository;
import golondrinas.com.model.Notas;

@Service
public class NotasService {

	@Autowired
	private NotasRepository repository;

	public List<Notas> listarNotas() {
		return repository.listarNotas();
	}

	public void registrarNotas(Notas n) {
		if (n.getIdnota() == null) {
			repository.RegistrarNotas(n.getIdalumno(), n.getIdcurso(), n.getIdnotabimestre(), n.getExamen1(),
					n.getExamen2(), n.getExamen3(), n.getExamen4(), n.getPromedio());
		} else {
			repository.ActualizarNotas(n.getIdnota(), n.getIdalumno(), n.getIdcurso(), n.getIdnotabimestre(),
					n.getExamen1(), n.getExamen2(), n.getExamen3(), n.getExamen4(), n.getPromedio());
		}
	}


}
