package practice.springmvcpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.springmvcpractice.repository.DependentRepository;
import practice.springmvcpractice.repository.EmployeeRepository;

import java.util.Map;

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
        model.addAttribute("employeeList", employeeRepository.getAllEmployee());
        model.addAttribute("dependentList", dependentRepository.getDependent("333445555", "Joy"));

        return "index";
    }

    @PostMapping("/hire")
    public String hire(@RequestParam Map<String, Object> employeeMap) {
        for(String key: employeeMap.keySet()) {
            System.out.println(key);
        }
//        System.out.println(employeeMap.get("fname"));
//        employeeRepository.hireEmployee("Pom", "E", "Pom", "135791357",
//                "2016-01-01", "dorm", "M", "12345",  "333445555", "5");
        return "redirect:/";
    }
}
