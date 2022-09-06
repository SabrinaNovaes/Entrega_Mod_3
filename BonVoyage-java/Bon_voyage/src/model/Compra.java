package model;

import java.sql.Date;

public class Compra {
	
	private int id_compra;
	private Date data_compra;
	
	private int id_cpf;
	private int id_pcts;
	
	public Compra () {
		
	}

	public Compra(int id_compra, Date data_compra, int id_cpf, int id_pcts) {
		super();
		this.id_compra = id_compra;
		this.data_compra = data_compra;
		this.id_cpf = id_cpf;
		this.id_pcts = id_pcts;
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}

	public int getId_cpf() {
		return id_cpf;
	}

	public void setId_cpf(int id_cpf) {
		this.id_cpf = id_cpf;
	}

	public int getId_pcts() {
		return id_pcts;
	}

	public void setId_pcts(int id_pcts) {
		this.id_pcts = id_pcts;
	}

	
}