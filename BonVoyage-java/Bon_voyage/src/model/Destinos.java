package model;

public class Destinos {
	
	private int id_destinos;
	private String nacionais;
	private String internacionais;
	private String pct_familia;
	
	public Destinos() {
		
	}

	public Destinos(int id_destinos, String nacionais, String internacionais, String pct_familia) {
		super();
		this.id_destinos = id_destinos;
		this.nacionais = nacionais;
		this.internacionais = internacionais;
		this.pct_familia = pct_familia;
	}

	public int getId_destinos() {
		return id_destinos;
	}

	public void setId_destinos(int id_destinos) {
		this.id_destinos = id_destinos;
	}

	public String getNacionais() {
		return nacionais;
	}

	public void setNacionais(String nacionais) {
		this.nacionais = nacionais;
	}

	public String getInternacionais() {
		return internacionais;
	}

	public void setInternacionais(String internacionais) {
		this.internacionais = internacionais;
	}

	public String getPct_familia() {
		return pct_familia;
	}

	public void setPct_familia(String pct_familia) {
		this.pct_familia = pct_familia;
	}

	public void add(Destinos destinos) {
		
	}

	public void setDestino() {
		
	}
	
}

