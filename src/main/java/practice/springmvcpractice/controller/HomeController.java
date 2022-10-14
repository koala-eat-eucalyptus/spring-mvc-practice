package practice.springmvcpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.springmvcpractice.repository.EmployeeRepository;

@Controller
public class HomeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public HomeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("list", employeeRepository.getEmployee("123456789"));
        return "index";
    }
}
