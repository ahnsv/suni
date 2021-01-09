package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.schedule.repository.ScheduleRepository;
import dev.humphrey.suni.domain.tutor.entity.Tutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface ScheduleService {
    List<Schedule> listScheduleByTutor(Tutor tutor);
    @Transactional
    UUID createSchedule(Schedule schedule);
}
