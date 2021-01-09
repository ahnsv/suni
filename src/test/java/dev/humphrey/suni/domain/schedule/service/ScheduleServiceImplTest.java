package dev.humphrey.suni.domain.schedule.service;

import dev.humphrey.suni.domain.tutor.entity.Tutor;
import dev.humphrey.suni.domain.tutor.entity.TutorAccount;
import dev.humphrey.suni.domain.tutor.repository.TutorAccountRepository;
import dev.humphrey.suni.domain.tutor.repository.TutorRepository;
import dev.humphrey.suni.domain.tutor.service.TutorAccountService;
import dev.humphrey.suni.domain.tutor.service.TutorService;
import dev.humphrey.suni.interfaces.api.tutor.TutorApiDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {
    private static final UUID TUTOR_ID = UUID.randomUUID();
    private Tutor tutor;

    @Mock
    private TutorAccountService tutorAccountService;

    @Mock
    private TutorService tutorService;

    @BeforeEach
    void setUp() {
        var tutorAccountForm = TutorApiDto.TutorAccountForm.builder().username("test").password("test").email("test@test.com").build();
        tutorAccountService.createTutorAccount(tutorAccountForm);
        var tutorAccount = tutorAccountService.findTutorAccountByUsername(tutorAccountForm.getUsername());
        tutor = tutorService.createTutor(Tutor.builder().accountId(tutorAccount).id(TUTOR_ID).firstName("tester").lastName("Test").build());
    }

    @Test
    void test_test() {
        System.out.println(tutor.getFirstName());
    }
}