package com.edu.fullerton.bean;

public class CommentsBean {
	private String comments;
	private String commentedBy;
	
	
	public CommentsBean(String userName, String comments2) {
		this.comments=comments2;
		this.commentedBy=userName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}
}
