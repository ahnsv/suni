package dev.humphrey.suni.application;

import dev.humphrey.suni.domain.schedule.entity.Schedule;
import dev.humphrey.suni.domain.schedule.service.ScheduleService;
import dev.humphrey.suni.domain.tutor.service.TutorAccountService;
import dev.humphrey.suni.domain.tutor.service.TutorService;
import dev.humphrey.suni.interfaces.api.tutor.TutorApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TutorFacade {
    private final TutorAccountService tutorAccountService;
    private final TutorService tutorService;
    private final ScheduleService scheduleService;

    public UUID createTutorAccount(TutorApiDto.TutorAccountForm accountFormDetail) {
        var createdUUID = tutorAccountService.createTutorAccount(accountFormDetail);
        log.info("Created UUID: {}", createdUUID.toString());
        return createdUUID;
    }

    public void updateTutorInfo(String username, TutorApiDto.TutorInfoUpdateForm tutorInfoUpdateForm) {
        tutorService.updateTutorInformation(username, tutorInfoUpdateForm);
    }

    public void createSchedule(String username, TutorCriteria.TutorCreateScheduleRequest scheduleRequest) {
        var tutor = tutorService.findTutorByUsername(username);
        var scheduleUUID = scheduleService.createSchedule(
                Schedule.builder()
                        .title(scheduleRequest.getTitle())
                        .description(scheduleRequest.getDescription())
                        .startAt(scheduleRequest.getStartAt())
                        .endAt(scheduleRequest.getEndAt())
                        .willNotifyAt(scheduleRequest.getWillNotifyAt())
                        .tutor(tutor)
                        .build()
        );
        log.info("Schedule이 생성됐습니다. UUID: {}", scheduleUUID);
    }
}
