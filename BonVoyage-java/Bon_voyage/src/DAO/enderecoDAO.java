package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionMysql;
import model.Endereco;


public class enderecoDAO {

	public void save(Endereco endereco) {
		
		String sql = "INSERT INTO endreco(rua, numero, cep, bairro, cidade, estado)" + "VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, endereco.getRua());
			pstm.setInt(2, endereco.getNumero());
			pstm.setInt(3, endereco.getCep());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getCidade());
			pstm.setString(6, endereco.getEstado());
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeById(int id) {
		
		String sql = "DELETE FROM endereco WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm != null) {
					pstm.cancel();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Endereco endereco) {
		
		String sql = "UPDATE endereco SET rua = ?, numero = ?, cep = ?, bairro = ?, cidade = ?, estado = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, endereco.getRua());
			pstm.setInt(2, endereco.getNumero());
			pstm.setInt(3, endereco.getCep());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getCidade());
			pstm.setString(6, endereco.getEstado());
			pstm.setInt(7, endereco.getId_endereco());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Endereco> getEndereco(){
		
		String sql = "SELECT * FROM endereco";
		List<Endereco> endereco = new ArrayList<Endereco>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Endereco Endereco = new Endereco();
				
				Endereco.setId_endereco(rset.getInt("id_endereco"));
				Endereco.setRua(rset.getString("rua"));
				Endereco.setNumero(rset.getInt("numero"));
				Endereco.setCep(rset.getInt("cep"));
				Endereco.setBairro(rset.getString("bairro"));
				Endereco.setCidade(rset.getString("cidade"));
				Endereco.setEstado(rset.getString("estado"));
				
				Endereco.add(Endereco);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return endereco;
	}
}