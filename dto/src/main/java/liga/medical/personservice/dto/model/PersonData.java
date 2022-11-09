package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person_data", schema = "medical")
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_dt")
    private Date birthDt;

    @Column(name = "age")
    private short age;

    @Column(name = "sex")
    private char sex;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private PersonData parent;

    @OneToMany(mappedBy = "personData")
    private Set<Signal> signals;

}