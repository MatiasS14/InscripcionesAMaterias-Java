package inscripcionMaterias.borradores;

import inscripcionMaterias.Carrera;
import inscripcionMaterias.listasDeEspera.ListaDeEspera;
import inscripcionMaterias.prerrequisitosMaterias.Prerrequisito;

public class BorradorMateria {
	public Carrera carrera;
	public Prerrequisito prerrequisitos;
	public String nombre;
	public Integer año;
	public Integer cupo;
	public ListaDeEspera listaDeEspera;
	public Integer creditos;

	public BorradorMateria(Carrera carrera, Prerrequisito prerrequisitos, String nombre,
			Integer año, Integer cupo, ListaDeEspera listaDeEspera, Integer creditos) {
		this.carrera = carrera;
		this.prerrequisitos = prerrequisitos;
		this.nombre = nombre;
		this.año = año;
		this.cupo = cupo;
		this.listaDeEspera = listaDeEspera;
		this.creditos = creditos;
	}
}
