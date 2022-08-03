package inscripcionMaterias.listasDeEspera;
import java.util.Queue;

import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Errores.ErrorListaEspera;

public abstract class ListaDeEspera {
	
	public ListaDeEspera() {}

	public abstract void entrarListaEspera(Estudiante alumno) throws ErrorListaEspera; 
	
	public abstract void salirListaDeEspera() throws ErrorListaEspera;
	
	public abstract Queue<Estudiante> alumnos();
}
