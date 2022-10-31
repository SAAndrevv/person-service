package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonData {

    private long id;
    private String lastName;
    private String firstName;
    private Date birthDt;
    private short age;
    private char sex;
    private Contact contactId;
    private MedicalCard medicalCardId;
    private long parentId;

}
