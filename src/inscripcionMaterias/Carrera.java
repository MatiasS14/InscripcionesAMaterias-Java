package inscripcionMaterias;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import inscripcionMaterias.Errores.ErrorCarrera;
import inscripcionMaterias.borradores.BorradorCarrera;

import java.util.HashSet;

public class Carrera {
	private String nombre;
	private Set<Materia> materias;
	private Set<Estudiante> alumnos;
	
	public Carrera(BorradorCarrera carrera) throws ErrorCarrera{
		validarCarrera(carrera);
		this.materias = new HashSet<Materia>();
		this.alumnos= new HashSet<Estudiante>();
		this.nombre= carrera.nombre;
	}
	
	private void validarCarrera(BorradorCarrera carrera) throws ErrorCarrera{
		if(StringUtils.isBlank(carrera.nombre)) {throw new ErrorCarrera("El nombre de la carrera esta vacio");}
	}
	
	public String nombre() {return this.nombre;}
	
	
	public void agregarMateria(Materia mat) throws ErrorCarrera{
		if(!this.materias.contains(mat)) {
		 this.materias.add(mat);
		}else {throw new ErrorCarrera("Esta materia ya se encuentra en la carrera");}
	}
	
	public void inscribirAlumno(Estudiante est) throws ErrorCarrera{
		if(!this.alumnos.contains(est)) {
		 this.alumnos.add(est);
		}else {throw new ErrorCarrera("El alumbo ya cursa la carrera");}
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
	
	public Set<Materia> materiasDeAño(Integer año){
		Set<Materia> materias = new HashSet<Materia>();
		for(Materia materia : this.materias) {
			if(materia.año() == año) {
				materias.add(materia);
			}
		}
	return materias;
	}
	
}
