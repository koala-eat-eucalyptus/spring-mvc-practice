package practice.springmvcpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.springmvcpractice.repository.DependentRepository;
import practice.springmvcpractice.repository.EmployeeRepository;

@Controller
public class HomeController {

    private final EmployeeRepository employeeRepository;
    private final DependentRepository dependentRepository;

    @Autowired
    public HomeController(EmployeeRepository employeeRepository, DependentRepository dependentRepository) {
        this.employeeRepository = employeeRepository;
        this.dependentRepository = dependentRepository;
    }


    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("list", employeeRepository.getAllEmployee());
        model.addAttribute("list2", dependentRepository.getDependent("333445555", "Joy"));

        return "index";
    }


}
