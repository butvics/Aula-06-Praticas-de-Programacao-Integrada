package br.usjt.OO;

import java.util.ArrayList;

public class PaisService {
	PaisDAO dao = new PaisDAO();

	@SuppressWarnings({ "rawtypes" })
	public ArrayList getPaisMaisHab() {
		return PaisDAO.buscaPaisMaisHab();	
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getPaisMenor() {
		return PaisDAO.buscaPaisMenor();	
	}

	public int criar(Pais pais) {
		return PaisDAO.criar(pais.getNomePais(), pais.getPopulacaoPais(), pais.getAreaPais());
	}

	public void atualizar(Pais pais){
		PaisDAO.atualizar(0, null, 0, 0);
	}

	public void excluir(int idPais){
		PaisDAO.excluir(idPais);
	}

	public Pais carregar(int idPais){
		return PaisDAO.carregar(idPais);
	}
}