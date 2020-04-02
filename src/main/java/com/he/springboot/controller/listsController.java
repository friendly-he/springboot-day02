package com.he.springboot.controller;

import com.he.springboot.damain.Department;
import com.he.springboot.damain.Employee;
import com.he.springboot.dao.DepartmentDao;
import com.he.springboot.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class listsController {
    @Autowired
    private DepartmentDao department;
    @Autowired
    private EmployeeDao employeeDao;

//用户连表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);

        return "list";
    }
//添加用户
    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //用户属性添加到model
    @GetMapping("/emp")
    public String toaddpage(Model model){
        Collection<Department> departments = department.getDepartments();
        model.addAttribute("depts",departments);
        return "add";

    }
    //用户修改回显
    @GetMapping("/emp/{id}")
    public String toedit(@PathVariable("id")int id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("toedit",employee);
        //部门列表
        Collection<Department> departments = department.getDepartments();
        model.addAttribute("depts",departments );
        return "add";
    }

    @PutMapping("/emp")
    public String toedint2(Employee employee){

        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @GetMapping("/dele/{id}")
    public String delect(@PathVariable("id")int id){
        System.out.println("id");
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
