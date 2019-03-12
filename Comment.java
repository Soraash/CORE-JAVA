package model;

public class Comment 
{
	private int c_id;
	private String  comment_body;
	//private String delete_comment;
	 
	public Comment() {
		
	}
	
	public Comment(int c_id, String comment_body) {
		super();
		this.c_id = c_id;
		this.comment_body = comment_body;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getComment_body() {
		return comment_body;
	}

	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}

	@Override
	public String toString() {
		return "Comment [C_id=" + c_id + ", Comment_body=" + comment_body +  "]";
	}
}
