package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private long id;
    private Contact contactId;
    private long countryId;
    private String city;
    private int index;
    private String street;
    private String buildings;
    private String flat;

}
