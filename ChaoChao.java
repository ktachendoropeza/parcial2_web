package unidad3;

public class ChaoChao extends Perro {

	public ChaoChao(String nombre, int patas) {
		super(nombre, patas);
		// TODO Auto-generated constructor stub
	}

	public ChaoChao(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Comer(String alimento) {
		System.out.println("ChaoChao alimentandose de "+alimento);

	}

}
