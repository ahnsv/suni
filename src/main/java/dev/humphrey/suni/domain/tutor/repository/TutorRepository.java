package dev.humphrey.suni.domain.tutor.repository;

import dev.humphrey.suni.domain.tutor.entity.Tutor;
import dev.humphrey.suni.domain.tutor.entity.TutorAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findAllByAccountId_Username(String username);
    Tutor findByAccountId_Username(String username);
    Tutor findByAccountId(TutorAccount account);
}
