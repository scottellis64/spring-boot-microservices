package com.sellis.employee.feignclient;

import com.sellis.employee.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description
 *
 * @author sellis
 */
@FeignClient(name = "address-service", path = "/address-service")
public interface AddressClient {
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);
}
