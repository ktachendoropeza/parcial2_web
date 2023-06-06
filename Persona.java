package agenda;

import utilerias.Fecha;

public class Persona extends Contacto {

	private String nombre;
	private Fecha cumple;

	public Persona(int id, String nombre, String tel, String correo, String notas, String dir, Fecha cumple) {
		super(id, tel, correo, notas, dir);
		this.nombre = nombre;
		this.cumple = cumple;
	}

	public Persona(int id, String nombre, String tel) {
		this(id, nombre, tel, "", "", "",new Fecha());
	}
	
	public Persona() {
		this(-1,"", "", "", "", "",new Fecha());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getCumple() {
		return cumple;
	}

	public void setCumple(Fecha cumple) {
		this.cumple = cumple;
	}
	
	public boolean isEmpty() {
		// return nombre.isBlank();
		return nombre.equals("");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Persona?nombre.equals(((Persona) obj).nombre) || super.equals(obj):false;
	}

	@Override
	public String toString() {
		return "Persona:" + "\t" + super.getId() + "\t" + nombre + "\t" + super.getTel() + "\t" + super.getCorreo()
				+ "\t" + super.getDir() + "\t" + super.getNotas() + "\t" + cumple;
	}

}
