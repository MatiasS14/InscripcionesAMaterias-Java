package inscripcionMaterias.prerrequisitosMaterias;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;

public class SinPrerrequisito extends Prerrequisito{

	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumo, Materia materia) {
		return true;
	}

}
