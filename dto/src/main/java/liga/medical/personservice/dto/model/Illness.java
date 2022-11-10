package liga.medical.personservice.dto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private MedicalCard medicalCard;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private char heaviness;

    @Column(name = "appearance_dttm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appearanceDttm;

    @Column(name = "recovery_dt")
    @Temporal(TemporalType.DATE)
    private  Date recoveryDt;

}
