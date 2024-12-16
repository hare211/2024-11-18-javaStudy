package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dept extends Database{
	// driverConfig(), getConnection() => 사용 가능하면 그대로 사용
	// listPrint(), findPrint();

	@Override
	public void listPrint() {
		driverConfig();
		Connection conn = getConnection();
		try {
			// 오라클 전송
			String sql = "SELECT * FROM dept";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getInt(1)
						+ rs.getString(2)
						+ rs.getString(3));
			}
		} catch (Exception ex) {}
	}

	@Override
	public void findPrint() {
		// TODO Auto-generated method stub
		
	}
	
}
