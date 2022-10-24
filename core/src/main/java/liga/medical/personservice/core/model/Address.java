package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private long id;
    private long contactId;
    private long countryId;
    private String city;
    private int index;
    private String street;
    private String buildings;
    private String flat;

}
