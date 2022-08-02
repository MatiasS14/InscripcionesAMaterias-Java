package inscripcionMaterias.prerrequisitosMaterias;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;

public abstract class Prerrequisito {
	public Prerrequisito() {}
	
	public abstract Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia);
}
