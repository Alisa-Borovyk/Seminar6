package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private IFilterService filterService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/filter/grades/student/1
	public String getControllerfilter1(@PathVariable(name="id") int id, Model model) {
		
		try {
			System.out.println(filterService.filterGradeByStudentId(id));
		model.addAttribute("box",filterService.filterGradeByStudentId(id));
		return "show-multiple-grades-page";
		}
		
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			
			return "error-page";
		}
	}


}
