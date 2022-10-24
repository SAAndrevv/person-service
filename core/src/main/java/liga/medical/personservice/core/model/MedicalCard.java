package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCard {

    private long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDt;
    private String comment;

}
