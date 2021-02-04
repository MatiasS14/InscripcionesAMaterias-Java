package inscripcionMaterias;
//import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class ListaDeEsperaOrdenDeLLegada extends ListaDeEspera{
	private Queue<Estudiante> alumnosEnEspera;
	public ListaDeEsperaOrdenDeLLegada() {
		this.alumnosEnEspera = new LinkedList<Estudiante>();
	}
	
	@Override
	public void entrarListaEspera(Estudiante alumno) {
		this.alumnosEnEspera.add(alumno);
	}

	@Override
	public void salirListaDeEspera() {
		this.alumnosEnEspera.poll();
		
	}
	
	public Queue<Estudiante> alumnos() {
		return this.alumnosEnEspera;
	}

}
