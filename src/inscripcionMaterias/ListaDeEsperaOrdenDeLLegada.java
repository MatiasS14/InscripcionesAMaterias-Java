package inscripcionMaterias;
import java.util.PriorityQueue;

public class ListaDeEsperaOrdenDeLLegada extends ListaDeEspera{
	private PriorityQueue<Estudiante> alumnosEnEspera;
	public ListaDeEsperaOrdenDeLLegada() {
		this.alumnosEnEspera = new PriorityQueue<Estudiante>();
	}
	
	@Override
	public void entrarListaEspera(Estudiante alumno) {
		this.alumnosEnEspera.add(alumno);
	}

	@Override
	public void salirListaDeEspera() {
		this.alumnosEnEspera.poll();
		
	}
	
	public PriorityQueue<Estudiante> alumnos() {
		return this.alumnosEnEspera;
	}

}
