package practice.springmvcpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.springmvcpractice.repository.DependentRepository;
import practice.springmvcpractice.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

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
//        model.addAttribute("dependentList", dependentRepository.getDependent("333445555", "Joy"));

        return "index";
    }

    @PostMapping("/hire")
    public String hire(@RequestParam Map<String, Object> employeeMap) {
        employeeRepository.hireEmployee(employeeMap.values().toArray());
        return "redirect:/";
    }

    @PostMapping("/fire")
    public String fire(@RequestParam MultiValueMap<String, Object> employeeMap) {
        String ssn = (String) new ArrayList<>(employeeMap.values()).get(0).get(0);
        employeeRepository.fireEmployee(ssn);
//        // 콘솔에 찍어보기
//        System.out.println(ssn);
//        employeeMap.values().stream().collect(toCollection(ArrayList::new)).get(0).get(0);
        return "redirect:/";
    }
}
