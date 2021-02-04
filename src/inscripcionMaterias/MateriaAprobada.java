package inscripcionMaterias;

public class MateriaAprobada {
	private String materia;
	private Integer nota;
	private String alumno;
	private Integer a�oMateria;
	
	public MateriaAprobada(String nombreMateria, Integer nota, String nombreAlumno, Integer a�o) {
		this.materia = nombreMateria;
		this.nota = nota;
		this.alumno = nombreAlumno;
		this.a�oMateria = a�o;
	}
	
	public String materia() {
		return this.materia;
	}
	
	public Integer nota() {
		return this.nota;
	}
	
	public Integer a�o() {
		return this.a�oMateria;
	}
}
