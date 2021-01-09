package dev.humphrey.suni.domain.tutor.repository;

import dev.humphrey.suni.domain.tutor.entity.TutorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TutorAccountRepository extends JpaRepository<TutorAccount, Long> {
    TutorAccount findByUsername(String username);
}
