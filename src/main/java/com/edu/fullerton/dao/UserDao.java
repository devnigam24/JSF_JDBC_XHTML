package com.edu.fullerton.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.edu.fullerton.errors.ErrorAndMessages;

public class UserDao extends RedditDao{
	
	public UserDao(){
		super.createConnection();
	}

	public Boolean storeUserIntoDB(String userName, String password) {
		if (super.createUsertable() >= 0) {
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO ALLUSERS (USERNAME,PASSWORD) VALUES (?,?)");
				ps.setString(1,userName);
				ps.setString(2,password);
				ps.executeUpdate();
				return true;				
			} catch (SQLException e) {
				if(e instanceof SQLIntegrityConstraintViolationException){
					e.printStackTrace();
					return null;
				}else{
					e.printStackTrace();
					return false;
				}				
			}finally{try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return false;
	}

	public Boolean checkUserValid(String userName, String password) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT PASSWORD FROM ALLUSERS WHERE USERNAME='"+userName+"'");
			ResultSet set = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	}	

}
