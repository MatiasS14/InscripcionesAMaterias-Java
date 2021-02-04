package inscripcionMaterias;

public class SinPrerrequisito extends Prerrequisito{

	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumo, Materia materia) {
		return true;
	}

}
