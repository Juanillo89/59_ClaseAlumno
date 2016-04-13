package ejercicio59;

public class Alumno
{
	private String nombre;
	private double[] notas;
	private static final double SIN_NOTA = -1.0;



	public Alumno(String nombre)
	{
		super();
		this.nombre = nombre;
		notas = new double[]{SIN_NOTA, SIN_NOTA, SIN_NOTA};
	}



	public String getNombre()
	{
		return nombre;
	}



	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public boolean ponerNota(int evaluacion, double nota)
	{
		if(!evaluacionValida(evaluacion) || !notaValida(nota))
			return false;

		notas[evaluacion - 1] = nota;
		return true;
	}

	public boolean borrarNota(int evaluacion)
	{
		if(!evaluacionValida(evaluacion))
			return false;

		notas[evaluacion - 1] = SIN_NOTA;
		return true;
	}

	/**
	 *
	 * @return
	 */
	public int numeroNotas()
	{
		int contNotas = 0;
		for (int i = 0; i < notas.length; i++)
		{
			if(notas[i] != SIN_NOTA)
			{
				contNotas++;
			}
		}
		return contNotas;
	}

	public double notaMaxima()
	{
		double max = -1;
		for (int i = 0; i < notas.length; i++)
		{
			if(notas[i] != SIN_NOTA && notas[i] > max)
			{
				max = notas[i];
			}
		}
		return max;
	}

	public boolean tieneNota(int evaluacion)
	{
		if(!evaluacionValida(evaluacion))
			return false;
		if(notas[evaluacion - 1] != SIN_NOTA)
			return true;
		else
			return false;
	}

	public double getNota(int evaluacion)
	{
		if(!evaluacionValida(evaluacion))
			return -1;
		if(notas[evaluacion - 1] != SIN_NOTA)
			return notas[evaluacion - 1];
		else
			return -1;
	}

	private boolean evaluacionValida(int evaluacion)
	{
		if(evaluacion < 1 || evaluacion > 3)
			return false;
		else
			return true;

	}

	private boolean notaValida(double nota)
	{
		if(nota < 0 || nota > 10)
			return false;
		else
			return true;
	}

}