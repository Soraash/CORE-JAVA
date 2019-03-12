package CRUD;

import java.util.List;
import java.util.Scanner;

import dao.CommentPostDAOImpl;
import model.Comment;
import model.Post;

public class CommentCRUD {

	public static void main(String[] args) 
	{
		CommentPostDAOImpl dao1=new CommentPostDAOImpl();
		Scanner s = new Scanner(System.in);

		int doFlag = -1;

		do {
			System.out.println("1.Insert\n2.edit\n3.Delete\n4.View All comments\n5.Search a comment");
			int ch1 = s.nextInt();
			s.nextLine();
			switch (ch1) {
			case 1:

				System.out.println("Enter comment body");
				Comment comment = new Comment(0, s.nextLine());

				int res = dao1.insert(comment);

				System.out.println("Rows inserted=" + res);

				break;

			case 2:
				System.out.println("Enter c_id of the comment to be updated");
				int id = s.nextInt();
				s.nextLine();
				System.out.println("Enter  body of the comment to be updated");

				res = dao1.update(new Comment(id, s.nextLine()));

				System.out.println("Rows updated=" + res);
				break;

			case 3:
				System.out.println("Enter id of the comment to be deleted");
				id = s.nextInt();
				s.nextLine();
				res = dao1.delete(id);
				System.out.println("Rows deleted=" + res);
				break;

			case 4:

				List<Comment> list = dao1.view();

				for (Comment p : list) {
					System.out.println(p);
				}

				break;

			case 5:
				System.out.println("Enter id of the Post to be searched");
				id = s.nextInt();
				s.nextLine();
				comment = dao1.view(id);
				System.out.println(comment);
				break;

			default:
				System.out.println("Invalid Input Choice");
			}

			System.out.println("RE RUN ? 1.YES\t2.NO");
			doFlag = s.nextInt();
			s.nextLine();

		} while (doFlag == 1);

	}
	}


