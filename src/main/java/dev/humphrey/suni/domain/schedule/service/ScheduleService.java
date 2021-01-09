package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.tutor.entity.Tutor;

import javax.transaction.Transactional;
import java.util.List;

public interface ScheduleService {
    List<Schedule> listScheduleByTutor(Tutor tutor);

    @Transactional
    Long createSchedule(Schedule schedule);
}
