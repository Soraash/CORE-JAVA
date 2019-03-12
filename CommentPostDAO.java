package dao;

import java.util.List;

import model.Comment;
import model.Post;

public interface CommentPostDAO {
	//int insert(Post post);
	//int update(Post post);
	//int delete(int id);
	
	//Comment view(int id);
	int update(Comment Comment);
	int insert(Comment Comment);
	int delete(int id);
	List<Comment> view();
	Comment view(int id);
}
