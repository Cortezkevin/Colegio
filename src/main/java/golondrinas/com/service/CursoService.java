package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.CursoRepository;
import golondrinas.com.model.Curso;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;	
	
	public List<Curso> listarCursos(){
		return repository.findAll();
	}
	
	public List<Curso> listarCursosValidos(){
		return repository.listarCursoValidos();
	}
	
	public void registrarCurso(Curso curso) {
		if(curso.getIdcurso() == null) {
			repository.registrarCurso(curso.getIdnivel(),curso.getIdgrado(),curso.getNombre(), curso.getDescripcion());	
		}else {
			repository.actualizarCurso(curso.getIdcurso(),
					curso.getIdnivel(), curso.getIdgrado(), curso.getNombre(), curso.getDescripcion()
					);
		}
	}
	public void eliminarCurso(Curso curso) {
		repository.eliminarCurso(curso.getIdcurso());
	}

	public boolean validarNombre(Curso obj) {
		String Nombre = repository.validarCurso(obj.getNombre()); 
		if(Nombre.equals(obj.getNombre())) {
			return true;
		}
		return false;
	}
	
	public boolean validarEstadoCurso(Curso n){
		String lista = repository.ValidarEstadoCurso(n.getIdcurso());
		if(lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
	
}
