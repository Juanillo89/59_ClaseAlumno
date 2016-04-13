//Menú:
//1.-Introducir nombre.
//2.-Listar nombres.
//3.-Eliminar nombre.
//4.-Eliminar todos los nombres.
//5.-Salir.
package ejercicio59;

import java.util.Scanner;

public class Main
{

	private static Alumno[] alumnos;
	private static int cont = 0;
	private static Scanner sc;

	public static void main(String[] args)
	{
		alumnos = new Alumno[5];
		sc = new Scanner(System.in);

		char opcion = '0';
		while(opcion != '7')
		{
			mostrarMenu();
			opcion = sc.nextLine().charAt(0);
			switch (opcion)
			{
				case '1': // Introducir alumno

					introducirAlumno();

					break;
				case '2': // Listar notas

					listarNotas();

					break;
				case '3': // Poner nota

					ponerNota();

					break;
				case '4': // Borrar nota

					borrarNota();

					break;
				case '5': // Eliminar todos

					eliminarTodos();

					break;
				case '6': // Borrar todas las notas

					borrarTodasLasNotas();

					break;
				case '7': // Salir
					break;
				default:
					System.out.println("Opción no valida.");
			}
		}
		sc.close();
	}

	/**
	 *
	 * @param nombre
	 * @return posición en el array donde se encuentra. -1 si no lo encuentra.
	 */
	private static int buscarAlumno(String nombre)
	{
		for (int i = 0; i < cont; i++)
		{
			if(nombre.equalsIgnoreCase(alumnos[i].getNombre()))
			{
				return i;
			}
		}
		return -1;
	}

	private static void ponerNota()
	{
		System.out.print("Nombre:");
		String nombre = sc.nextLine();

		int posicionAlumno = buscarAlumno(nombre);

		if(posicionAlumno == -1)
		{
			System.out.println("Alumno no encontrado.");
		}
		else
		{
			int evaluacion;
			do
			{
				System.out.print("Evaluación (1,2,3):");
				evaluacion = Integer.parseInt(sc.nextLine());
			}
			while(evaluacion < 1 || evaluacion > 3);
			Double nota;
			do
			{
				System.out.print("Nota (0-10):");
				nota = Double.parseDouble(sc.nextLine());
			}
			while(nota < 0 || nota > 10);
			alumnos[posicionAlumno].ponerNota(evaluacion, nota);
		}
	}

	private static void borrarNota()
	{
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		int posicionAlumno = buscarAlumno(nombre);
		if(posicionAlumno == -1)
		{
			System.out.println("Alumno no encontrado.");
		}
		else
		{
			int evaluacion;
			do
			{
				System.out.print("Evaluación (1,2,3):");
				evaluacion = Integer.parseInt(sc.nextLine());
			}
			while(evaluacion < 1 || evaluacion > 3);
			alumnos[posicionAlumno].borrarNota(evaluacion);
		}
	}

	private static void borrarTodasLasNotas()
	{
		for (int i = 0; i < cont; i++)
		{
			for (int j = 1; j <= 3; j++)
			{
				alumnos[i].borrarNota(j);
			}
		}
	}

	private static void eliminarTodos()
	{
		cont = 0;
	}

	private static void listarNotas()
	{
		System.out.println("Alumno\t\t1ev\t2ev\t3ev\tNºNotas\tMáxima");
		for (int i = 0; i < cont; i++)
		{
			System.out.print(alumnos[i].getNombre() + "\t\t");
			System.out.print((alumnos[i].getNota(1) == -1 ? "--" : alumnos[i].getNota(1)) + "\t");
			System.out.print((alumnos[i].getNota(2) == -1 ? "--" : alumnos[i].getNota(2)) + "\t");
			System.out.print((alumnos[i].getNota(3) == -1 ? "--" : alumnos[i].getNota(3)) + "\t");
			System.out.print(alumnos[i].numeroNotas() + "\t");
			System.out.print((alumnos[i].notaMaxima() == -1 ? "--" : alumnos[i].notaMaxima()) + "\t\n");
		}
	}

	private static void introducirAlumno()
	{
		if(cont == alumnos.length)
		{
			System.out.println("No hay sitio.");
			return;
		}

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		if(buscarAlumno(nombre) != -1)
		{
			System.out.println("Ya existe ese alumno.");
		}
		else
		{
			alumnos[cont] = new Alumno(nombre);
			cont++;
		}
	}

	private static void mostrarMenu()
	{
		System.out.println("Menú:\n" +
			"1.-Introducir alumno.\n" +
			"2.-Listado notas.\n" +
			"3.-Poner nota.\n" +
			"4.-Borrar nota.\n" +
			"5.-Eliminar todos los alumnos.\n" +
			"6.-Borrar todas las notas\n" +
			"7.-Salir.");
	}
}