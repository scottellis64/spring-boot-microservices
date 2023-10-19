package com.sellis.employee.service;

import com.sellis.employee.entity.Employee;
import com.sellis.employee.feignclient.AddressClient;
import com.sellis.employee.repository.EmployeeRepo;
import com.sellis.employee.response.AddressResponse;
import com.sellis.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Description
 *
 * @author sellis
 */
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    private final ModelMapper mapper;

    private final AddressClient addressClient;

    public EmployeeService(
            EmployeeRepo employeeRepo,
            ModelMapper mapper,
            AddressClient addressClient
    ) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
        this.addressClient = addressClient;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddress(addressResponse.getBody());

        return employeeResponse;
    }
}
