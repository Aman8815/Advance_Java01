package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.MarksheetBean;

public class MarksheetModel {
	
	
	//1. create a method next id ganerate;
	public int nextpk() throws Exception {
		int pk =0;
      Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
		
	   PreparedStatement pstmt =  con.prepareStatement("Select max(id) from marksheet");
	      ResultSet rs  =  pstmt.executeQuery();
	      
	      while(rs.next()) {
	    	  pk = pk+rs.getInt(1);
	      }
		
		
		
		return  pk+1;
	}
	//2.create a mthod the next roll number;
	
	public int nextrn() throws Exception {
		int rn =0;
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("Select max(rollno) from marksheet");
		      ResultSet rs  =  pstmt.executeQuery();
		      
		      while(rs.next()) {
		    	  rn = rn+rs.getInt(1);
		      }
		return rn+1;
	}
	
	//2.create method add data
	public void add(MarksheetBean bean) throws Exception {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		   
		   pstmt.setInt(1,nextpk());
		   pstmt.setInt(2,nextrn());
		   pstmt.setString(3,bean.getName());
		   pstmt.setInt(4,bean.getPhysics());
		   pstmt.setInt(5,bean.getChemestry());
		   pstmt.setInt(6,bean.getMaths());
		   pstmt.executeUpdate();
		   
		   System.out.println("Insert data succesfully");
		
		
	}
	
	public void update(MarksheetBean bean) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("update marksheet set rollno =?,name = ?,physics = ?,chemestry = ?,maths = ? where id=?");
		   
		   
		   pstmt.setInt(1,bean.getRollno());
		   pstmt.setString(2,bean.getName());
		   pstmt.setInt(3,bean.getPhysics());
		   pstmt.setInt(4,bean.getChemestry());
		   pstmt.setInt(5,bean.getMaths());
		   pstmt.setInt(6,bean.getId());
		   pstmt.executeUpdate();
		   
		   System.out.println("Update data successfully");
		   
		   
		
	}
	
	public void Delete(int id) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println(id);
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("delete from marksheet where id=?");
		   
		   pstmt.setInt(1,id);
		   pstmt.executeUpdate();
		   
		   System.out.println("Delete data successfully");
	}
	
	public List search() throws Exception {
		List list = new ArrayList();
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("select * from marksheet");
		   
		    ResultSet rs =    pstmt.executeQuery();
		    
		    MarksheetBean bean = null;
		    
		    while(rs.next()) {
		    	bean = new MarksheetBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setRollno(rs.getInt(2));
		    	bean.setName(rs.getString(3));
		    	bean.setPhysics(rs.getInt(4));;
		    	bean.setChemestry(rs.getInt(5));
		    	bean.setMaths(rs.getInt(6));
		    	list.add(bean); 	
		    	
		    }
		  
		
		return list;
	}
	
	public List maridemarksheet() throws Exception {
		List list = new ArrayList();
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement(" select * ,(physics+chemestry+maths) as total,((physics+chemestry+maths)/3) as percentage from marksheet order by  total desc limit 5");
		   
		    ResultSet rs =    pstmt.executeQuery();
		    
		    MarksheetBean bean = null;
		    
		    while(rs.next()) {
		    	bean = new MarksheetBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setRollno(rs.getInt(2));
		    	bean.setName(rs.getString(3));
		    	bean.setPhysics(rs.getInt(4));;
		    	bean.setChemestry(rs.getInt(5));
		    	bean.setMaths(rs.getInt(6));
		    	list.add(bean); 	
		    	
		    }
		  
		
		return list;
	}
	public List passfail() throws Exception {
		List list = new ArrayList();
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
		   PreparedStatement pstmt =  con.prepareStatement("select * from marksheet");
		   
		    ResultSet rs =    pstmt.executeQuery();
		    
		    MarksheetBean bean = null;
		    
		    while(rs.next()) {
		    	bean = new MarksheetBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setRollno(rs.getInt(2));
		    	bean.setName(rs.getString(3));
		    	bean.setPhysics(rs.getInt(4));;
		    	bean.setChemestry(rs.getInt(5));
		    	bean.setMaths(rs.getInt(6));
		    	list.add(bean); 	
		    	
		    }
		  
		
		return list;
	}
	
	public List choice(MarksheetBean bean)throws Exception {
		List list = new ArrayList();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String uName = "root";
		String pass = "root";
         StringBuffer sql = new  StringBuffer("select * from marksheet where 1 = 1 ");
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
		
		if(bean!=null) {
			if(bean.getId()>0) {
				sql.append("and id = "+bean.getId());
			}
			if(bean.getName()!= null && bean.getName().length()>0) {
				sql.append("and name like '"+bean.getName()+"%'");
			}
			if(bean.getRollno()>0) {
				sql.append("and rollno ="+bean.getRollno());
			}
			if(bean.getPhysics()>0) {
				sql.append("and physics ="+bean.getPhysics());
			}
			if(bean.getChemestry()>0) {
				sql.append("and chemestry ="+bean.getChemestry());
			}
			if(bean.getMaths()>0) {
				sql.append("and maths ="+bean.getMaths());
			}
		}
		
	   PreparedStatement pstmt =  con.prepareStatement(sql.toString());
	   
	    ResultSet rs =    pstmt.executeQuery();
	    
	    
	    
	    while(rs.next()) {
	    	bean = new MarksheetBean();
	    	bean.setId(rs.getInt(1));
	    	bean.setRollno(rs.getInt(2));
	    	bean.setName(rs.getString(3));
	    	bean.setPhysics(rs.getInt(4));;
	    	bean.setChemestry(rs.getInt(5));
	    	bean.setMaths(rs.getInt(6));
	    	list.add(bean); 	
	    	
	    }
	  
		
		return list;
		
	}

}
