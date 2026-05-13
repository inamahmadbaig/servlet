package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {
	public int updateProfile(UserBean ub) {
		int rowCount =0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("update registration set firstname=?,lastname=?,mailid=?,phone=? where username=?");
			pstmt.setString(1, ub.getFirstName());
			pstmt.setString(2, ub.getLastName());
			pstmt.setString(3, ub.getMailId());
			pstmt.setString(4, ub.getPhoneNumber());
			pstmt.setString(5, ub.getuName());
			
			rowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
