package agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilerias.Fecha;

public class AppAgenda {

	private static Scanner leer = new Scanner(System.in);
	private static ArrayList<Contacto> agenda;

	public static void main(String[] args) {

		agenda = new ArrayList<>();
		try {
			if(!Contacto.CargaRegistro().isEmpty()) {
				agenda.addAll(Contacto.CargaRegistro());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int op;
		do {
			DespliegaMenu();
			op = MissmatchExceptionInt();
			switch (op) {
			case 1:
				Opcion1();
				break;
			case 2:
				Opcion2();
				break;
			case 3:
				Opcion3();
				break;
			case 4:
				Opcion4();
				break;
			case 5:
				Opcion5();
				break;
			case 0:
				try {
					Contacto.GrabaRegistro(agenda);
				} catch (IOException e) {
					System.out.println(e.getMessage());;
				}
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (op != 0);
		System.out.println("Programa finalizado");
		leer.close();
	}

	private static void Opcion5() {
		System.out.println(" Listado completo de contactos");
		for (Contacto contacto : agenda) {
			if (contacto.getClass().getSimpleName().equals("Persona")) {
				System.out.println(((Persona) contacto).getId() + "\t" + ((Persona) contacto).getNombre());
			} else
				System.out.println(((Negocio) contacto).getId() + "\t" + ((Negocio) contacto).getRazonSoc());
		}
	}

	private static void DespliegaMenu() {
		System.out.println("\tM E N U   A G E N D A ");
		System.out.println("1.- Agrega");
		System.out.println("2.- Borra");
		System.out.println("3.- Cambia ");
		System.out.println("4.- Consulta");
		System.out.println("5.- Listado");
		System.out.println("0.- Salir");
		System.out.print("Opcion: ");
	}

	public static void Opcion1() {
		Contacto contacto = null;
		System.out.println("Agrega contacto");
		System.out.print("Tipo de contacto 1-Persona o 2-Negocio: ");
		byte tc = (byte)MissmatchExceptionInt();
		switch (tc) {
		case 1:
			System.out.println(" Agregar contacto persona\n");
			contacto = AgregaPersona(-1);
			break;
		case 2:
			System.out.println(" Agregar contacto negocio\n");
			contacto = AgregaNegocio(-1);
			break;
		default:
			System.out.println("Opcion no valida");
			return;
		}
		agenda.add(contacto);
	}

	private static Contacto AgregaNegocio(int id) {
		System.out.print("Razon social: ");
		leer.nextLine();
		String razonSoc = leer.nextLine();
		System.out.print("Sucursal: ");
		String suc = leer.nextLine();
		System.out.print("Trabajador: ");
		String trab = leer.nextLine();
		System.out.print("Redes sociales: ");
		String redSoc = leer.nextLine();
		System.out.print("Telefono: ");
		String tel = leer.nextLine();;
		System.out.print("Correo: ");
		String correo = leer.nextLine();;
		System.out.print("Notas: ");
		String notas = leer.nextLine();;
		System.out.print("Direccion: ");
		String dir = leer.nextLine();;
		if(id>=0) {
			return new Negocio(id, tel, correo, notas, dir, razonSoc, suc, trab, redSoc);
		}else {
			return new Negocio(SiguienteId(), tel, correo, notas, dir, razonSoc, suc, trab, redSoc);
		}
	}

	private static Contacto AgregaPersona(int id) {
		System.out.print("Nombre: ");
		leer.nextLine();
		String nombre = leer.nextLine();
		System.out.print("Telefono: ");
		String tel = leer.nextLine();;
		System.out.print("Correo: ");
		String correo = leer.nextLine();;
		System.out.print("Notas: ");
		String notas = leer.nextLine();;
		System.out.print("Direccion: ");
		String dir = leer.nextLine();;
		Fecha cumple = leerFecha("Fecha de nacimiento");
		if(id>=0) {
			return new Persona(id, nombre, tel, correo, notas, dir, cumple);
		}else {
			return new Persona(SiguienteId(), nombre, tel, correo, notas, dir, cumple);
		}
	}

	private static Fecha leerFecha(String msg) {
		int dd = 0,mm = 0,aa = 0;
		System.out.println(msg);
		do {
			System.out.print("Dia: ");
			dd = MissmatchExceptionInt();
			if(dd==-4||dd<1||dd>31) {
				System.out.println("Dia no valido");
			}
			
		} while ((dd==-4||dd<1||dd>31));
		do {
			System.out.print("Mes: ");
			mm = MissmatchExceptionInt();
			if(mm==-4||mm<1||mm>12) {
				System.out.println("Mes no valido");
			}
		} while (mm==-4||mm<1||mm>12);
		do {
			System.out.print("Año: ");
			aa = MissmatchExceptionInt();
			if(aa==-4||aa<1913||aa>2100) {
				System.out.println("Año no valido");
			}
		} while (aa==-4||aa<1913||aa>2100);
		return new Fecha(dd, mm, aa);
	}

	public static int SiguienteId() {
		int nextId = 1;
		for (Contacto contacto : agenda) {
			if (contacto.getId() == nextId)
				nextId++;
			else
				break;
		}
		return nextId;
	}

	public static void Opcion2() {
		System.out.println("Borrar contacto");
		// muestra el listado de la agenda
		for (Contacto contacto : agenda) {
			if (contacto.getClass().getSimpleName().equals("Persona")) {
				System.out.println(((Persona) contacto).getId() + "\t" + ((Persona) contacto).getNombre());
			} else
				System.out.println(((Negocio) contacto).getId() + "\t" + ((Negocio) contacto).getRazonSoc());
		}
		System.out.print("Id del contacto a eliminar: ");
		int id = MissmatchExceptionInt();
		int index = -1;
		if ((index = Existe(id)) >= 0) {
			System.out.println(agenda.get(index));
			System.out.print(" �Borrar (S/N)? ");
			char op = leer.next().charAt(0);
			if (op == 'S' || op == 's') {
				agenda.remove(index);
			}
		} else
			System.out.println("Contacto no encontrado");
	}

	private static int Existe(int id) {
		for (Contacto contacto : agenda) {
			if (contacto.getId() == id) {
				return agenda.indexOf(contacto);
			}
		}
		return -1;
	}

	public static void Opcion3() {
		System.out.println("Modificar contacto");
		// muestra el listado de la agenda
		for (Contacto contacto : agenda) {
			if (contacto.getClass().getSimpleName().equals("Persona")) {
				System.out.println(((Persona) contacto).getId() + "\t" + ((Persona) contacto).getNombre());
			} else
				System.out.println(((Negocio) contacto).getId() + "\t" + ((Negocio) contacto).getRazonSoc());
		}
		System.out.print("Id del contacto a modificar: ");
		int id = MissmatchExceptionInt();
		int index = -1;
		if ((index = Existe(id)) >= 0) {
			System.out.println(agenda.get(index));
			System.out.print("¿Modificar (S/N)? ");
			char op = leer.next().charAt(0);
			if (op == 'S' || op == 's') {
				Contacto conta;
				if (agenda.get(index).getClass().getSimpleName().equals("Persona"))
					conta = AgregaPersona(agenda.get(index).getId());
				else
					conta = AgregaNegocio(agenda.get(index).getId());
				agenda.set(index, conta);
			}else {
				System.out.println("Opcion no valida");
			}
		} else
			System.out.println("Contacto no encontrado");
	}

	public static void Opcion4() {
		System.out.println("Consultar contacto");
		// muestra el listado de la agenda
		for (Contacto contacto : agenda) {
			if (contacto.getClass().getSimpleName().equals("Persona")) {
				System.out.println(((Persona) contacto).getId() + "\t" + ((Persona) contacto).getNombre());
			} else
				System.out.println(((Negocio) contacto).getId() + "\t" + ((Negocio) contacto).getRazonSoc());
		}
		System.out.print("Id del contacto a consultar: ");
		int id = MissmatchExceptionInt();
		int index = -1;
		if ((index = Existe(id)) >= 0)
			System.out.println(agenda.get(index));
		else
			System.out.println("Contacto no encontrado");
	}
	
	public static int MissmatchExceptionInt() {
		int a;
		try {
			a = leer.nextInt();
		}catch (InputMismatchException e) {
			leer.nextLine();
			return -4;
		}
		return a;
	}
}
