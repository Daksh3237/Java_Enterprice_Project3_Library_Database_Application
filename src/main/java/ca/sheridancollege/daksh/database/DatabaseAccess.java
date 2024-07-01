package ca.sheridancollege.daksh.database;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.daksh.beans.Book;
import ca.sheridancollege.daksh.beans.User;
import ca.sheridancollege.daksh.beans.Review;



@Repository
public class DatabaseAccess {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public List<Book> getBookList()
	{
		MapSqlParameterSource namedParam=new MapSqlParameterSource();
		String str1="SELECT*FROM books;";
		ArrayList<Book> bookList=(ArrayList<Book>)jdbc.query(str1, namedParam,new BeanPropertyRowMapper<Book>(Book.class));
		return bookList;
	}
	
	public Book getBookById(Long id) {
	    MapSqlParameterSource namedParam = new MapSqlParameterSource();
	    String str2 = "SELECT * FROM books WHERE id = :id";
	    namedParam.addValue("id", id);
	    return jdbc.queryForObject(str2, namedParam, new BeanPropertyRowMapper<>(Book.class));
	}
	
	public List<String> getReviewsByBookId(Long id) {
	    MapSqlParameterSource namedParam = new MapSqlParameterSource();
	    String str3 = "SELECT text FROM reviews WHERE bookId = :id";
	    namedParam.addValue("id", id);
	    return jdbc.queryForList(str3, namedParam, String.class);
	}
	
	public void addUser(String email,String password)
	{
		MapSqlParameterSource namedParam=new MapSqlParameterSource();
		String str4="INSERT INTO users(email,encryptedpassword,enabled) VALUES(:email,:encryptedpassword,true);";
		namedParam.addValue("email", email);
		namedParam.addValue("encryptedpassword",passwordEncoder.encode(password));
		jdbc.update(str4, namedParam);
	}
	
	public void addRole(long userId,long roleId)
	{
		MapSqlParameterSource namedParam=new MapSqlParameterSource();
		String str5="INSERT INTO user_role(userId,roleId) VALUES(:user,:role);";
		namedParam.addValue("user",userId);
		namedParam.addValue("role",roleId);
		jdbc.update(str5, namedParam);
	}
	
	public User findUserAccount(String email)
	{
		MapSqlParameterSource namedParam=new MapSqlParameterSource();
		String str6="SELECT * FROM users WHERE email=:email;";
		namedParam.addValue("email", email);
		try
		{
			return jdbc.queryForObject(str6, namedParam, new BeanPropertyRowMapper<User>(User.class));
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	public List<String> getRolesById(Long userid)
	{
		MapSqlParameterSource namedParam=new MapSqlParameterSource();
		String str7="SELECT roles.rolename FROM roles,user_role WHERE roles.roleid=user_role.roleid AND userid=:userid;";
		namedParam.addValue("userid", userid);
		return jdbc.queryForList(str7, namedParam, String.class);
	}
	
	public void addReview(Review review) {
		String str8 = "INSERT INTO reviews(text, bookId) VALUES (:text, :bookId)";
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		namedParam.addValue("text", review.getText());
		namedParam.addValue("bookId", review.getBookId());
		jdbc.update(str8, namedParam);
	}
	
	public void addBook(Book book) {

		String str9 = "INSERT INTO books(title, author) VALUES (:title, :author)";
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		namedParam.addValue("title", book.getTitle());
		namedParam.addValue("author", book.getAuthor());
		jdbc.update(str9, namedParam);
	}
	
	
}
