package dev.humphrey.suni.domain.tutor.service;

import dev.humphrey.suni.domain.tutor.entity.TutorAccount;
import dev.humphrey.suni.domain.tutor.repository.TutorAccountRepository;
import dev.humphrey.suni.interfaces.api.tutor.TutorAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log
public class TutorAccountService {
    private final TutorAccountRepository tutorAccountRepository;

    public UUID createTutorAccount(TutorAccountDto.TutorAccountForm accountFormDetail) {
        final TutorAccount nextAccount = TutorAccount.builder()
                .username(accountFormDetail.getUsername())
                .password(accountFormDetail.getPassword())
                .email(accountFormDetail.getEmail())
                .build();
        tutorAccountRepository.save(nextAccount);
        return nextAccount.getId();
    }
}
