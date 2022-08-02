package inscripcionMaterias;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import inscripcionMaterias.Errores.ErrorMateria;
import inscripcionMaterias.borradores.BorradorMateria;
import inscripcionMaterias.listasDeEspera.ListaDeEspera;
import inscripcionMaterias.prerrequisitosMaterias.Prerrequisito;

import java.util.HashSet;
import java.util.Queue;

public class Materia {
	private Carrera carrera;
	private Prerrequisito prerrequisito;
	private String nombre;
	private Integer año;
	private Integer cupo;
	private ListaDeEspera listaDeEspera;
	private Set<Estudiante> alumnosInscriptos;
	private Integer creditos;
	
	public Materia(BorradorMateria materia) throws ErrorMateria{
		validarMateria(materia);
		this.carrera = materia.carrera;
		this.prerrequisito = materia.prerrequisitos;
		this.nombre = materia.nombre;
		this.año = materia.año;
		this.cupo = materia.cupo;
		this.listaDeEspera = materia.listaDeEspera;
		this.alumnosInscriptos = new HashSet<Estudiante>();
		this.creditos = materia.creditos;
	}
	
	private void validarMateria(BorradorMateria materia) throws ErrorMateria{
		if(StringUtils.isBlank(materia.carrera.nombre()) ) {throw new ErrorMateria("La carrera no es valida");}
		if(materia.prerrequisitos == null) {throw new ErrorMateria("Los prerrequisitos no son validos");}
		if(StringUtils.isBlank(materia.nombre)) {throw new ErrorMateria("El nombre de la materia no puede ser vacio");};
		if(materia.año < 1) {throw new ErrorMateria("El año de la materia no es valido");}
		if(materia.cupo < 0) {throw new ErrorMateria("El cupo de la materia no es valido");}
		if(materia.listaDeEspera == null) {throw new ErrorMateria("La lista de espera no es valida");}
		if(materia.creditos < 1) {throw new ErrorMateria("Los creditos de la materia no son validos");}
	}
	
	public Boolean cumplePrerrequisitos(Estudiante alumno) {
		return this.prerrequisito.alumnoCumplePrerrequisito(alumno, this);
	}
	
	public Integer año() {
		return this.año;
	}
	
	public String nombreMateria() {
		return this.nombre;
	}
	
	public Queue<Estudiante> listaDeEspera(){
		return this.listaDeEspera.alumnos();
	}
	
	public void altaAlumno(Estudiante alumno) {
		if(this.cupo > this.alumnosInscriptos.size()) {
			this.alumnosInscriptos.add(alumno);
		}else {
			this.listaDeEspera.entrarListaEspera(alumno);
		}
	}
	
	public void bajaAlumno(Estudiante alumno) {
		this.alumnosInscriptos.remove(alumno);
		if(!this.listaDeEspera().isEmpty()) {
			//agrega al alumno con mayor prioridad de la lista de espera 
			//a la lista de alumnos inscriptos de la materia
			this.alumnosInscriptos.add(this.listaDeEspera.alumnos().peek());
			//elimina el alumno ya agregado a la lista de inscriptos
			//de la lista de espera de la materia
			this.listaDeEspera.salirListaDeEspera();
		}
	}
	
	public Set<Estudiante> alumnosInscriptos(){
		return this.alumnosInscriptos;
	}
	
	public Integer creditosOtorga() {
		return this.creditos;
	}
	
	public Carrera carrera() {
		return this.carrera;
	}
}
