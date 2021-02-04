package inscripcionMaterias;
import java.util.Set;
import java.util.HashSet;

public class Estudiante {
	private Set<Carrera> carreras;//carreras que cursa
	private Set<Materia> materias;//materias que cursa
	private String nombre; // nombre del alumno
	private Set<MateriaAprobada> materiasAprobadas;
	private Integer creditosObtenidos; //creditos obtenidos hasta el momento
	
	public Estudiante(String nombre) {
		this.carreras = new HashSet<Carrera>();
		this.materias = new HashSet<Materia>();
		this.materiasAprobadas = new HashSet<MateriaAprobada>();
		this.nombre = nombre;
		this.creditosObtenidos = 0;
	}
	
	public void inscribirseCarrera(Carrera carrera) {
		this.carreras.add(carrera);
	}
	
	public Set<MateriaAprobada> materiasAprobadas(){
		return this.materiasAprobadas;
	}
	
	public Boolean puedeCursar(Materia materia) {
		return materia.cumplePrerrequisitos(this);
	}
	
	public void registrarMateriaAprobada(Materia matAprobada, Integer nota) {
		this.creditosObtenidos+= matAprobada.creditosOtorga();
		this.materiasAprobadas.add(new MateriaAprobada(matAprobada.nombreMateria(),nota,
				                    this.nombre(), matAprobada.año()));
		matAprobada.bajaAlumno(this);//como ya esta aprobado, 
									//se lo elimina de la lista de la materia
	}
	
	public void ingresarACurso(Materia materia) {
		if(esMateriaDeCarrera(this, materia) && this.puedeCursar(materia) && !this.yaAprobo(materia)) {
			materia.altaAlumno(this);
			this.materias.add(materia);
		}else {
			if(this.yaAprobo(materia)) {
				throw new RuntimeException("Esta materia ya fue aprobada");
			}
			if(!this.puedeCursar(materia)) {
				throw new RuntimeException("No cumple prerrequisitos");
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
	
	public void bajaMateria(Materia materia) {
		this.materias.remove(materia);
		materia.bajaAlumno(this);
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
