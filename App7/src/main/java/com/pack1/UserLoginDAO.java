 package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO {

	public UserBean login(String userName,String password) {
		UserBean ub = null;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("select * from registration where username=? and password=?");
		
			pstmt.setString(1, userName);
			pstmt.setString(2, password); 
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ub= new UserBean();
				ub.setuName(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setFirstName(rs.getString(3));
				ub.setLastName(rs.getString(4));
				ub.setMailId(rs.getString(5));
				ub.setPhoneNumber(rs.getString(6));
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception occured in User Login DAO");
			e.printStackTrace();
		}
		return ub;
	}
}
