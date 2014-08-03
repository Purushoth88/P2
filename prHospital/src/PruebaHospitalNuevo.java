
public class PruebaHospitalNuevo {
	public static void main(String [] args) throws InterruptedException {
		Medico med1 = new Medico("22626262", "Juan", "Garcia Lopez", 34, Genero.HOMBRE,
				Categoria.ADJUNTO, true, 12);
		Medico med2 = new Medico("73737373", "Pedro", "Marin Perez", 33, Genero.HOMBRE,
				Categoria.INTERINO, true, 12);
		Medico med3 = new Medico("99487474", "Maria", "Velez Lopez", 39, Genero.MUJER,
				Categoria.ADJUNTO, true, 12);
		Medico med4 = new Medico("25252525", "Luisa", "Morilla Antera", 50, Genero.MUJER,
				Categoria.RESIDENTE, false, 12);
		Medico med5 = new Medico("88477444", "Ramon", "Gullon Mande", 46, Genero.HOMBRE,
				Categoria.RESIDENTE, false, 12);
		Medico med6 = new Medico("53536733", "Andres", "Robles Marea", 47, Genero.HOMBRE,
				Categoria.RESIDENTE, true, 12);
		Medico med7 = new Medico("77464564", "Ana", "Peralta Monte", 45, Genero.MUJER,
				Categoria.ADJUNTO, false, 12);
		Medico med8 = new Medico("61261523", "Ramon", "Linde Masa", 34, Genero.HOMBRE,
				Categoria.INTERINO, true, 12);
		Medico med9 = new Medico("99474643", "Joaquin", "Perez Valdes", 59, Genero.HOMBRE,
				Categoria.RESIDENTE, false, 12);

		Departamento dep1 = new Departamento("Oncologia", new Medico[] {med1, med2, med3});
		Departamento dep2 = new Departamento("Radioterapia", new Medico[] {med4, med5});
		Departamento dep3 = new Departamento("Pediatria", new Medico[] {med6, med7, med8, med9});

		Hospital hospital = new Hospital("La Gloria", "Camino del Cielo s/n", new Departamento[] {dep1, dep2, dep3}, 5);

		System.out.println(hospital.getPlanta(0));


		Paciente pac1 = new Paciente("65353535" , "Pedro", "Mal Tratado", 25, Genero.HOMBRE,
				1.80, 76, "1231532514345132513", false, hospital.getPlanta(0).camaLibre());
		Paciente pac2 = new Paciente("88376363" , "Juan", "Mas Malito", 57, Genero.HOMBRE,
				1.83, 86, "38746387467834738467", true, hospital.getPlanta(1).getHabitacion(2).camaLibre());
		Paciente pac3 = new Paciente("44262623" , "Lourdes", "Lisa Manera", 29, Genero.MUJER,
				1.60, 68, "88373636365333345434", false, hospital.getPlanta(0).camaLibre());
		Paciente pac4 = new Paciente("77262562" , "Angela", "Aquime Quedo", 76, Genero.MUJER,
				1.63, 82, "23847283482364723823", false, hospital.getPlanta(3).getHabitacion(4).camaLibre());
		Paciente pac5 = new Paciente("65624524" , "Juan", "Tengo Algo", 20, Genero.HOMBRE,
				1.90, 58, "28937872367283645528", true, hospital.getPlanta(1).camaLibre());
		Paciente pac6 = new Paciente("11525252" , "Jonh", "Vengod Elejos", 82, Genero.HOMBRE,
				1.64, 73, "34374638746834687865", false, hospital.getPlanta(3).camaLibre());
		pac1.asignaMedico(med1);
		pac2.asignaMedico(med2);
		pac3.asignaMedico(med5);
		pac4.asignaMedico(med8);
		pac5.asignaMedico(med8);
		pac6.asignaMedico(med2);

		// A partir de aqu’ pode’s probar vuestros metodos
		System.out.println(hospital+"\n");
		System.out.println(pac1+"\n");
		System.out.println("\nMedicos na planta:");
		muestraMedicosEnPlanta(hospital, 3);
		
		muestraPacientesEnPlanta(hospital, 0);
		//muestraMedicosAsignados(hospital); (Depois que corrigir o método, tirar esse comentário)
		System.out.println("\nCamas Vacias en Hospital:");
		muestraCamasVaciasHospital(hospital);
		System.out.println("\nHabitaciones vacias en el hospital:");
		muestraHabitacionesVacias(hospital);
		System.out.println("\nHabitaciones com camas libres:");
		muestraHabitacionesConCamaLibre(hospital);
		System.out.println("¿Cuántos pacientes se están tratando en la planta " + hospital.getPlanta(3).getCodigo() + "?");
		System.out.println(numPacientesEnPlanta(hospital, hospital.getPlanta(3)));
		System.out.println("¿Cuántas camas hay libres en la planta " + hospital.getPlanta(3).getCodigo() + "?");
		System.out.println(numCamasLibreEnPlanta(hospital, hospital.getPlanta(3)));
		System.out.println("¿Están todas las habitaciones del hospital ocupadas por al menos un paciente?");
		System.out.println(todasLasHabitacionesEstanOcupadas(hospital));
		System.out.println("¿Tiene un médico dado asignado algún paciente en la planta " + hospital.getPlanta(0).getCodigo() + "?");
		System.out.println(medicoAsignadoEnPlanta(med1, hospital.getPlanta(0)));
		System.out.println("\nMostra departamientos en planta");
		muestraDepartamentosEnPlanta(new Departamento[] {dep1, dep2, dep3}, hospital.getPlanta(0)); 
	}

	/**
	 * Muestra los medicos que tratan pacientes en la planta dada del hospital
	 * @param hop		EL hospital
	 * @param numPlanta	El numero de la planta
	 */
	public static void muestraMedicosEnPlanta(Hospital hop, int numPlanta) {
		Planta planta = hop.getPlanta(numPlanta);
		for (int i = 0; i < planta.numHabitaciones(); i++ ) {
			Habitacion habitacion = planta.getHabitacion(i);
			for(int j = 0; j < habitacion.numCamas(); j++) {
				Cama cama = habitacion.getCama(j);
				if (!cama.estaLibre()) {
					Paciente paciente = cama.getPaciente();
					Medico medico = paciente.atendidoPor();
					if (medico != null) {
						System.out.println(medico);
					}
				}
			}
		}
	}

	//Mostrar todos los pacientes que están tratados en una planta dada.
	public static void muestraPacientesEnPlanta(Hospital hop, int numPlanta){
		Planta planta = hop.getPlanta(numPlanta);
		System.out.println("Paciente en Planta " + planta.getCodigo() );
		for(int i=0; i < planta.numHabitaciones(); i++){
			Habitacion habitacion = planta.getHabitacion(i);
			for(int j = 0; j < habitacion.numCamas(); j++) {
				Cama cama = habitacion.getCama(j);
				if (!cama.estaLibre()) {
					System.out.println(cama.getPaciente());
				}
			}
		}
	}

	//Mostrar los médicos que tienen asignado paciente. (Falta esse)
	public static void muestraMedicosAsignados(Hospital hop){
		System.out.println("Medicos que tienen asignado paciente.");
		for(int i=0; i<hop.numPlantas(); i++){
			for(int j=0; j<hop.getPlanta(i).numHabitaciones(); j++){
				for(int y=0; y<hop.getPlanta(i).getHabitacion(j).numCamas(); y++){
					if(!hop.getPlanta(i).getHabitacion(j).getCama(y).estaLibre()){
						Medico medico = hop.getPlanta(i).getHabitacion(j).getCama(y).getPaciente().atendidoPor();
						if(medico!=null){
							System.out.println(medico);
						}
					}
				}
			}
		}
	}

	//Mostrar todas las camas vacías del hospital.
	public static void muestraCamasVaciasHospital(Hospital hop){
		System.out.println("Mostrar todas las camas vacías del hospital.");
		for(int i=0; i<hop.numPlantas(); i++){
			for(int j=0; j<hop.getPlanta(i).numHabitaciones(); j++){
				for(int y=0; y<hop.getPlanta(i).getHabitacion(j).numCamas(); y++){
					if(hop.getPlanta(i).getHabitacion(j).getCama(y).estaLibre()){
						System.out.println(hop.getPlanta(i).getHabitacion(j).getCama(y));
					}
				}
			}
		}
	}

	//Mostrar todas las habitaciones vacías del hospital
	public static void muestraHabitacionesVacias(Hospital hop){
		System.out.println("Mostrar todas las habitaciones vacías del hospital.");
		for(int i=0; i<hop.numPlantas(); i++){
			for(int j=0; j<hop.getPlanta(i).numHabitaciones(); j++){
				int numCamas = 0;
				for(int y=0; y<hop.getPlanta(i).getHabitacion(j).numCamas(); y++){
					if(hop.getPlanta(i).getHabitacion(j).getCama(y).estaLibre()){
						numCamas++;
					}
				}
				if(numCamas==hop.getPlanta(i).getHabitacion(j).numCamas()){
					System.out.println(hop.getPlanta(i).getHabitacion(j));
				}
			}
		}
	}

	//Mostrar todas las habitaciones en las que hay alguna cama libre.
	public static void muestraHabitacionesConCamaLibre(Hospital hop){
		System.out.println("Mostrar todas las habitaciones que hay alguna cama libre");
		for(int i=0; i<hop.numPlantas(); i++){
			for(int j=0; j<hop.getPlanta(i).numHabitaciones(); j++){
				int numCamas = 0;
				for(int y=0; y<hop.getPlanta(i).getHabitacion(j).numCamas(); y++){
					if(hop.getPlanta(i).getHabitacion(j).getCama(y).estaLibre()){
						numCamas++;
						break;
					}
				}
				if(numCamas>0){
					System.out.println(hop.getPlanta(i).getHabitacion(j));
				}
			}
		}
	}

	//¿Cuántos pacientes se están tratando en una planta dada?
	public static int numPacientesEnPlanta(Hospital hop, Planta planta){
		int numPacientes = 0;
		for(int j=0; j<planta.numHabitaciones(); j++){
			for(int y=0; y<planta.getHabitacion(j).numCamas(); y++){
				if(!planta.getHabitacion(j).getCama(y).estaLibre()){
					numPacientes++;
				}
			}
		}
		return numPacientes;
	}

	//¿Cuántas camas hay libres en una planta dada?
	public static int numCamasLibreEnPlanta(Hospital hop, Planta planta){
		int numCamas = 0;
		for(int j=0; j<planta.numHabitaciones(); j++){
			for(int y=0; y<planta.getHabitacion(j).numCamas(); y++){
				if(planta.getHabitacion(j).getCama(y).estaLibre()){
					numCamas++;
				}
			}
		}
		return numCamas;
	}

	//¿Están todas las habitaciones del hospital ocupadas por al menos un paciente?
	public static boolean todasLasHabitacionesEstanOcupadas(Hospital hop){
		int totalOcupadas = 0;
		int totalHabitaciones = 0;
		for(int i=0; i<hop.numPlantas(); i++){
			for(int j=0; j<hop.getPlanta(i).numHabitaciones(); j++){
				totalHabitaciones++;
				for(int y=0; y<hop.getPlanta(i).getHabitacion(j).numCamas(); y++){
					if(!hop.getPlanta(i).getHabitacion(j).getCama(y).estaLibre()){
						totalOcupadas++;
						break;
					}
				}
			}
		}
		if(totalOcupadas==totalHabitaciones){
			return true;
		}
		return false;
	}
	
	//¿Tiene un médico dado asignado algún paciente en una planta dada?
	public static boolean medicoAsignadoEnPlanta(Medico medico, Planta planta){
		for(int i=0; i<planta.numHabitaciones(); i++){
			for(int j=0; j<planta.getHabitacion(i).numCamas(); j++){
				if(!planta.getHabitacion(i).getCama(j).estaLibre()){
					if(planta.getHabitacion(i).getCama(j).getPaciente().atendidoPor()!=null){
						if(planta.getHabitacion(i).getCama(j).getPaciente().atendidoPor().getApellidos().equals(medico.getApellidos())){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	//Mostrar todos los departamentos cuyos médicos tienen pacientes en una planta dada.
	public static void muestraDepartamentosEnPlanta(Departamento[] departamentos, Planta planta){
		for(int i=0; i<planta.numHabitaciones(); i++){
			for(int j=0; j<planta.getHabitacion(i).numCamas(); j++){
				if(!planta.getHabitacion(i).getCama(j).estaLibre()){
					if(planta.getHabitacion(i).getCama(j).getPaciente().atendidoPor()!=null){
						muestraDepartamento(departamentos, planta.getHabitacion(i).getCama(j).getPaciente().atendidoPor());
					}
				}
			}
		}
	}

	private static void muestraDepartamento(Departamento[] departamentos, Medico medico) {
		for(int i=0; i<departamentos.length; i++){
			if(departamentos[i].trabajaEnDepartamento(medico)){
				System.out.println(departamentos[i]);
			}
		}
	}
	
}
