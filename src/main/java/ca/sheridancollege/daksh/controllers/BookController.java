package ca.sheridancollege.daksh.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.daksh.beans.Book;
import ca.sheridancollege.daksh.database.DatabaseAccess;
import ca.sheridancollege.daksh.beans.Review;

@Controller
public class BookController 
{
	@Autowired
	public DatabaseAccess database;
	
	@GetMapping("/")
	public String indexPage(Model model) 
	{
		
		model.addAttribute("bookList", database.getBookList());
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String logedInPage()
	{
		return "redirect:/";
	}
	
	@GetMapping("/ReviewsById/{id}")
	public String viewReviewPage(Model model, @PathVariable Long id) {
	    Book book = database.getBookById(id);
	    List<String> reviews = database.getReviewsByBookId(id);
	    model.addAttribute("book", book);
	    model.addAttribute("reviews", reviews);
	    model.addAttribute("id",id);
	    return "view-book";
	}
	
	@GetMapping("/register")
	public String registerPage() 
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String postMethod(@RequestParam String email,
			                 @RequestParam String password)
	{
		database.addUser(email, password);
		Long userId=database.findUserAccount(email).getUserid();
		database.addRole(userId, Long.valueOf(2));
		return "redirect:/";
	}
	
	@GetMapping("/permissionDenied") //contex path=localhost:8080/permissionDenied
	public String permDenied()
	{
		return "/error/permissionDenied";
	}
	
	@GetMapping("/addReviewById/{id}")
	public String addReviewById(@PathVariable Long id, Model model) {
	    model.addAttribute("bookId", id);
	    return "user/add-review";
	}
	
	@PostMapping("/addReview")
	public String addReview(@ModelAttribute Review review, Model model) {
		database.addReview(review);
		model.addAttribute("bookId", review.getBookId());
		return "redirect:/ReviewsById/" + review.getBookId();
	}
	
	@GetMapping("/addBook")
	public String addBookPage() {
	    return "/admin/add-book";
	}
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book book, Model model) {
		database.addBook(book);
		return "redirect:/";
	}
}
