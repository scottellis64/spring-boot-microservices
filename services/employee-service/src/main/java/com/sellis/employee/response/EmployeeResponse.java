package com.sellis.employee.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author sellis
 */
@Data
@NoArgsConstructor
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private String age;

    private AddressResponse address;
}
