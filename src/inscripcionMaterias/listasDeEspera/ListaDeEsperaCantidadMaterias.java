package inscripcionMaterias.listasDeEspera;
import java.util.Comparator;
import java.util.Queue;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Errores.ErrorListaEspera;

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