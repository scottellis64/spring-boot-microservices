package com.sellis.address.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author sellis
 */
@Data
@NoArgsConstructor
public class AddressResponse {
    private int id;
    private String city;
    private String state;
}
