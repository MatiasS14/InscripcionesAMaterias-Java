package inscripcionMaterias;

public class MateriaAprobada {
	private String materia;
	private Integer nota;
	private String alumno;
	private Integer añoMateria;
	
	public MateriaAprobada(String nombreMateria, Integer nota, String nombreAlumno, Integer año) {
		this.materia = nombreMateria;
		this.nota = nota;
		this.alumno = alumno;
		this.añoMateria = año;
	}
	
	public String materia() {
		return this.materia;
	}
	
	public Integer nota() {
		return this.nota;
	}
	
	public String alumno() {
		return this.alumno;
	}
	
	public Integer año() {
		return this.añoMateria;
	}
}
