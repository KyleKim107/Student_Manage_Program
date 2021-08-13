package com.getarrarys.employeemanager;


import com.getarrarys.employeemanager.model.Employee;
import com.getarrarys.employeemanager.service.EmployeeService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {// employeeService에 있던 메소드들을 기준으로 API를 만들어준다? 불확실
    // HTTP request -> Controller -> Service -> DB

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Long id){
        Employee employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee ,HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee ,HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
