package liga.medical.personservice.core.service;

import liga.medical.personservice.core.repository.LogMapper;
import liga.medical.personservice.dto.log.LogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogMapper logMapper;

    public void saveLog(Supplier<LogDto> supplier) {
        logMapper.save(supplier.get());
    }

}
