package golondrinas.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotaBimestreRepository;
import golondrinas.com.model.NotaBimestre;

@Service
public class NotaBimestreService {
	@Autowired
	private NotaBimestreRepository repository;

	public void RegistrarNotaBimestral(NotaBimestre n) {
		repository.RegistrarNotaBimestral(n.getIdalumno(), n.getIdcurso(), n.getNota_bimestre1(), n.getNota_bimestre2(),
				n.getNota_bimestre3(), n.getNota_bimestre4(), n.getPromedio_anual());
	}

	public void ActualizarNotaBimestral(NotaBimestre n) {
		repository.ActualizarNotaBimestral(n.getIdnotabimestre(), n.getIdalumno(), n.getIdcurso(),
				n.getNota_bimestre1(), n.getNota_bimestre2(), n.getNota_bimestre3(), n.getNota_bimestre4(),
				n.getPromedio_anual());
	}

	public boolean validarCurso(NotaBimestre n) {
		String curso = repository.CursoXBimestre(n.getIdalumno(), n.getIdcurso());
		if (curso == null) {
			return true;
		}
		return false;
	}
}
