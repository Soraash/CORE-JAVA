package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAOImpl  implements PostDAO {
		
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
	public int insert(Post post) 
	{
		int res = -1;
		try {
			String sql ="insert into post(title,body) values(?,?)";
	    	PreparedStatement pst=con.prepareStatement(sql);
	    	pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
	    	 res=pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Post post) 
	{
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update post set title = ?, body = ? where id = ?");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			pst.setInt(3, post.getId());
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
			PreparedStatement pst = con.prepareStatement("delete from post where id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Post> view() {
		
		ArrayList<Post> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from post");
			while (rs.next()) {
				list.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Post view(int id) 
	{
		Post post = new Post();
		try {
			PreparedStatement pst = con.prepareStatement("select * from post where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
		
		
	}

}
