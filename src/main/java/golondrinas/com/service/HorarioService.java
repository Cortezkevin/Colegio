package golondrinas.com.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.HorarioRepository;
import golondrinas.com.model.Horario;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repository;
	
	public List<Horario> listarHorario(String nivel, String grado, String seccion){
		return repository.listarHorario(nivel, grado, seccion);
	}
	
	
	public void registrarHorario(Horario h) {
			repository.RegistrarHorario(h.getNivel(), h.getGrado(), h.getSeccion(),
					h.getDia(), h.getCurso(), h.getHora_inicio(), h.getHora_fin());
		}
		
	public void ActualizarHorario(Horario h) {
			repository.ActualizarHorario(h.getIdhorario(),h.getDia(), h.getCurso(), h.getHora_inicio(), h.getHora_fin());
		}
		
	
	
	public void eliminarHorario(Horario horario) {
		repository.EliminarHorario(horario.getIdhorario());
	}
	
	public boolean validarHorario(Horario h) {
		String curso = repository.validarHorario(h.getCurso(), h.getDia(), h.getNivel(), h.getGrado(), h.getSeccion());
		if(curso == null) {
			return false;
		}
		return true;
	}
	
	
	/*public boolean validarNombre(Horario obj) {
		List<String> lista = repository.validarNombre(obj.getDia(), obj.getEstado(), obj.getHorafin(), obj.getHoraini(), obj.getIdcurso(), obj.getIdgrado(), obj.getIdnivel(), obj.getSeccion());
		if(lista == null) {
			return true;
		}
		
		return false;
	}*/
}
