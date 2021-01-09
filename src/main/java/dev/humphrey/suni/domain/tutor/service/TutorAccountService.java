package dev.humphrey.suni.domain.tutor.service;

import dev.humphrey.suni.domain.tutor.entity.Tutor;
import dev.humphrey.suni.domain.tutor.entity.TutorAccount;
import dev.humphrey.suni.domain.tutor.repository.TutorAccountRepository;
import dev.humphrey.suni.domain.tutor.repository.TutorRepository;
import dev.humphrey.suni.interfaces.api.tutor.TutorApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TutorAccountService {
    private final TutorAccountRepository tutorAccountRepository;
    private final TutorRepository tutorRepository;


    @Transactional
    public TutorAccount findTutorAccountByUsername(String username) {
        return tutorAccountRepository.findByUsername(username);
    }

    @Transactional
    public Long createTutorAccount(TutorApiDto.TutorAccountForm accountFormDetail) {
        TutorAccount nextAccount = TutorAccount.builder()
                .username(accountFormDetail.getUsername())
                .password(accountFormDetail.getPassword())
                .email(accountFormDetail.getEmail())
                .build();
        log.info("Tutor Account를 만들었습니다. Tutor Account: {}", nextAccount);
        tutorAccountRepository.save(nextAccount);
        var emptyTutorEntity = Tutor.builder().accountId(nextAccount).build();
        log.info("Tutor Entity를 만들었습니다. Tutor : {}", emptyTutorEntity);
        tutorRepository.save(emptyTutorEntity);
        return nextAccount.getId();
    }
}
