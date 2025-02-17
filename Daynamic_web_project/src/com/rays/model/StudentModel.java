package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.StudentBean;
import com.rays.util.JDBCDataSource;

public class StudentModel {

	public int nextpk() throws SQLException, Exception {
		int pk = 0;
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select max(id) from student");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = pk + rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(StudentBean bean) throws SQLException, Exception {

		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?,?,?)");

		pstmt.setInt(1, nextpk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getSubject());
		pstmt.setString(4, bean.getCollage());
		pstmt.setString(5, bean.getAddress());
		pstmt.executeUpdate();

		System.out.println("insert data sucecessfully");

	}

	public List search(StudentBean bean) throws SQLException, Exception {

		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from student");
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSubject(rs.getString(3));
			bean.setCollage(rs.getString(4));
			bean.setAddress(rs.getString(5));
			list.add(bean);
		}
		return list;

	}
	
	public void delete(int id) throws SQLException, Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from student where id = ?");
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
	}
}
