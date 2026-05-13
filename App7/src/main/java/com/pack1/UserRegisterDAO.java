package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO {
	public int insert_UserData(UserBean ub) {
		int rowCount =0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
			pstmt.setString(1, ub.getuName());
			pstmt.setString(2, ub.getPassword());
			pstmt.setString(3,ub.getFirstName() );
			pstmt.setString(4, ub.getLastName());
			pstmt.setString(5, ub.getMailId());
			pstmt.setString(6, ub.getPhoneNumber());
			
			rowCount = pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return rowCount;
	}
}
