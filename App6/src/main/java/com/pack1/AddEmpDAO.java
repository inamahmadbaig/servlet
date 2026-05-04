package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddEmpDAO {
	
	public int insertEmpData(EmpBean eb) {
		int rowCount =0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			pstmt.setString(1, eb.geteId());
			pstmt.setString(2, eb.geteFName());
			pstmt.setString(3, eb.geteLName());
			pstmt.setInt(4, eb.geteSal());
			pstmt.setString(5, eb.geteAdd());
			
			rowCount = pstmt.executeUpdate();
		}
		catch (SQLIntegrityConstraintViolationException s) {
			System.out.println("Duplicate emoId not allowed");
			s.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
				
	}
}
