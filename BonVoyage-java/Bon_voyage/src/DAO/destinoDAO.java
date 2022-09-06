package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionMysql;
import model.Destinos;

public class destinoDAO {
	
	public void save(Destinos destinos) {
		
		String sql = "INSERT INTO destinos (internacionais, nacionais, pct_familia)" + "VALUES (?, ?, ?))";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destinos.getInternacionais());
			pstm.setString(2, destinos.getNacionais());
			pstm.setString(3, destinos.getPct_familia());
			
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
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeById(int id) {
		
		String sql = "DELETE FROM destinos WHERE id = ?";
		
		Connection conn = null;
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
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Destinos destinos) {
		
		String sql = "UPDATE destinos SET internacionais = ?, nacionais = ?, pct_familia = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destinos.getInternacionais());
			pstm.setString(2, destinos.getNacionais());
			pstm.setString(3, destinos.getPct_familia());
			pstm.setInt(4, destinos.getId_destinos());
			
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
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Destinos> getDestinos(){
		
		String sql = "SELECT * FROM destinos";
		List<Destinos> destinos = new ArrayList<Destinos>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Destinos Destinos = new Destinos();
				
				Destinos.setId_destinos(rset.getInt("id_destinos"));
				Destinos.setInternacionais(rset.getString("internacionais"));
				Destinos.setNacionais(rset.getString("nacionais"));
				Destinos.setPct_familia(rset.getString("pct_familia"));
				
				Destinos.add(Destinos);
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
		return destinos;
	}
}
