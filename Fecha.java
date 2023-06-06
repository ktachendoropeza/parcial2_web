package utilerias;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Fecha implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String[] Mes = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
			"Septiembre", "Octubre", "Noviembre", "Diciembre" };
	private int dd, mm, aaaa;

	public Fecha(int dd, int mm, int aaaa) {
		this.dd = dd;
		this.mm = mm;
		this.aaaa = aaaa;
	}

	public Fecha() {
		this(0, 0, 0);
	}

	public boolean isEmpty() {
		return dd == 0 && mm == 0 && aaaa == 0;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		if (dd >= 1 && dd <= 31)
			this.dd = dd;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		if (mm >= 1 && mm <= 12)
			this.mm = mm;
	}

	public int getAaaa() {
		return aaaa;
	}

	public void setAaaa(int aaaa) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-aaaa");

		if (aaaa >= 1913 && aaaa <= 2100)
			this.aaaa = aaaa;
	}
	
	public String saveFecha() {
		return dd + "|" + mm + "|" + aaaa;
	}

	@Override
	public String toString() {
		return dd + " de " + Mes[mm - 1] + (aaaa < 2000 ? " de " : " del ") + aaaa;
	}

}
