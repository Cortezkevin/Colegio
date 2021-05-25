package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.DetalleMatriculaRepository;
import golondrinas.com.model.DetalleMatricula;

@Service
public class DetalleMatriculaService {

	@Autowired
	private DetalleMatriculaRepository repository;

	public List<DetalleMatricula> listarDetalleMatriculas(String idmatricula) {
		return repository.listarDetalleMatricula(idmatricula);
	}
}
