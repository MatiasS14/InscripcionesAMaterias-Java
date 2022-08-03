package inscripcionMaterias.listasDeEspera;
import java.util.Comparator;

import java.util.PriorityQueue;
import java.util.Queue;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Errores.ErrorListaEspera;

	
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
	public void entrarListaEspera(Estudiante alumno) throws ErrorListaEspera{
		if(this.alumnosEnEspera.contains(alumno)) {
			throw new ErrorListaEspera("El alumno ya esta en lista de espera");
		}else {
		 this.alumnosEnEspera.offer(alumno);}
	}

	@Override
	public void salirListaDeEspera() throws ErrorListaEspera{
		if(this.alumnosEnEspera.size() > 0) {
			this.alumnosEnEspera.poll();
		}else {throw new ErrorListaEspera("La lista de espera esta vacia");}
	}
	
	public Queue<Estudiante> alumnos(){
		return this.alumnosEnEspera;
	}

}
