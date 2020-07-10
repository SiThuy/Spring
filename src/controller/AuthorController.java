package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import model.Author;
import model.AuthorRepository;
import model.Member;
import model.MemberRepository;

@Controller
@RequestMapping("admin/author")
public class AuthorController {
	AuthorRepository repository = new AuthorRepository();
	

	/* VIEW */
	@RequestMapping("index.html")
	public String index(Model model) {
		model.addAttribute("list", repository.getAuthors());
		return "author.index";
	}

	/* ADD */
	@RequestMapping("add.html")
	public String add() {
		return "author.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Author obj) {
		repository.add(obj);
		return "redirect:/admin/author/index.html";
	}

	/* EDIT */
	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("o", repository.getAuthor(id));
		return "author.edit";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Author obj, @PathVariable("id") int id) {
		repository.edit(obj);
		return "redirect:/admin/author/index.html";
	}

	/* DELETE */
	@RequestMapping("del.html/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(id);
		return "redirect:/admin/author/index.html";
	}

	/* MULTI DELETE */
	@RequestMapping(value = "dels.html", method = RequestMethod.POST)
	public String delete(@RequestParam("ids") List<Integer> list) {
		repository.delete(list);
		return "redirect:/admin/author/index.html";
	}

	
	
}
