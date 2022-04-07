package com.openclassrooms.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Read - Get all employees
	 * 
	 * @return - An Iterable object of Employee full filled
	 */
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * Read - Get one employee
	 * 
	 * @param id The id of the employee
	 * @return - An Employee object full filled
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") final Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete one employee
	 * 
	 * @param id The id of the employee
	 * @return - void
	 */
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		employeeService.deleteEmployee(id);
		;
	}

	/**
	 * Create - Add a new employee
	 * 
	 * @param employee An object employee
	 * @return The employee object saved
	 */
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	/**
	 * Update - Update an existing employee
	 * 
	 * @param employee An object employee
	 * @return The employee object saved
	 */
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
		Optional<Employee> e = employeeService.getEmployee(id);
		if (e.isPresent()) {
			Employee currentEmployee = e.get();

			if (employee.getFirstName() != null) {
				currentEmployee.setFirstName(employee.getFirstName());
			}

			if (employee.getLastName() != null) {
				currentEmployee.setLastName(employee.getLastName());
			}

			if (employee.getMail() != null) {
				currentEmployee.setMail(employee.getMail());
			}

			if (employee.getPassword() != null) {
				currentEmployee.setPassword(employee.getPassword());
			}
			return employeeService.saveEmployee(currentEmployee);
		}
		return null;
	}

}