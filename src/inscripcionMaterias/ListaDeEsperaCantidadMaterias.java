package inscripcionMaterias;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

public class ListaDeEsperaCantidadMaterias extends ListaDeEspera{
	protected PriorityQueue<Estudiante> alumnosEnEspera;
	
	protected Comparator<Estudiante> comparador = new Comparator<Estudiante>() {
		public int compare(Estudiante alu1, Estudiante alu2) {
			if(alu1.materiasAprobadas().size() >= alu2.materiasAprobadas().size()) {
				return -1;
			}else {
				return 1;
			}
			
		}
	};

	public ListaDeEsperaCantidadMaterias() {
		this.alumnosEnEspera = new PriorityQueue<Estudiante>(this.comparador);
	}
	
	@Override
	public void entrarListaEspera(Estudiante alumno) {
		this.alumnosEnEspera.offer(alumno);
	}

	@Override
	public void salirListaDeEspera() {
		this.alumnosEnEspera.poll();		
	}
	
	public Queue<Estudiante> alumnos(){
		return this.alumnosEnEspera;
	}

}