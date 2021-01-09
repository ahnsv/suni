package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.tutor.entity.Tutor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface ScheduleService {
    List<Schedule> listScheduleByTutor(Tutor tutor);

    @Transactional
    UUID createSchedule(Schedule schedule);


//    @Transactional
//    void updateSchedule(UUID id, Schedule schedule);

    @Transactional
    void deleteScheduleByID(UUID id);
}
