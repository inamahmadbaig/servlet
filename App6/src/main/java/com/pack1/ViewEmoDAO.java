package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewEmoDAO {
	ArrayList<EmpBean> al = new ArrayList<EmpBean>();
	
	public ArrayList<EmpBean> reterive_empData() {
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpBean eb = new EmpBean();
				eb.seteId(rs.getString(1));
				eb.seteFName(rs.getString(2));
				eb.seteLName(rs.getString(3));
				eb.seteSal(rs.getInt(4));
				eb.seteAdd(rs.getString(5));
				
				al.add(eb);
			}
		}
		catch(Exception e) {
			System.out.println("Problem Occured at ==> viewEmpDAO");
			e.printStackTrace();
		}
		return al;
	}
}
