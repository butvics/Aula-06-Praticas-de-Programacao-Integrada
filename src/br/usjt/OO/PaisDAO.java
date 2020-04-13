package br.usjt.OO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {

	public static int criar(String nomePais, long populacaoPais, double areaPais) {
		int idPais = 0;
		String sqlInsert = "INSERT INTO pais(nomePais, populacaoPais, areaPais) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, nomePais);
			stm.setLong(2, populacaoPais);
			stm.setDouble(3, areaPais);
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					idPais = rs.getInt(1);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idPais; 
	}
	public static void atualizar(int idPais, String nomePais, long populacaoPais, double areaPais) {
		String sqlUpdate = "UPDATE pais SET nomePais=?, populacaoPais=?, areaPais=? WHERE idPais=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, nomePais);
			stm.setLong(2, populacaoPais);
			stm.setDouble(3, areaPais);
			stm.setInt(4, idPais);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void excluir(int idPais) {
		String sqlDelete = "DELETE FROM pais WHERE idPais = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idPais);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Pais carregar(int idPais) {
		Pais pais = null;
		String sqlSelect = "SELECT nomePais, populacaoPais, areaPais FROM pais WHERE idPais = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idPais);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String nomePais = (rs.getString("nomePais"));
					Long populacaoPais = (rs.getLong("populacaoPais"));
					Double areaPais = (rs.getDouble("areaPais"));
					pais = new Pais(idPais, nomePais, populacaoPais, areaPais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaPaisMaisHab() {
		ArrayList buscaHabi = new ArrayList();
		String sqlSelect = "select * from pais order by populacao desc limit 1";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					buscaHabi.add(rs.getString("nomePais"));
					buscaHabi.add(rs.getString("populacaoPais"));
					buscaHabi.add(rs.getString("areaPais"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return buscaHabi;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList buscaPaisMenor() {
		ArrayList buscaArea = new ArrayList();
		String sqlSelect = "select * from pais order by area cres limit 1";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					buscaArea.add(rs.getString("nomePais"));
					buscaArea.add(rs.getString("populacaoPais"));
					buscaArea.add(rs.getString("areaPais"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return buscaArea;
	}

	public static Pais[] vetor3() {
		Pais[] vetor = new Pais[3];
		vetor[0] = carregar(1);
		vetor[1] = carregar(2);
		vetor[2] = carregar(3);
		return vetor;
	}

	public static Pais[] Vetor() {
		Pais pais = null;
		Pais[] vetor = new Pais[4];
		int count = 0;
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais limit 4";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					String nomePais = rs.getString("nomePais");
					Long populacaoPais = rs.getLong("populacaoPais");
					Double areaPais = rs.getDouble("areaPais");
					pais = new Pais(nomePais, populacaoPais, areaPais);
					vetor[count++] = pais;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return vetor;
	}
}