package agenda;

public class Negocio extends Contacto {

	private String razonSoc, sucursal, trabajador, redesSociales;

	public Negocio(int id, String cel, String correo, String notas, String dir, String razonSoc,
			String sucursal, String trabajador, String redesSociales) {
		super(id, cel, correo, notas, dir);
		this.razonSoc = razonSoc;
		this.sucursal = sucursal;
		this.trabajador = trabajador;
		this.redesSociales = redesSociales;
	}
	public Negocio() {
		this(-1,"","","","","","","","");
	}

	public String getRazonSoc() {
		return razonSoc;
	}

	public void setRazonSoc(String razonSoc) {
		this.razonSoc = razonSoc;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public String getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(String redesSociales) {
		this.redesSociales = redesSociales;
	}

	@Override
	public String toString() {
		return "Negocio" + super.toString() + "\t" + razonSoc + "\t" + sucursal + "\t" + trabajador + "\t"
				+ redesSociales;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Negocio?((Negocio) obj).razonSoc.equals(razonSoc) && ((Negocio) obj).sucursal.equals(sucursal):false;
	}

}
