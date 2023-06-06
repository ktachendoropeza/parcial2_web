package agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import utilerias.Fecha;

public abstract class Contacto {
	
	public static BufferedReader br;
	private static PrintWriter pw;
	private static File ArchivoE,ArchivoL;
	
	public static void AbrirArchivo(String NomArchivo, boolean Escritura) throws IOException{
		if(Escritura){
			ArchivoE = new File(NomArchivo);
			pw = new PrintWriter(new FileWriter(ArchivoE,true));
		}
		else{
			ArchivoL = new File(NomArchivo);
			br = new BufferedReader(new FileReader(ArchivoL));
		}
	}
	
	public static void CerrarArchivo() throws IOException{
		if(pw!=null){
			pw.close();
		}
		if(br!=null){
			br.close();
		}
	}
	
	public static ArrayList<Contacto> CargaRegistro() throws IOException {
		ArrayList <Contacto> temp = new ArrayList<>();
		AbrirArchivo("Contactos.txt", false);
		String linea = br.readLine();
		while(linea != null){
				temp.add(Str2Cont(linea));
				linea = br.readLine();
		}
		CerrarArchivo();
		if(!temp.isEmpty()) {
			return temp;
		}
		return new ArrayList<>();
	}
	
	private static Contacto Str2Cont(String linea) {
		int [] pipe = new int[9];
		for (int i = 0; i < pipe.length; i++) {
			if(i==0) {
				pipe[i] = linea.indexOf("|");
			}else {
				pipe[i] = linea.indexOf("|",(pipe[i-1]+1));
			}
		}
		if(linea.substring(0,pipe[0]).equals("Persona")) {
			int id = Integer.parseInt(linea.substring(pipe[0]+1,pipe[1]));
			String nombre = linea.substring(pipe[1]+1,pipe[2]);
			String tel = linea.substring(pipe[2]+1,pipe[3]);
			String correo = linea.substring(pipe[3]+1,pipe[4]);
			String notas = linea.substring(pipe[4]+1,pipe[5]);
			String direccion = linea.substring(pipe[5]+1,pipe[6]);
			int dia = Integer.parseInt(linea.substring(pipe[6]+1,pipe[7]));
			int mes = Integer.parseInt(linea.substring(pipe[7]+1,pipe[8]));
			int año = Integer.parseInt(linea.substring(pipe[8]+1));
			Fecha cumple = new Fecha(dia,mes,año);
			return new Persona(id,nombre,tel,correo,notas,direccion,cumple);
		}else{
			int id = Integer.parseInt(linea.substring(pipe[0]+1,pipe[1]));
			String tel = linea.substring(pipe[1]+1,pipe[2]);
			String correo = linea.substring(pipe[2]+1,pipe[3]);
			String notas = linea.substring(pipe[3]+1,pipe[4]);
			String direccion = linea.substring(pipe[4]+1,pipe[5]);
			String razonSoc = linea.substring(pipe[5]+1,pipe[6]);
			String sucursal = linea.substring(pipe[6]+1,pipe[7]);
			String trabajador = linea.substring(pipe[7]+1,pipe[8]);
			String redes = linea.substring(pipe[8]+1);
			return new Negocio(id,tel,correo,notas,direccion,razonSoc,sucursal,trabajador,redes);
		}
		
	}

	public static void GrabaRegistro(ArrayList<Contacto> temp) throws IOException{
		if(!ArchivoL.exists()) {
			if(ArchivoL.createNewFile()) {
				System.out.println("Se creo el archivo exitosamente");
			}else {
				System.out.println("Se fracaso");
			}
		}
		AbrirArchivo("Contactos.txt", false);
		AbrirArchivo("Tmp.txt", true);
		for (Contacto contacto : temp) {
			if (contacto.getClass().getSimpleName().equals("Persona")) {
				pw.println("Persona"+"|"+contacto.getId()+"|"+((Persona)contacto).getNombre()+"|"+contacto.getTel()+"|"+contacto.getCorreo()+"|"+contacto.getNotas()+"|"+contacto.getDir()+"|"+((Persona)contacto).getCumple().saveFecha());
			}else {
				pw.println("Negocio"+"|"+contacto.getId()+"|"+contacto.getTel()+"|"+contacto.getCorreo()+"|"+contacto.getNotas()+"|"+contacto.getDir()+"|"+((Negocio)contacto).getRazonSoc()+"|"+((Negocio)contacto).getSucursal()+"|"+((Negocio)contacto).getTrabajador()+"|"+((Negocio)contacto).getRedesSociales());
			}
		}
		CerrarArchivo();
		if(ArchivoL.exists()){
			ArchivoL.delete();
			System.out.println("");
		}else{
			System.out.print("");
		}
		if(ArchivoE.exists()){
			ArchivoE.renameTo(new File("Contactos.txt"));
			System.out.println("");
		}else{
			System.out.println("");
		}
		CerrarArchivo();
	}

	private static final long serialVersionUID = 1L;

	private int id;
	private String tel, correo, notas, dir;
	private static int contador = 0;

	public Contacto(int id, String cel, String correo, String notas, String dir) {
		this.id = id;
		this.tel = cel;
		this.correo = correo;
		this.notas = notas;
		this.dir = dir;
		contador++;
	}

	public static int InstanciasActivas() {
		return contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return id + "\t" + tel + "\t" + correo + "\t" + notas + "\t" + dir;
	}

	@Override
	public boolean equals(Object obj) {
		return tel.equals(((Contacto) obj).tel);
	}

	@Override
	protected void finalize() throws Throwable {
		contador--;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

}
