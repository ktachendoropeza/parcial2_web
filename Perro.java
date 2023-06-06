package unidad3;

public class Perro extends Mamifero {
	
	public Perro(String nombre,int patas) {
		super("Solovino",4);
	}
	public Perro(String nombre) {
		super("Solovino",0);
	}
	
	@Override
	public void Comer(String alimento) {
		System.out.println("Perro alimentandose de "+alimento);
		
	}
	
}
