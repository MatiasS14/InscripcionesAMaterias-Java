package inscripcionMaterias.prerrequisitosMaterias;

import org.junit.platform.commons.util.StringUtils;

import inscripcionMaterias.Carrera;
import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;
import inscripcionMaterias.Errores.ErrorPrerrequisito;

public class PrerrequisitoPorA�o extends Prerrequisito{
	private Integer a�o;
	private Carrera carrera;
	
	public PrerrequisitoPorA�o(Integer a�o, Carrera carrera) throws ErrorPrerrequisito{
		verificarPrerrequisito(a�o, carrera);
		this.a�o = a�o;
		this.carrera = carrera;
	}
	
	private void verificarPrerrequisito(Integer a�o, Carrera carrera) throws ErrorPrerrequisito{
		if(a�o < 1) {throw new ErrorPrerrequisito("El a�o debe ser mayor o igual a 1");}
		if(StringUtils.isBlank(carrera.nombre())) {throw new ErrorPrerrequisito("El nombre de la carrera esta vacio");}
	}
	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return 	alumno.materiasDeA�o(this.a�o).size() == this.carrera.materiasDeA�o(this.a�o).size();//this.materiasA�o.size();
	}
	
}
