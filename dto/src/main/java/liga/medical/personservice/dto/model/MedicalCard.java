package liga.medical.personservice.dto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical_card", schema = "medical")
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_status")
    private String clientStatus;

    @Column(name = "med_status")
    private String medStatus;

    @Column(name = "registry_dt")
    @Temporal(TemporalType.DATE)
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "medicalCard", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Illness illness;

}
