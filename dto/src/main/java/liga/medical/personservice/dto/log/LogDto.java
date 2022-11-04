package liga.medical.personservice.dto.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {

    private String id;
    private LocalDateTime date;
    private String level;
    private String username;

}
