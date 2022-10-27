package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Illness {

    private long id;
    private MedicalCard medicalCardId;
    private long typeId;
    private char heaviness;
    private Timestamp appearanceDttm;
    private  Date recoveryDt;

}
