package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotaBimestreRepository;
import golondrinas.com.interfaces.NotaXCursoRepository;
import golondrinas.com.interfaces.NotasRepository;
import golondrinas.com.model.AlumnosXAula;
import golondrinas.com.model.NotaXCurso;
import golondrinas.com.model.Notas;

@Service
public class NotasService {
	
	/*@Autowired
	private NotaBimestreRepository nbrepo;*/

	@Autowired
	private NotasRepository repository;
	

	public List<Notas> listarNotas() {
		return repository.listarNotas();
	}

	public void registrarNotasv2(Notas n) {
		repository.RegistrarNotasv2(n.getIdalumno(), n.getIdcurso(), n.getIdbimestre(), n.getExamen1(), n.getExamen2(),
				n.getExamen3(), n.getExamen4(), n.getPromedio());
		
		//nbrepo.RegistrarNotaBimestral(n.getIdalumno(), n.getIdcurso(),0.0,0.0,0.0,0.0,0.0);
	}

	public void actualizarNotasv2(Notas n) {
		repository.ActualizarNotasv2(n.getIdnota(), n.getIdalumno(), n.getIdcurso(), n.getIdbimestre(), n.getExamen1(),
				n.getExamen2(), n.getExamen3(), n.getExamen4(), n.getPromedio());
	}
	

	public boolean validarCursos(Notas nota){
		String curso =  repository.listarCursoXBimestre(nota.getIdalumno(), nota.getIdbimestre(), nota.getIdcurso());
			if(curso == null) {
				return true;
			}
			return false;
			
	}

	
	
}
