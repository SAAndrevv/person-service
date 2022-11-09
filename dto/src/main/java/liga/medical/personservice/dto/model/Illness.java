package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "illness", schema = "medical")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;
    private long typeId;
    private char heaviness;
    private Timestamp appearanceDttm;
    private  Date recoveryDt;

}
