

public class Guatemala {

	public Guatemala() {
	}
	

	//Declarando las variables tipo String de cada combobox
	private String nombre;
	private String nit;
	private String nohabitaciones;
	private String tipodehabitaciones;
	private String piso;
	private String diashospedaje;
	private String formadepago;
	private int dia=0;
	private String mes;
    private String Telefono;

	



	//Generando constructor
	public Guatemala(String nombre, String nit, String nohabitaciones,
			String tipodehabitaciones, String piso, String diashospedaje,
			String formadepago, String mes,int dia) {
		super();
		this.nombre = nombre;
		this.nit = nit;
		this.nohabitaciones = nohabitaciones;
		this.tipodehabitaciones = tipodehabitaciones;
		this.piso = piso;
		this.diashospedaje = diashospedaje;
		this.formadepago = formadepago;
		this.mes = mes;
		this.dia = dia;
	}
	
	
	//Generacion de get and setter
	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getNohabitaciones() {
		return nohabitaciones;
	}
	public void setNohabitaciones(String nohabitaciones) {
		this.nohabitaciones = nohabitaciones;
	}
	public String getTipodehabitaciones() {
		return tipodehabitaciones;
	}
	public void setTipodehabitaciones(String tipodehabitaciones) {
		this.tipodehabitaciones = tipodehabitaciones;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDiashospedaje() {
		return diashospedaje;
	}
	public void setDiashospedaje(String diashospedaje) {
		this.diashospedaje = diashospedaje;
	}
	public String getFormadepago() {
		return formadepago;
	}
	public void setFormadepago(String formadepago) {
		this.formadepago = formadepago;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
}
 