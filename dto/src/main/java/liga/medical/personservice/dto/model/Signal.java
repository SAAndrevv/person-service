package liga.medical.personservice.dto.model;

import liga.medical.commonmodule.dto.enums.RabbitMessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "signal", schema = "medical")
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_data_id")
    private PersonData personData;

    @Column(name = "description")

    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RabbitMessageType type;

    public Signal(PersonData personData, String description, RabbitMessageType rabbitMessageType) {
        this.personData = personData;
        this.description = description;
        this.type = rabbitMessageType;
    }

}
