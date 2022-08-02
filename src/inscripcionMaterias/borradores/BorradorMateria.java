package inscripcionMaterias.borradores;

import inscripcionMaterias.Carrera;
import inscripcionMaterias.listasDeEspera.ListaDeEspera;
import inscripcionMaterias.prerrequisitosMaterias.Prerrequisito;

public class BorradorMateria {
	public Carrera carrera;
	public Prerrequisito prerrequisitos;
	public String nombre;
	public Integer a�o;
	public Integer cupo;
	public ListaDeEspera listaDeEspera;
	public Integer creditos;

	public BorradorMateria(Carrera carrera, Prerrequisito prerrequisitos, String nombre,
			Integer a�o, Integer cupo, ListaDeEspera listaDeEspera, Integer creditos) {
		this.carrera = carrera;
		this.prerrequisitos = prerrequisitos;
		this.nombre = nombre;
		this.a�o = a�o;
		this.cupo = cupo;
		this.listaDeEspera = listaDeEspera;
		this.creditos = creditos;
	}
}
