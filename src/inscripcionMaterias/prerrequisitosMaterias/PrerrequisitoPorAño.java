package inscripcionMaterias.prerrequisitosMaterias;

import org.junit.platform.commons.util.StringUtils;

import inscripcionMaterias.Carrera;
import inscripcionMaterias.Estudiante;
import inscripcionMaterias.Materia;
import inscripcionMaterias.Errores.ErrorPrerrequisito;

public class PrerrequisitoPorAño extends Prerrequisito{
	private Integer año;
	private Carrera carrera;
	
	public PrerrequisitoPorAño(Integer año, Carrera carrera) throws ErrorPrerrequisito{
		verificarPrerrequisito(año, carrera);
		this.año = año;
		this.carrera = carrera;
	}
	
	private void verificarPrerrequisito(Integer año, Carrera carrera) throws ErrorPrerrequisito{
		if(año < 1) {throw new ErrorPrerrequisito("El año debe ser mayor o igual a 1");}
		if(StringUtils.isBlank(carrera.nombre())) {throw new ErrorPrerrequisito("El nombre de la carrera esta vacio");}
	}
	@Override
	public Boolean alumnoCumplePrerrequisito(Estudiante alumno, Materia materia) {
		return 	alumno.materiasDeAño(this.año).size() == this.carrera.materiasDeAño(this.año).size();//this.materiasAño.size();
	}
	
}
