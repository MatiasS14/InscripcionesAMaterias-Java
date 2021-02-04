package inscripcionMaterias;

public class PrerrequisitoPorA�o extends Prerrequisito{
	private Integer a�o;
	private Carrera carrera;
	
	public PrerrequisitoPorA�o(Integer a�o, Carrera carrera) {
		this.a�o = a�o;
		this.carrera = carrera;
	}

	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return 	alumno.materiasDeA�o(this.a�o).size() == this.carrera.materiasDeA�o(this.a�o).size();//this.materiasA�o.size();
	}
	
}
