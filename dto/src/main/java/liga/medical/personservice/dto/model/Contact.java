package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact", schema = "medical")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonData personData;

}
