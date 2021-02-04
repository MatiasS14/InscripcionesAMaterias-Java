package inscripcionMaterias;
import java.util.PriorityQueue;

public abstract class ListaDeEspera {
	
	public ListaDeEspera() {}

	public abstract void entrarListaEspera(Estudiante alumno); 
	
	public abstract void salirListaDeEspera();
	
	public abstract PriorityQueue<Estudiante> alumnos();
}
