package inscripcionMaterias;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

public class SistemaInscripcion {
	private Set<Carrera> carreras;
	
	public SistemaInscripcion() {
		this.carreras = new HashSet<Carrera>();
	}
	
	public void agregarCarrera(Carrera carrera) {
		this.carreras.add(carrera);
	}
	
	public Set<Estudiante> alumnosInscriptos(Materia materia){
		return materia.alumnosInscriptos();
	}
	public Queue<Estudiante> alumnosEnEspera(Materia materia){
	   	return materia.listaDeEspera();
	}
	
	public Set<Materia> materiasParaCursar(Estudiante est, Carrera carrera){
	  return carrera.materiasParaCursas(est);
	}
	
	public Set<Carrera> carreras(){
		return this.carreras;
	}
	
	public Set<Materia> materiasAlumnoInscripto(Estudiante alu){
		return materiasInscripto(alu, alu.materiasInscripto());
	}
	
	private Set<Materia> materiasInscripto(Estudiante alu, Set<Materia> materias) {
		Set<Materia> ret = new HashSet<Materia>();
		for(Materia mat : materias) {
			if(mat.alumnosInscriptos().contains(alu)) {
				ret.add(mat);
			}
		}
		return ret;
	}
	
	public Set<Materia> materiasAlumnoEnEspera(Estudiante alu){
		return materiasEnEspera(alu, alu.materiasInscripto());
	}

	private Set<Materia> materiasEnEspera(Estudiante alu, Set<Materia> materias) {
		Set<Materia> ret = new HashSet<Materia>();
		for(Materia mat : materias) {
			if(mat.listaDeEspera().contains(alu)) {
				ret.add(mat);
			}
		}
	 return ret;
	}
}
