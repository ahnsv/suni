package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.schedule.repository.ScheduleRepository;
import dev.humphrey.suni.domain.tutor.entity.Tutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> listScheduleByTutor(Tutor tutor) {
        return scheduleRepository.findAllByTutor(tutor);
    }

    @Override
    public Long createSchedule(Schedule schedule) {
        var nextSchedule = scheduleRepository.save(schedule);
        return nextSchedule.getId();
    }
}
