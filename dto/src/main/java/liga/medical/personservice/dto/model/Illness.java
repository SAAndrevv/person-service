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
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id")
    private MedicalCard medicalCard;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private char heaviness;

    @Column(name = "appearance_dttm")
    private Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private  Date recoveryDt;

}
