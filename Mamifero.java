package unidad3;

public abstract class Mamifero {
	
	private String nombre;
	protected int patas;
	public Mamifero(String nombre,int patas) {
		this.nombre = nombre;
		this.patas = patas;
	}
	
	public Mamifero(){
		
	}
	
	public void ImprimePatas(){
		System.out.println("Mamifero más inteligente que fer de "+patas+" patas");
	}
	
	public abstract void Comer(String alimento);
	
	
}
