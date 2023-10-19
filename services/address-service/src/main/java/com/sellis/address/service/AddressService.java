package com.sellis.address.service;

import com.sellis.address.entity.Address;
import com.sellis.address.repository.AddressRepo;
import com.sellis.address.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Description
 *
 * @author sellis
 */
@Service
public class AddressService {
    private final AddressRepo addressRepo;

    private final ModelMapper mapper;

    public AddressService(AddressRepo addressRepo, ModelMapper mapper) {
        this.addressRepo = addressRepo;
        this.mapper = mapper;
    }

    public AddressResponse findAddressByEmployeeId(int id) {
        Optional<Address> address = addressRepo.findById(id);
        return mapper.map(address, AddressResponse.class);
    }
}
