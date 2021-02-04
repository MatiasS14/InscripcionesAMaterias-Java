package inscripcionMaterias;

public abstract class Prerrequisito {
	public Prerrequisito() {}
	
	public abstract Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia);
}
