package br.usjt.OO;

public class Pais {
	public int idPais;
	public String nomePais;
	public long populacaoPais;
	public double areaPais;
	
	
public Pais() {
		
	}
	
	public Pais(String nomePais, long populacaoPais, double areaPais) {
		this.nomePais = nomePais;
		this.populacaoPais = populacaoPais;
		this.areaPais = areaPais;
	}
	
	public Pais(int idPais, String nomePais, long populacaoPais, double areaPais) {
		this.idPais = idPais;
		this.nomePais = nomePais;
		this.populacaoPais = populacaoPais;
		this.areaPais = areaPais;
	}	

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nomePais=" + nomePais + ", populacaoPais=" + populacaoPais + ", areaPais=" 
				+ areaPais + "]";
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais= idPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public long getPopulacaoPais() {
		return populacaoPais;
	}

	public void setPopulacaoPais(long populacaoPais) {
		this.populacaoPais = populacaoPais;
	}

	public double getAreaPais() {
		return areaPais;
	}

	public void setAreaPais(double areaPais) {
		this.areaPais = areaPais;
	}
}