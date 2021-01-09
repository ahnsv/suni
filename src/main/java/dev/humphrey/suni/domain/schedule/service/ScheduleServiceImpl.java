package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.schedule.repository.ScheduleRepository;
import dev.humphrey.suni.domain.tutor.entity.Tutor;
import dev.humphrey.suni.interfaces.api.tutor.TutorApiDto;
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
    public UUID createSchedule(Schedule schedule) {
        var nextSchedule = scheduleRepository.save(schedule);
        return nextSchedule.getId();
    }

//    @Override
//    public void updateSchedule(UUID id, Schedule nextSchedule) {
//        var selectedSchedule = scheduleRepository.findById(id);
//        selectedSchedule.stream().
//    }


    @Override
    public void deleteScheduleByID(UUID id) {
        scheduleRepository.deleteById(id);
    }
}
