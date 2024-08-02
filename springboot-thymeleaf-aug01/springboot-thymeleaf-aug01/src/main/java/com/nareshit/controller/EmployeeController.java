package com.nareshit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nareshit.entity.Employee;
import com.nareshit.form.EmployeeForm;
import com.nareshit.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public String getAllEmployee(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "show_all_employees";
	}
	
	@GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model){
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setSalary(100D);
        model.addAttribute("employee", employeeForm);
        return "add_employee";
    }
	
	@GetMapping("/getEmployeeForUpdate/{id}")
    public String getEmployeeForUpdate(@PathVariable(value = "id") Integer id, Model model){
        Employee emp = employeeService.getEmployee(id);
        EmployeeForm employeeForm = EmployeeForm.builder()
        		.id(emp.getId())
        		.name(emp.getName())
        		.address(emp.getAddress())
        		.salary(emp.getSalary())
        		.build();
        model.addAttribute("employee", employeeForm);
        return "update_employee";
    }
	
	@PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeForm employeeForm ){
        Employee employee = Employee.builder()
        		
                .name(employeeForm.getName())
                .address(employeeForm.getAddress())
                .salary(employeeForm.getSalary())
                .build();
        employeeService.saveEmployee(employee);
        return "redirect:/getAllEmployees";
    }
	
	@PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") EmployeeForm employeeForm ){
        Employee employee = Employee.builder()
                .id(employeeForm.getId())
        		.name(employeeForm.getName())
                .address(employeeForm.getAddress())
                .salary(employeeForm.getSalary())
                .build();
        employeeService.updateEmployee(employee);
        return "redirect:/getAllEmployees";
    }
	@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/getAllEmployees";
    }
}
