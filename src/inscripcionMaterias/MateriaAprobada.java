package inscripcionMaterias;
import org.junit.platform.commons.util.StringUtils;
import inscripcionMaterias.Errores.ErrorMateriaAprobada;
import inscripcionMaterias.borradores.BorradorMateriaAprobada;

public class MateriaAprobada {
	private String materia;
	private Integer nota;
	private String alumno;
	private Integer a�oMateria;
	
	public MateriaAprobada(BorradorMateriaAprobada materia) throws ErrorMateriaAprobada{
		verificarMateria(materia);
		this.materia = materia.nombreMateria;
		this.nota = materia.nota;
		this.alumno = materia.nombreAlumno;
		this.a�oMateria = materia.a�o;
	}
	
	private void verificarMateria(BorradorMateriaAprobada materia) throws ErrorMateriaAprobada{
		if(StringUtils.isBlank(materia.nombreMateria)) {throw new ErrorMateriaAprobada("El nombre de la materia esta vacio");}
		if(materia.nota < 4){throw new ErrorMateriaAprobada("La nota es insuficiente para aprobar");}
		if(StringUtils.isBlank(materia.nombreAlumno)) {throw new ErrorMateriaAprobada("El nombre del alumno esta vacio");}
		if(materia.a�o < 1) {throw new ErrorMateriaAprobada("El a�o de la materia es invalido");}
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
