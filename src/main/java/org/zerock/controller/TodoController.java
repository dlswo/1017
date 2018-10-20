package org.zerock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.OrderList;
import org.zerock.domain.StoreVO;
import org.zerock.domain.Todo;
import org.zerock.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")
@Log4j
@AllArgsConstructor
public class TodoController {
	
	private TodoService service;
	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
		
		return service.getStores(cat);
	}
	

	@GetMapping("/list2")
	@ResponseBody
	public ResponseEntity<List<Todo>> list2(){
		//return service.getList();
		return new ResponseEntity<List<Todo>>(service.getList(),
				HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("list...page");
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register");
	}
	
	@GetMapping("/exArray")
	public String exArray( String[] ids) {
		log.info(Arrays.toString(ids));
		return "todo/success";
	}
	
	@GetMapping("/order")
	public String order(OrderList list, Model model) {
		
		log.info(list);
		
		model.addAttribute("total", 3000);
		
		return "todo/success";
	}
	
	
	@PostMapping("/register")
	public String registerPost(Todo todo, 
			RedirectAttributes rttr) {
		log.info(todo);
		
		rttr.addFlashAttribute("result", "SUCCESS");
		
		return "redirect:/todo/list";
	}
}







