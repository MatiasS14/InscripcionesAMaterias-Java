package inscripcionMaterias.borradores;

public class BorradorMateriaAprobada {
	public String nombreMateria;
	public Integer nota;
	public String nombreAlumno;
	public Integer año;
	
	public BorradorMateriaAprobada(String nombreMateria, Integer nota,
									String nombreAlumno, Integer año) {
		this.nombreMateria = nombreMateria;
		this.nota = nota;
		this.nombreAlumno = nombreAlumno;
		this.año = año;
	}
}
