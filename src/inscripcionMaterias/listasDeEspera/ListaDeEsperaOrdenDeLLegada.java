package inscripcionMaterias.listasDeEspera;
//import java.util.PriorityQueue;
import java.util.Queue;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Errores.ErrorListaEspera;

import java.util.LinkedList;

public class ListaDeEsperaOrdenDeLLegada extends ListaDeEspera{
	private Queue<Estudiante> alumnosEnEspera;
	public ListaDeEsperaOrdenDeLLegada() {
		this.alumnosEnEspera = new LinkedList<Estudiante>();
	}
	
	@Override
	public void entrarListaEspera(Estudiante alumno) throws ErrorListaEspera{
		if(this.alumnosEnEspera.contains(alumno)) {
			throw new ErrorListaEspera("El alumno ya esta en lista de espera");
		}else {	
			this.alumnosEnEspera.add(alumno);}
	}

	@Override
	public void salirListaDeEspera() throws ErrorListaEspera{
		if(this.alumnosEnEspera.size() > 0) {
			this.alumnosEnEspera.poll();
		}else {throw new ErrorListaEspera("La lista de espera esta vacia");}
		
	}
	
	public Queue<Estudiante> alumnos() {
		return this.alumnosEnEspera;
	}

}
