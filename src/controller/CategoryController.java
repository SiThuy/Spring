package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Author;
import model.Category;
import model.CategoryRepository;
import model.Repository;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	CategoryRepository repository = new CategoryRepository();

	@RequestMapping("index.html")
	public String index(Model model) {
		model.addAttribute("list", repository.getCategorys());
		return "category.index";
	}

	/* ADD */
	@RequestMapping("add.html")
	public String add(Model model) {
		List<Category> list = repository.getCategorys();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new Category());
		return "category.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Model model, Category obj) {
		repository.add(obj);
		return "redirect:/admin/category/index.html";
	}

	/* EDIT */
	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		List<Category> list = repository.getCategorys();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", repository.getCategory(id));
		return "category.edit";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Category obj, @PathVariable("id") int id) {
		repository.edit(obj);
		return "redirect:/admin/category/index.html";
	}

}
