package inscripcionMaterias.prerrequisitosMaterias;
import java.util.Set;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;
import inscripcionMaterias.MateriaAprobada;

import java.util.HashSet;

public class PrerrequisitoCorrelativas extends Prerrequisito{
	private Set<String> correlativas; 
	
	public PrerrequisitoCorrelativas(Set<String> correlativas) {
		this. correlativas = correlativas;
	}
	
	public void agregarCorrelativa(Materia mat) {
		this.correlativas.add(mat.nombreMateria());
	}

	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		Boolean ret = true;
		for(String mat : this.correlativas) {
			ret = ret && nombresMateriasAprobadas(alumno.materiasAprobadas()).contains(mat);
		}
	 return ret;
	}

	public Set<String> nombresMateriasAprobadas(Set<MateriaAprobada> materias){
		Set<String> ret = new HashSet<String>();
		for(MateriaAprobada mat : materias) {
			ret.add(mat.materia());
		}
	  return ret;
	}
}
