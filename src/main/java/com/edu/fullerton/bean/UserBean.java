package com.edu.fullerton.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.fullerton.validators.UserCredentialsValidator;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean implements Serializable{
	private String userName;
	private String password;	
	
	public UserBean(String username,String password){
		this.userName=username;
		this.password=password;
	}
	public UserBean(){}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void submit(){
		String result = "Submitted values: " + userName + ", " + password;
        System.out.println(result);
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        UserCredentialsValidator.checkCredentials(userName,password,req);
	}
}
