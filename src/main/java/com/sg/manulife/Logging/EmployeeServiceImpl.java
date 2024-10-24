package com.sg.manulife.Logging;

import com.sg.manulife.Logging.exception.NoSuchEmployeeExistsException;
import com.sg.manulife.Logging.model.Employee;
import com.sg.manulife.Logging.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
  @Override
  public Employee getEmployeeDetail(int employeeId) {
      if(employeeId==123){
        log.info("employee Id: {}", employeeId);
        return getEmployee();
      } else {
        log.error("Not found employee with employeeId: {}", employeeId);
        throw new NoSuchEmployeeExistsException("Not found employee with employeeId: {}", String. valueOf(employeeId));
      }

  }
  public Employee getEmployee() {
    return new Employee("123", "Rajkumar", "Singh", "39", "rajkumar_singh@manulife.com", "Engineering Excellence");
  }
  }
