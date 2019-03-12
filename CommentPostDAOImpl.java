package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Post;

public class CommentPostDAOImpl implements CommentPostDAO
{
	private static Connection con;
	static 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Comment Comment) {
		
		int res = -1;
		try {
			String sql ="insert into comment(c_id,comment_body) values(?,?)";
	    	PreparedStatement pst=con.prepareStatement(sql);
	    	pst.setInt(1, Comment.getC_id());
			pst.setString(2, Comment.getComment_body());
	    	 res=pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Comment Comment) {
		
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update comment set  comment_body = ? where c_id = ?");
			pst.setString(1, Comment.getComment_body());
			pst.setInt(2, Comment.getC_id());
			res = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int id) {
		
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from comment where c_id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Comment> view() {
		List<Comment> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from comment");
			while (rs.next()) {
				list.add(new Comment(rs.getInt(1), rs.getString(2)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return list;
		
	}

	@Override
	public Comment view(int id) {
		
		Comment comment = new Comment();
		try {
			PreparedStatement pst = con.prepareStatement("select * from comment where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				comment = new Comment(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment;
	}

	

	
	

}
