package inscripcionMaterias;
import java.util.Comparator;

import java.util.PriorityQueue;
import java.util.Queue;

	
public class ListaDeEsperaPorPromedio extends ListaDeEspera{
	private Queue<Estudiante> alumnosEnEspera;
	
	protected Comparator<Estudiante> comparador = new Comparator<Estudiante>() {
		public int compare(Estudiante alu1, Estudiante alu2) {
			if(alu1.promedio() >= alu2.promedio()) {
				return -1;
			}else {
				return 1;
			}		
		}
	};
	
	public ListaDeEsperaPorPromedio() {
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
