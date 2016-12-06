package com.edu.fullerton.bean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.edu.fullerton.dao.UserDao;
import com.edu.fullerton.errors.ErrorAndMessages;

@ManagedBean(name = "postsBean", eager = true)
@RequestScoped
public class PostsBean {
	
	private String post;
	private String userName;
	private ArrayList<CommentsBean> comments;
	
	public PostsBean(){}
	
	public PostsBean(String post,String userName,ArrayList<CommentsBean> comments){
		this.post=post;
		this.userName=userName;
		this.comments=comments;
	}	
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<CommentsBean> getComments() {
		return comments;
	}
	public void setComments(ArrayList<CommentsBean> comments) {
		this.comments = comments;
	}
	
	public ArrayList<PostsBean> fetchAllPosts(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ErrorAndMessages em = new ErrorAndMessages();
		UserDao obj = new UserDao();
		if (obj != null) {
			return obj.fetchAllUsersPost();
		} else {
			em.addError("Server Down!! database Connection Failed");
			ErrorAndMessages.serErrorsAndMessages(req, em);
			return null;
		}
	}
}
