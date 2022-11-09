package liga.medical.personservice.core.service;

import liga.medical.commonmodule.dto.enums.RabbitMessageType;
import liga.medical.commonmodule.dto.rabbit.RabbitMessageDto;
import liga.medical.commonmodule.service.annotation.DBLog;
import liga.medical.personservice.api.service.PersonDataService;
import liga.medical.personservice.core.repository.SignalRepository;
import liga.medical.personservice.dto.model.PersonData;
import liga.medical.personservice.dto.model.Signal;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@EnableRabbit
@Component
@RequiredArgsConstructor
public class RabbitListenerService {

    private final SignalRepository repository;

    private final PersonDataService personDataService;

    @RabbitListener(queues = "daily_queue")
    @DBLog
    public void processDailyQueue(RabbitMessageDto message) {
        saveMessage(message);
        //System.out.println("Get message from daily_queue: " + message.getMessage());
    }

    @RabbitListener(queues = "alert_queue")
    @DBLog
    public void processAlertQueue(RabbitMessageDto message) {
        saveMessage(message);
        //System.out.println("Get message from alert_queue: " + message.getMessage());
    }

    private void saveMessage(RabbitMessageDto message) {
        Optional<PersonData> personData = personDataService.getPersonDataByUserId(message.getId());
        personData.ifPresent(data -> repository.save(new Signal(data,
                message.getMessage(),
                RabbitMessageType.valueOf(message.getType().toUpperCase()))));
    }

}
