package model;


public class Pacotes {
	
	private int id_pcts;
	private String destino;
	private String hospedagem;
	private int qntd_dias;
	private int qntd_passagem;
	private double precos;

	public void acessa_Destinos() {
			
	}
	
	public Pacotes(int id_pcts2, String destinos) {
		
	}

	public Pacotes(int id_pcts, String destino, String hospedagem, int qntd_dias, int qntd_passagem, double precos) {
		super();
		this.id_pcts = id_pcts;
		this.destino = destino;
		this.hospedagem = hospedagem;
		this.qntd_dias = qntd_dias;
		this.qntd_passagem = qntd_passagem;
		this.precos = precos;
	}

	public Pacotes() {

	}

	public int getId_pcts() {
		return id_pcts;
	}

	public void setId_pcts(int id_pcts) {
		this.id_pcts = id_pcts;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(String hospedagem) {
		this.hospedagem = hospedagem;
	}

	public int getQntd_dias() {
		return qntd_dias;
	}

	public void setQntd_dias(int qntd_dias) {
		this.qntd_dias = qntd_dias;
	}

	public int getQntd_passagem() {
		return qntd_passagem;
	}

	public void setQntd_passagem(int qntd_passagem) {
		this.qntd_passagem = qntd_passagem;
	}

	public double getPrecos() {
		return precos;
	}

	public void setPrecos(double precos) {
		this.precos = precos;
	}

	public void add(Pacotes pacote) {
		
	}

}

