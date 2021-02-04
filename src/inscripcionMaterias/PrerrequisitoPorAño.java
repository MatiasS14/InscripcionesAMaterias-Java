package inscripcionMaterias;
import java.util.Set;
import java.util.HashSet;

public class PrerrequisitoPorAño extends Prerrequisito{
	private Integer año;
	private Carrera carrera;
	
	public PrerrequisitoPorAño(Integer año, Carrera carrera) {
		this.año = año;
		this.carrera = carrera;
	}

	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return 	alumno.materiasDeAño(this.año).size() == this.carrera.materiasDeAño(this.año).size();//this.materiasAño.size();
	}
	
	public Set<Materia> materiasAño(){
		return this.carrera.materiasDeAño(this.año);
	}
}
