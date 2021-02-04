package inscripcionMaterias;
import java.util.Set;
import java.util.HashSet;

public class Carrera {
	private Set<Materia> materias;
	private Set<Estudiante> alumnos;
	
	public Carrera() {
		this.materias = new HashSet<Materia>();
		this.alumnos= new HashSet<Estudiante>();
	}
	
	public void agregarMateria(Materia mat) {
		this.materias.add(mat);
	}
	
	public void inscribirAlumno(Estudiante est) {
		if(!this.alumnos.contains(est)) {
		 this.alumnos.add(est);
		}
	}
	
	public Set<Materia> materiasParaCursas(Estudiante alumno){
		Set<Materia> materias = new HashSet<Materia>();
		if(this.alumnos.contains(alumno)) {
			for(Materia materia : this.materias) {
				if(materia.cumplePrerrequisitos(alumno) && !alumno.yaAprobo(materia)) {
					materias.add(materia);
				}
			}
		}
		return materias;
	}
	
	public Set<Materia> materiasDeA�o(Integer a�o){
		Set<Materia> materias = new HashSet<Materia>();
		for(Materia materia : this.materias) {
			if(materia.a�o() == a�o) {
				materias.add(materia);
			}
		}
	return materias;
	}
	
}
