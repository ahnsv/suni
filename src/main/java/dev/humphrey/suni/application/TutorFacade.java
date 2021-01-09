package dev.humphrey.suni.application;

import dev.humphrey.suni.domain.tutor.service.TutorAccountService;
import dev.humphrey.suni.interfaces.api.tutor.TutorAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TutorFacade {
    private TutorAccountService tutorAccountService;

    public void createTutorAccount(TutorAccountDto.TutorAccountForm accountFormDetail) {
        var createdUUID = tutorAccountService.createTutorAccount(accountFormDetail);
        log.info("Created UUID: {}", createdUUID.toString());
    }
}
