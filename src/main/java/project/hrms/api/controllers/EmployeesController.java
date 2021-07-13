package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.EmployeeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


//	@PostMapping("/add")
//	public Result add(@RequestBody Employee employee){
//		return this.employeeService.add(employee);
//	}
//
//	@PostMapping("/update")
//	public Result update(@RequestBody Employee employee){
//		return this.employeeService.update(employee);
//	}
//
//	@PostMapping("/delete")
//	public Result delete(@RequestParam("id") int id){
//		return this.employeeService.delete(id);
//	}
//
//	@GetMapping("/getbyid")
//	public DataResult<Employee> getById(@RequestParam("id") int id){
//		return this.employeeService.getById(id);
//	}

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }
}