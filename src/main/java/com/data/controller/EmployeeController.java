package com.data.controller;

import com.data.entity.Department;
import com.data.entity.Employee;
import com.data.repository.DepartmentRepository;
import com.data.repository.EmployeeRepository;
import com.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @GetMapping("employee_list")
    public String getEmployee(Model model){
        List<Employee> employees = employeeService.getAll();
        List<Department> departments= departmentRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("departments", departments);
//        model.addAttribute("name", "ngoc 2");
        return "employee_list";
    }
    @GetMapping("employee-delete/{id}")
    public String delete(@PathVariable int id){
        Employee employee= employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return "redirect:/employee_list";

    }
    @GetMapping("employee_add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("department", departmentRepository.findAll());
        return "employee_add";
    }
    @PostMapping("employee_save")
    public String save(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee_list";
    }
    @GetMapping("department-delete/{id}")
    public String deleteDepartment(@PathVariable int id){
        Department department = departmentRepository.findById(id).get();
        departmentRepository.delete(department);
        return "redirect:/employee_list";
    }
    @GetMapping("department_add")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "department_add";
    }
    @PostMapping("department_save")
    public String save(@ModelAttribute Department department){
        departmentRepository.save(department);
        return "redirect:/employee_list";
    }

}
