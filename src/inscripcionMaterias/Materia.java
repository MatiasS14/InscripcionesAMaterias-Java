package inscripcionMaterias;
import java.util.Set;
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
	
	public Materia(Carrera carrera, Prerrequisito prerrequisitos, String nombre,
			Integer año, Integer cupo, ListaDeEspera listaDeEspera, Integer creditos) {
		this.carrera = carrera;
		this.prerrequisito = prerrequisitos;
		this.nombre = nombre;
		this.año = año;
		this.cupo = cupo;
		this.listaDeEspera = listaDeEspera;
		this.alumnosInscriptos = new HashSet<Estudiante>();
		this.creditos = creditos;
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
	
	public Integer cupo() {
		return this.cupo;
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
