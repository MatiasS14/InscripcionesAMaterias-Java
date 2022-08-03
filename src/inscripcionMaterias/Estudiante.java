package inscripcionMaterias;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import inscripcionMaterias.Errores.ErrorEstudiante;
import inscripcionMaterias.Errores.ErrorListaEspera;
import inscripcionMaterias.Errores.ErrorMateriaAprobada;
import inscripcionMaterias.borradores.BorradorEstudiante;
import inscripcionMaterias.borradores.BorradorMateriaAprobada;

import java.util.HashSet;

public class Estudiante {
	private Set<Carrera> carreras;//carreras que cursa
	private Set<Materia> materias;//materias que cursa
	private String nombre; // nombre del alumno
	private Set<MateriaAprobada> materiasAprobadas;
	private Integer creditosObtenidos; //creditos obtenidos hasta el momento
	
	public Estudiante(BorradorEstudiante estudiante) throws ErrorEstudiante{
		validarEstudiante(estudiante);
		this.carreras = new HashSet<Carrera>();
		this.materias = new HashSet<Materia>();
		this.materiasAprobadas = new HashSet<MateriaAprobada>();
		this.nombre = estudiante.nombre;
		this.creditosObtenidos = 0;
	}
	
	private void validarEstudiante(BorradorEstudiante estudiante) throws ErrorEstudiante{
		if(StringUtils.isBlank(estudiante.nombre)) {throw new ErrorEstudiante("El nombre del estudiante no es valido");}
	}
	
	public void inscribirseCarrera(Carrera carrera) throws ErrorEstudiante{
		if(! this.carreras.contains(carrera)) {
		this.carreras.add(carrera);
		}else {throw new ErrorEstudiante("El alumno ya esta inscripto en la carrera");}
	}
	
	public Set<MateriaAprobada> materiasAprobadas(){
		return this.materiasAprobadas;
	}
	
	public Boolean puedeCursar(Materia materia) {
		return materia.cumplePrerrequisitos(this);
	}
	
	public void registrarMateriaAprobada(Materia matAprobada, Integer nota) throws ErrorMateriaAprobada, ErrorListaEspera{
		this.creditosObtenidos+= matAprobada.creditosOtorga();
		
		 BorradorMateriaAprobada materia = new BorradorMateriaAprobada(matAprobada.nombreMateria(),nota,
                this.nombre(), matAprobada.año());
		
		this.materiasAprobadas.add(new MateriaAprobada(materia));
		matAprobada.bajaAlumno(this);//como ya esta aprobado, 
									//se lo elimina de la lista de la materia
	}
	
	public void ingresarACurso(Materia materia) throws ErrorEstudiante, ErrorListaEspera{
		if(esMateriaDeCarrera(this, materia) && this.puedeCursar(materia) && !this.yaAprobo(materia)) {
			materia.altaAlumno(this);
			this.materias.add(materia);
		}else {
			if(this.yaAprobo(materia)) {
				throw new ErrorEstudiante("Esta materia ya fue aprobada");
			}
			if(!this.puedeCursar(materia)) {
				throw new ErrorEstudiante("No cumple prerrequisitos");
			}
		}
	}
	
	private Boolean esMateriaDeCarrera(Estudiante alu, Materia materia) {
		return alu.carreras.contains(materia.carrera());
	}
	
	public Boolean yaAprobo(Materia materia) {
		Boolean ret = false;
		for(MateriaAprobada matAp : this.materiasAprobadas) {
			ret = ret || materia.nombreMateria() == matAp.materia();
		}
		return ret;
	}
	
	public void bajaMateria(Materia materia) throws ErrorEstudiante, ErrorListaEspera{
		if(this.materias.contains(materia)) {
		this.materias.remove(materia);
		materia.bajaAlumno(this);
		}else { throw new ErrorEstudiante("El alumno no cursa esta materia");}
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public Integer creditosObtenidos() {
		return this.creditosObtenidos;
	}
	
	public Set<String> materiasDeAño(Integer año){
		Set<String> ret = new HashSet<String>();
		for(MateriaAprobada mat : this.materiasAprobadas) {
			if(mat.año() == año) {
				ret.add(mat.materia());
			}
		}
	  return ret;
	}
	public Set<Materia> materiasInscripto(){
		//retorna las materias a las que se inscribio, aun asi haya quedado en espera
		return this.materias;
	}
	
	public Integer promedio() {
		Integer ret = 0;
		for(MateriaAprobada mat : this.materiasAprobadas) {
			ret+= mat.nota();
		}
		return ret / this.materiasAprobadas.size();
	}
}
