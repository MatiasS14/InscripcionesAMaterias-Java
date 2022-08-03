package inscripcionMaterias.prerrequisitosMaterias;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;
import inscripcionMaterias.Errores.ErrorPrerrequisito;

public class PrerrequisitoPorCreditos extends Prerrequisito{
	private Integer creditosNecesarios;
	
	public PrerrequisitoPorCreditos(Integer creditos) throws ErrorPrerrequisito{
		if(creditos > 0 ) {
		 this.creditosNecesarios = creditos;
		}else {
			throw new ErrorPrerrequisito("La cantidad de creditos necesarios debe ser mayor a 0");
		}
	}
	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return alumno.creditosObtenidos() >= this.creditosNecesarios;
	}

}
