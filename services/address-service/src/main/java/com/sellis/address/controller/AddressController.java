package com.sellis.address.controller;

import com.sellis.address.response.AddressResponse;
import com.sellis.address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author sellis
 */
@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{id}")
    private ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id) {
        AddressResponse address = addressService.findAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
}
