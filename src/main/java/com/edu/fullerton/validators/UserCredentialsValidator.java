package com.edu.fullerton.validators;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.FacesValidator;
import javax.servlet.http.HttpServletRequest;

import com.edu.fullerton.dao.UserDao;
import com.edu.fullerton.errors.ErrorAndMessages;

@ManagedBean(name = "home", eager = true)
@SessionScoped
@FacesValidator("com.edu.fullerton.validators.UserCredentialsValidator")
public class UserCredentialsValidator{
	

	public UserCredentialsValidator() {
		System.out.println("Website Startedd");
	}

	public String getMessage() {
		return "hiiii";
	}

	public static void checkCredentials(String userName, String password, HttpServletRequest req) {
		ErrorAndMessages em = new ErrorAndMessages();
		if(userName == null || userName == ""){			
			em.addError("User Name cannot be empty");
		}else if(password == null || password == ""){			
			em.addError("Password cannot be empty");
		}else{
			UserDao obj = new UserDao();
			if(obj !=  null){
				if(req.getParameter("action") == "signUp"){
					Boolean stored =obj.storeUserIntoDB(userName,password);
					if(null != stored && stored == true){
						em.addMessage("Sign Up successful");
					}else if(null != stored && stored == false){
						em.addError("Server Down!! database Connection Failed");
					}else{
						em.addError("Sorry Somebody already took that username");
					}
				}else{
					Boolean stored =obj.checkUserValid(userName,password);
				}
				
			}else{
				em.addError("Server Down!! database Connection Failed");
			}
		}
		ErrorAndMessages.serErrorsAndMessages(req,em);
	}
	
	public String getResult(){		
		return null;
	}
}
