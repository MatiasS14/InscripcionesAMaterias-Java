package testInscripcionMaterias;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import inscripcionMaterias.*;
import inscripcionMaterias.listasDeEspera.ListaDeEspera;
import inscripcionMaterias.listasDeEspera.ListaDeEsperaCantidadMaterias;
import inscripcionMaterias.listasDeEspera.ListaDeEsperaOrdenDeLLegada;
import inscripcionMaterias.listasDeEspera.ListaDeEsperaPorPromedio;
import inscripcionMaterias.prerrequisitosMaterias.Prerrequisito;
import inscripcionMaterias.prerrequisitosMaterias.PrerrequisitoCorrelativas;
import inscripcionMaterias.prerrequisitosMaterias.PrerrequisitoPorAño;
import inscripcionMaterias.prerrequisitosMaterias.PrerrequisitoPorCreditos;
import inscripcionMaterias.prerrequisitosMaterias.SinPrerrequisito;

class TestInscripcionesMaterias {
	//Sistema de inscripciones
	SistemaInscripcion sistema;
	
	//Carrera
	Carrera licInformatica;
	
	//Prerrequisitos
	PrerrequisitoCorrelativas prerrequisitoCorrelativasObjetos3;
	PrerrequisitoCorrelativas prerrequisitoCorrelativasMate2;
	Prerrequisito prerrequisitoCreditos;
	PrerrequisitoPorAño prerrequisitoAño;
	Prerrequisito sinPrerrequisito;
	//correlativas
	Set<String> correlativasObjetos3;
	Set<String> correlativasMate2;
	//Listas de espera
	ListaDeEspera cantidadMaterias;
	ListaDeEspera ordenDeLlegada  ;
	ListaDeEspera porPromedio     ;
	
	//Alumnos
	Estudiante lucas; //intenta entrar a objetos3 pero no tiene objetos2
	Estudiante camila;//intenta entrar a objetos2 pero no tiene cupo
	Estudiante carlos;//debe cursar las primeras materias
	Estudiante agustina;//debe cursar las primeras materias
	
	//Materias
	Materia estructurasDeDatos;//sin prerrequisito- año1- orden de llegada
	Materia estructurasDeDatos2;//sin prerrequisito- año2- orden de llegada
	Materia objetos1;//prerrequisito creditos- año1- orden de llegada
	Materia objetos2;//prerrrequisito por año- año2- cantidad materias
	Materia objetos3;//prerrrequisito correlativas- año3- orden de llegada
	Materia mate1; //sin prerrequisitos- año1- orden de llegada
	Materia mate2; // prerrequisito correlativa- año2- por promedio
	
	
	
	//Materias aprobadas
	  // aprobadas de Lucas :
	  //-estructuras;
	  //-objetos1;
	  //-mate1;
	  //-mate2;
	
	  //aprobadas de Camila
	  //-mate1;
	  //-estructuras;
	  //-objetos1;
	
	  //carlos y agustina no cursaron nada por el momento
	
	//Materias De Carrera
	Set<Materia> materiasCarrera;
	
	@BeforeEach
	void setup() {
		//Sistema
		sistema = new SistemaInscripcion();
		///////////////////////////////////////////////////////////
		//Carrera
		licInformatica = new Carrera();
		///////////////////////////////////////////////////////////
		//Alumnos
		lucas 	 = new Estudiante("Lucas");
		camila	 = new Estudiante("Camila");
		carlos   = new Estudiante("Carlos");
		agustina = new Estudiante("Agustina");
		///////////////////////////////////////////////////////////
		lucas.inscribirseCarrera(licInformatica);
		camila.inscribirseCarrera(licInformatica);
		carlos.inscribirseCarrera(licInformatica);
		agustina.inscribirseCarrera(licInformatica);
		///////////////////////////////////////////////////////////
		//correlativas
		correlativasObjetos3 = new HashSet<String>();
		correlativasObjetos3.add("Objetos1");
		correlativasObjetos3.add("Objetos2");
		correlativasObjetos3.add("Mate2");
		
		correlativasMate2 = new HashSet<String>();
		correlativasMate2.add("Mate1");
		
		///////////////////////////////////////////////////////////
		//Listas de espera
		cantidadMaterias = new ListaDeEsperaCantidadMaterias();
		ordenDeLlegada = new ListaDeEsperaOrdenDeLLegada();
		porPromedio = new ListaDeEsperaPorPromedio();
		///////////////////////////////////////////////////////////
		//Prerrequisitos
		prerrequisitoCorrelativasObjetos3 = new PrerrequisitoCorrelativas(correlativasObjetos3);
		prerrequisitoCorrelativasMate2=  new PrerrequisitoCorrelativas(correlativasMate2);
		prerrequisitoAño = new PrerrequisitoPorAño(1,licInformatica);
		prerrequisitoCreditos = new PrerrequisitoPorCreditos(12);
		sinPrerrequisito = new SinPrerrequisito();
		///////////////////////////////////////////////////////////
		//Materias
		estructurasDeDatos = new Materia(licInformatica, sinPrerrequisito, "EstructuraDeDatos", 1, 1, ordenDeLlegada, 12);
		estructurasDeDatos2 = new Materia(licInformatica, sinPrerrequisito, "EstructuraDeDatos2", 2, 4, ordenDeLlegada, 12);
		objetos1 = new Materia(licInformatica, prerrequisitoCreditos, "Objetos1", 1, 3, ordenDeLlegada, 14);
		objetos2 = new Materia(licInformatica, prerrequisitoAño, "Objetos2", 2, 1, cantidadMaterias, 16);
		objetos3 = new Materia(licInformatica, prerrequisitoCorrelativasObjetos3, "Objetos3", 3, 2, ordenDeLlegada, 16);
		mate1 = new Materia(licInformatica, sinPrerrequisito, "Mate1", 1, 4, ordenDeLlegada, 10);
		mate2 = new Materia(licInformatica, prerrequisitoCorrelativasMate2, "Mate2", 2, 0, porPromedio, 16);
		///////////////////////////////////////////////////////////	
		//Materias Carrera
		materiasCarrera = new HashSet<Materia>();
		materiasCarrera.add(estructurasDeDatos);//1er año
		materiasCarrera.add(estructurasDeDatos2);//1er año
		materiasCarrera.add(objetos1);//1er año
		materiasCarrera.add(objetos2);//2do año
		materiasCarrera.add(objetos3);//3er año
		materiasCarrera.add(mate1);//1er año
		materiasCarrera.add(mate2);//2do año
		///////////////////////////////////////////////////////////
		//agregar materias a carrera
		for(Materia materia : materiasCarrera) {
			licInformatica.agregarMateria(materia);
		}
		///////////////////////////////////////////////////////////
		sistema.agregarCarrera(licInformatica);
		///////////////////////////////////////////////////////////
		//alumnos se inscriben a la carrera
		licInformatica.inscribirAlumno(lucas);
		licInformatica.inscribirAlumno(camila);
		licInformatica.inscribirAlumno(carlos);
		licInformatica.inscribirAlumno(agustina);
		///////////////////////////////////////////////////////////
		//Materias aprobadas
		//Lucas
		lucas.registrarMateriaAprobada(estructurasDeDatos, 7);
		lucas.registrarMateriaAprobada(objetos1, 8);
		lucas.registrarMateriaAprobada(mate1, 6);
		lucas.registrarMateriaAprobada(mate2, 7);
		///////////////////////////////////////////////////////////
		//Camila
		camila.registrarMateriaAprobada(estructurasDeDatos, 8);
		camila.registrarMateriaAprobada(objetos1, 9);
		camila.registrarMateriaAprobada(mate1, 6);
		///////////////////////////////////////////////////////////
	}
	


	@Test
	void lucasLograCusrsarObjetos3Test() {
		System.out.println("#########lucasLograCursarObjetos3Test#########");
		try{
			lucas.ingresarACurso(objetos3);
		}catch(RuntimeException e) {
			System.out.println(e);			
		}//falla la inscripcion de lucas a objetos3
		
		lucas.ingresarACurso(objetos2);//se inscribe en objetos2 para poder cursar obj3
		lucas.registrarMateriaAprobada(objetos2, 8);//aprueba objetos2 
		lucas.ingresarACurso(objetos3); //se inscribe a objetos3 
		assertTrue(lucas.materiasInscripto().contains(objetos3)); //esta inscripto en objetos3
	}

	@Test
	void ingresoAObjetos2Test() {
		System.out.println("#########inscripcionAObjetos2Test#########");
		assertFalse(lucas.yaAprobo(objetos2)); // aqui lucas no aprobo objetos2
		assertFalse(camila.yaAprobo(objetos2)); // aqui camila no aprobo objetos2
		//lucas aprueba estructuras2 y pasa a tener 5 materias
		lucas.registrarMateriaAprobada(estructurasDeDatos2, 7);
		//carlos tiene 4 materias aprobadas
		carlos.registrarMateriaAprobada(estructurasDeDatos, 7);
		carlos.registrarMateriaAprobada(objetos1, 7);
		carlos.registrarMateriaAprobada(mate1, 6);
		carlos.registrarMateriaAprobada(mate2, 5);
		//agustina tiene 3 materias aprobadas
		agustina.registrarMateriaAprobada(estructurasDeDatos, 10);
		agustina.registrarMateriaAprobada(objetos1, 6);
		agustina.registrarMateriaAprobada(mate1, 8);
		
		//camila ingresa y agora el cupo de la materia
		camila.ingresarACurso(objetos2);
		//ingresaran en el siguiente orden a la lista de espera
		//agustina, lucas,carlos
		agustina.ingresarACurso(objetos2);
		lucas.ingresarACurso(objetos2);
		carlos.ingresarACurso(objetos2);
		//se espera que la lista este ordenada por cantidad 
		//de materias de la siguiente manera:
		//lucas(5), carlos(4), agustina(3)
		System.out.println("El alumno con mas priodidad en objetos2 es :"); 
		System.out.println(objetos2.listaDeEspera().poll().nombre()); //muestra el mas prioritario 
																	  //y lo elimina para poder avanzar
		System.out.println("El alumno con mas priodidad en objetos2 es :");
		System.out.println(objetos2.listaDeEspera().poll().nombre());//muestra el mas prioritario 
		  															//y lo elimina para poder avanzar
		System.out.println("El alumno con mas priodidad en objetos2 es :");
		System.out.println(objetos2.listaDeEspera().poll().nombre());//muestra el mas prioritario 
																	//y lo elimina para poder avanzar
	}
	@Test
	void inscripcionAMate2Test() {
		System.out.println("#########inscripcionAMate2Test#########");
		try{
			carlos.ingresarACurso(mate2);//intenta inscribirse pero falla
		}catch(RuntimeException e) {
			System.out.println(e);			
		}
		System.out.println(carlos.materiasAprobadas().size());
												  //luego de fallar por falta de mate1
		carlos.registrarMateriaAprobada(mate1, 7);//agrega mate1 a materias aprobadas
		//otras materias para sumar al promedio de carlos
		carlos.registrarMateriaAprobada(objetos1, 9);//el promedio de carlos queda en 8
		
		//materias y promedio de agustina
		agustina.registrarMateriaAprobada(estructurasDeDatos, 10);
		agustina.registrarMateriaAprobada(objetos1, 9);
		agustina.registrarMateriaAprobada(mate1, 8);//el promedio de agustina queda en 9
		 //el promedio de camila da 7
		//se ingresa a la lista de espera de la siguiente manera:
		//camila, agustina, carlos
		camila.ingresarACurso(mate2);
		agustina.ingresarACurso(mate2);
		carlos.ingresarACurso(mate2);// finalmente ingresa a mate2 (a lista de espera)
		//se esprea que la prioridad por promedio deje los alumnos 
		//en el siguiente orden:
		//agustina(9), carlos(8), camila(7)
		assertEquals(mate2.listaDeEspera().size(), 3);
		assertTrue(agustina.materiasInscripto().contains(mate2));
		assertTrue(carlos.materiasInscripto().contains(mate2));
		assertTrue(camila.materiasInscripto().contains(mate2));

		///////////////////////////////////////////////////
		//se le pide al sistema la lista de alumnos
		//que estan en la lista de espera de mate2, y
		//se corrobora la cantidad de alumnos en la misma
		assertEquals(3, sistema.alumnosEnEspera(mate2).size());
		///////////////////////////////////////////////////		
		System.out.println("El alumno con mas priodidad en mate2 es :"); 
		System.out.println(mate2.listaDeEspera().poll().nombre()); 
		System.out.println("El alumno con mas priodidad en mate2  es :"); 
		System.out.println(mate2.listaDeEspera().poll().nombre()); 
		System.out.println("El alumno con mas priodidad en mate2 es :"); 
		System.out.println(mate2.listaDeEspera().poll().nombre()); 
		
	}
	@Test
	void materiasParaCursarAlumnoTest() {
		
		assertEquals(4, lucas.materiasAprobadas().size());//cantidad de materias aprobadas
		//tiene solo 2 materias disponibles para cursar
		assertEquals(2, licInformatica.materiasParaCursas(lucas).size());
		//las materias para cursar son :
		assertTrue(licInformatica.materiasParaCursas(lucas).contains(objetos2));
		assertTrue(licInformatica.materiasParaCursas(lucas).contains(estructurasDeDatos2));
		//otras materias no estan disponibles para cursar, ya sea por haberlas aprobado
		//o bien porque le falta cumplir requisitos
		assertFalse(licInformatica.materiasParaCursas(lucas).contains(estructurasDeDatos));
		assertFalse(licInformatica.materiasParaCursas(lucas).contains(objetos3));
		
		
	}
	
	@Test
	void alumnosInscriptosMateriaDesdeSistemaTest(){
		//la lista comienza con 0 alumnos
		assertEquals(0, sistema.alumnosInscriptos(estructurasDeDatos2).size());
		carlos.ingresarACurso(estructurasDeDatos2);//carlos se inscribe
		//ahora la lista tiene 1 alumno
		assertEquals(1, sistema.alumnosInscriptos(estructurasDeDatos2).size());
		//se inscriben agustina y camila
		agustina.ingresarACurso(estructurasDeDatos2);
		camila.ingresarACurso(estructurasDeDatos2);
		//ahora la lista tiene 3 alumnos
		assertEquals(3, sistema.alumnosInscriptos(estructurasDeDatos2).size());
	}
	
	@Test
	void agregarCarreraASistema() {
		//creamos carreras(vacias) para corroborar que ingresan al sistema		
		Carrera admHotelera = new Carrera();
		Carrera biotecnologia= new Carrera();
		assertEquals(1, sistema.carreras().size());//como el sistema tiene solo licInformatica
											//solo tiene una carrera
		assertTrue(sistema.carreras().contains(licInformatica));
		assertFalse(sistema.carreras().contains(admHotelera));
		assertFalse(sistema.carreras().contains(biotecnologia));
		
		//se procede a agregar carreras al sistema
		sistema.agregarCarrera(admHotelera);
		sistema.agregarCarrera(biotecnologia);
		//se chequea que la cantidad de carreras sea correcta (3 carreras)
		assertEquals(3, sistema.carreras().size());
		assertTrue(sistema.carreras().contains(licInformatica));
		assertTrue(sistema.carreras().contains(admHotelera));
		assertTrue(sistema.carreras().contains(biotecnologia));		
	}
	@Test
	void sitemaInscripcionTest() {
		// carlos no esta inscripto en ninguna materia
		assertTrue(sistema.materiasAlumnoInscripto(carlos).isEmpty());
		//chequeamos las materias que puede cursar
		assertTrue(sistema.materiasParaCursar(carlos, licInformatica).contains(mate1));
		assertTrue(sistema.materiasParaCursar(carlos, licInformatica).contains(estructurasDeDatos));
		//carlos ingresa a las materias
		carlos.ingresarACurso(mate1);
		carlos.ingresarACurso(estructurasDeDatos);
		assertEquals(2, sistema.materiasAlumnoInscripto(carlos).size());
		assertTrue(sistema.materiasAlumnoInscripto(carlos).contains(mate1));
		assertTrue(sistema.materiasAlumnoInscripto(carlos).contains(estructurasDeDatos));
		assertFalse(sistema.materiasAlumnoInscripto(carlos).contains(objetos1));
		
		/////////////////////////////////////////////////////////////////
		//para la siguiente prueba se crean materias con 1 cupo, 
		//sin requisitos y con lista de espera por orden de llegada
		ListaDeEspera ordenDeLlegadaTI = new ListaDeEsperaOrdenDeLLegada();
		Materia tallerDeTrabajoIntelectual = new Materia(licInformatica, sinPrerrequisito, 
				"trabajoIntelectual", 1, 1, ordenDeLlegadaTI, 10);
		
		ListaDeEspera ordenDeLlegadaIngles1= new ListaDeEsperaOrdenDeLLegada();
		Materia ingles1= new Materia(licInformatica, sinPrerrequisito,"Ingles1", 1, 1, ordenDeLlegadaIngles1, 10);

		ListaDeEspera ordenDeLlegadaSeminario= new ListaDeEsperaOrdenDeLLegada();
		Materia seminarioArduino= new Materia(licInformatica, sinPrerrequisito,"seminarioArduino", 1, 1, ordenDeLlegadaSeminario, 10);
		
		//se agregan las materias a la carrera de licInformatica
		licInformatica.agregarMateria(tallerDeTrabajoIntelectual);
		licInformatica.agregarMateria(ingles1);
		licInformatica.agregarMateria(seminarioArduino);
		//los alumnos ingresan a tallerDeTrabajoIntelectual
		lucas.ingresarACurso(tallerDeTrabajoIntelectual);
		carlos.ingresarACurso(tallerDeTrabajoIntelectual);
		camila.ingresarACurso(tallerDeTrabajoIntelectual);
		agustina.ingresarACurso(tallerDeTrabajoIntelectual);
		//el unico que ingreso directamente es lucas
		assertEquals(1, sistema.alumnosInscriptos(tallerDeTrabajoIntelectual).size());
		assertTrue(sistema.alumnosInscriptos(tallerDeTrabajoIntelectual).contains(lucas));
		assertFalse(sistema.alumnosInscriptos(tallerDeTrabajoIntelectual).contains(carlos));
		assertFalse(sistema.alumnosInscriptos(tallerDeTrabajoIntelectual).contains(camila));
		assertFalse(sistema.alumnosInscriptos(tallerDeTrabajoIntelectual).contains(agustina));
		//la lista de espera debe quedar en el orden en que ingresaron
		//carlos, camila, agustina (lucas no esta porque el ingreso a la materia)
		assertEquals(3, sistema.alumnosEnEspera(tallerDeTrabajoIntelectual).size());
		System.out.println("#########Sistema inscripcion test#########");
		for(Estudiante alu : sistema.alumnosEnEspera(tallerDeTrabajoIntelectual)) {
			System.out.println("El alumno con mas prioridad en Taller es:");
			System.out.println(alu.nombre());
		}
		
		//los alumnos ingresan a seminarioArduino
		carlos.ingresarACurso(seminarioArduino);
		lucas.ingresarACurso(seminarioArduino);
		camila.ingresarACurso(seminarioArduino);
		agustina.ingresarACurso(seminarioArduino);
		//el unico que ingreso directamente es carlos
		assertEquals(1, sistema.alumnosInscriptos(seminarioArduino).size());
		assertTrue(sistema.alumnosInscriptos(seminarioArduino).contains(carlos));
		assertFalse(sistema.alumnosInscriptos(seminarioArduino).contains(lucas));
		assertFalse(sistema.alumnosInscriptos(seminarioArduino).contains(camila));
		assertFalse(sistema.alumnosInscriptos(seminarioArduino).contains(agustina));
		//se da de baja carlos de semirioArduino
		//de este modo el que ingresa a la materia debe ser lucas
		carlos.bajaMateria(seminarioArduino);
		assertEquals(1, sistema.alumnosInscriptos(seminarioArduino).size());
		//ahora lucas es el inscripto ya que entro primero a la lista de espera
		assertTrue(sistema.alumnosInscriptos(seminarioArduino).contains(lucas));
		assertFalse(sistema.alumnosInscriptos(seminarioArduino).contains(carlos));
		
		//los alumnos ingresan a ingles1
		//la que entra directo es camila, 
		//los demas quedan en lista de espera
		camila.ingresarACurso(ingles1);
		carlos.ingresarACurso(ingles1);
		agustina.ingresarACurso(ingles1);
		lucas.ingresarACurso(ingles1);

		//corroboramos las materias en que carlos queda en lista de espera
		assertEquals(2, sistema.materiasAlumnoEnEspera(camila).size());
		assertTrue(sistema.materiasAlumnoEnEspera(camila).contains(tallerDeTrabajoIntelectual));
		assertTrue(sistema.materiasAlumnoEnEspera(camila).contains(seminarioArduino));
		assertFalse(sistema.materiasAlumnoEnEspera(camila).contains(ingles1));

		//ahora comprobamos las materias a las que quedo inscripta camila		
		assertEquals(1, sistema.materiasAlumnoInscripto(camila).size());
		assertFalse(sistema.materiasAlumnoInscripto(camila).contains(tallerDeTrabajoIntelectual));
		assertFalse(sistema.materiasAlumnoInscripto(camila).contains(seminarioArduino));
		assertTrue(sistema.materiasAlumnoInscripto(camila).contains(ingles1));		



		
		
		
		
	}
}
