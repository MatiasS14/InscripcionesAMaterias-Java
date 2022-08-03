package inscripcionMaterias.prerrequisitosMaterias;
import java.util.Set;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;
import inscripcionMaterias.MateriaAprobada;
import inscripcionMaterias.Errores.ErrorPrerrequisito;

import java.util.HashSet;

public class PrerrequisitoCorrelativas extends Prerrequisito{
	private Set<String> correlativas; 
	
	public PrerrequisitoCorrelativas(Set<String> correlativas) throws ErrorPrerrequisito{
		verificarCorrelativas(correlativas);
		this. correlativas = correlativas;
	}
	
	private void verificarCorrelativas(Set<String> correlativas) throws ErrorPrerrequisito{
		if(correlativas.size() < 1) {
			throw new ErrorPrerrequisito("Debe haber al menos una materia correlativa");
		}
	}
	
	public void agregarCorrelativa(Materia mat) throws ErrorPrerrequisito{
		if(!this.correlativas.contains(mat)) {
		 this.correlativas.add(mat.nombreMateria());
		}else {throw new ErrorPrerrequisito("La materia ya se encuentra agregada");}
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
