package inscripcionMaterias;

public class PrerrequisitoPorCreditos extends Prerrequisito{
	private Integer creditosNecesarios;
	
	public PrerrequisitoPorCreditos(Integer creditos) {
		this.creditosNecesarios = creditos;
	}
	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return alumno.creditosObtenidos() >= this.creditosNecesarios;
	}

}
