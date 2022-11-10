package liga.medical.personservice.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address", schema = "medical")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @Column(name = "country_id")
    private long countryId;

    @Column(name = "city")
    private String city;

    @Column(name = "index")
    private int index;

    @Column(name = "street")
    private String street;

    @Column(name = "buildings")
    private String buildings;

    @Column(name = "flat")
    private String flat;

}
