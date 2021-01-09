package dev.humphrey.suni.domain.tutor.service;


import dev.humphrey.suni.domain.tutor.entity.Tutor;
import dev.humphrey.suni.domain.tutor.repository.TutorAccountRepository;
import dev.humphrey.suni.domain.tutor.repository.TutorRepository;
import dev.humphrey.suni.interfaces.api.tutor.TutorApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final TutorAccountRepository tutorAccountRepository;

    @Transactional
    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Transactional
    public void updateTutorInformation(String username, TutorApiDto.TutorInfoUpdateForm updateForm) {
        var foundAccount = tutorAccountRepository.findByUsername(username);
        var found = tutorRepository.findByAccountId(foundAccount);
        log.info("Tutor 정보를 찾았습니다. {}", found);
        found.setFirstName(updateForm.getFirstName());
        found.setLastName(updateForm.getLastName());
        found.setNickName(updateForm.getNickName());
        log.info("Tutor 정보를 업데이트 합니다. 이름: {}, 성: {}, 닉네임: {}", updateForm.getFirstName(), updateForm.getLastName(), updateForm.getNickName());
        tutorRepository.save(found);
        log.info("Tutor 정보를 성공적으로 업데이트 했습니다.");
    }

    public Tutor findTutorByUsername(String username) {
        return tutorRepository.findByAccountId_Username(username);
    }
}
