package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionMysql;
import model.Pacotes;

public class pacotesDAO {
	
	public void save(Pacotes pacote) {
		String sql = "INSERT INTO pacotes(destino, hospedagem, precos, qntd_dias, qntd_passagem)" + "VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			 
			pstm.setString(1, pacote.getDestino());
			pstm.setString(2, pacote.getHospedagem());
			pstm.setDouble(3, pacote.getPrecos());
			pstm.setInt(4, pacote.getQntd_dias()); 
			pstm.setInt(5, pacote.getQntd_dias());
			
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

	public void removeById(int id) {
		String sql = "DELETE FROM pacotes WHERE id = ?";
		
		Connection conn = null ;
		PreparedStatement pstm = null;
				
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
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
	
	public void update(Pacotes pacotes) {
		
		String sql = "UPDATE pacotes SET destino = ?, hospedagem = ?, qntd_dias =?, qntd_passagem = ? " + "WHERE id =?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,  pacotes.getDestino());
			pstm.setString(2, pacotes.getHospedagem());
			pstm.setDouble(3, pacotes.getPrecos());
			pstm.setInt(4, pacotes.getQntd_dias());
			pstm.setInt(5, pacotes.getQntd_passagem());
			
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
	
	public List<Pacotes> getPacotes(){
		
		String sql = "SELECT * FROM pacotes";
		
		List<Pacotes> pacotes = new ArrayList<Pacotes>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Pacotes pacote = new Pacotes();
				
				pacote.setId_pcts(rset.getInt("id"));
				pacote.setDestino(rset.getString("destinos"));
				pacote.setHospedagem(rset.getString("hospedagem"));
				pacote.setQntd_dias(rset.getInt("qntd_dias"));
				pacote.setQntd_passagem(rset.getInt("qntd_passagem"));
				pacote.setPrecos(rset.getDouble("precos"));
				
				pacote.add(pacote);
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
		return pacotes;
}
}