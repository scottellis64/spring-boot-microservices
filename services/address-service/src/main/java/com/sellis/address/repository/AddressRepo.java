package com.sellis.address.repository;

import com.sellis.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Description
 *
 * @author sellis
 */
public interface AddressRepo extends JpaRepository<Address, Integer> {
    @Query(nativeQuery = true,
           value = "SELECT ea.id, ea.city, ea.state FROM sbmicro.address ea join sbmicro.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
