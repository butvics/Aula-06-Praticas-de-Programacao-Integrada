package br.usjt.OO;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTeste {
	Pais pais, copia;
	static int id = 0;

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		System.out.println(PaisDAO.carregar(1));
		System.out.println(PaisDAO.carregar(2));
		System.out.println(PaisDAO.carregar(3));
		System.out.println(PaisDAO.carregar(4));
		System.out.println(PaisDAO.carregar(5));
	}

	@Test
	public void test01Criar() {
		System.out.println("Criar pa�s");
		PaisDAO.criar("Espanha11", 11146524943L, 99504030);
		System.out.println(PaisDAO.carregar(6));
	}

	@Test
	public void test02Atualizar() {
		System.out.println("Atualizar pa�s");
		PaisDAO.atualizar(6, "Chile", 123456789, 987654321);
		System.out.println(PaisDAO.carregar(6));
	}

	@Test
	public void test03Excluir() {
		System.out.println("Excluir pa�s");
		PaisDAO.excluir(13);
		System.out.println(PaisDAO.carregar(6));
	}

	@Test
	public void test04PaisMaisHab() {
		System.out.println("Busca do pa�s mais habitado");
		System.out.println(PaisDAO.buscaPaisMaisHab());
	}
	
	@Test
	public void test05PaisMenor() {
		System.out.println("Busca do pa�s menor");
		System.out.println(PaisDAO.buscaPaisMenor());
	}
	
	@Test
	public void test06Vetor() {
		System.out.println("Vetor 3 pa�ses");
		Pais[] vetor = PaisDAO.Vetor();
		for (Pais pais : vetor) {
			System.out.println(pais);
		}
	}
}