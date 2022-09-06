package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionMysql;
import model.Compra;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class compraDAO {

	public void save(Compra compra) {
		
		 String sql = "INSERT INTO compra (data_compra) VALUES (?)";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 
			 conn = ConnectionMysql.createConnectionMysql();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setDate(1, compra.getData_compra());
				
				pstm.execute();
				
		} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    }

	public void removeById(Date id) {
		
		String sql = "DELETE FROM compra WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1,id);
			
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
	
	public void update(Compra compra) {
		
		String sql = "UPDATE compra SET data = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, compra.getData_compra());
			
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
	
	public List<Compra> getcompra(){
		
		String sql = "SELECT * FROM compra";
		
		List<Compra> compra = new ArrayList<Compra>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Compra Compra = new Compra();
				
				Compra.setData_compra(rset.getDate("data_compra"));
				
			    compra.add(Compra);
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
		return compra;
	}
}