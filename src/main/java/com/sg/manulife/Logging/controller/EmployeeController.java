package com.sg.manulife.Logging.controller;

import com.sg.manulife.Logging.model.Employee;
import com.sg.manulife.Logging.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

 @GetMapping("employee/{id}")
  public Employee getEmployeeDetail(@PathVariable("id") int id) {
   System.out.println("id:"+id);
   return employeeService.getEmployeeDetail(id);
 }
}
