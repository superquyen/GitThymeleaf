package com.data.controller;

import com.data.entity.Department;
import com.data.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DepartmentController {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//    @GetMapping("department_list")
//    public String getDepartment(Model model){
//        List<Department>departments = departmentRepository.findAll();
//        model.addAttribute("departments", departments);
//        return "employee_list";
//    }
//    @GetMapping("department-delete/{id}")
//    public String deleteDepartment(@PathVariable int id){
//        Department department = departmentRepository.findById(id).get();
//        departmentRepository.delete(department);
//        return "redirect:/employee_list";
//    }
}
