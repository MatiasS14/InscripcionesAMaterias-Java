package inscripcionMaterias.listasDeEspera;
import java.util.Queue;

import inscripcionMaterias.Estudiante;

public abstract class ListaDeEspera {
	
	public ListaDeEspera() {}

	public abstract void entrarListaEspera(Estudiante alumno); 
	
	public abstract void salirListaDeEspera();
	
	public abstract Queue<Estudiante> alumnos();
}
