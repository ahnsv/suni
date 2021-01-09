package dev.humphrey.suni.domain.tutor.entity;

import dev.humphrey.suni.domain.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Table(name = "tutor_accounts")
@NoArgsConstructor
public class TutorAccount extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    @OneToOne(mappedBy = "accountId")
    private Tutor tutor;

    @Builder
    public TutorAccount(UUID id, String username, String password, String email, Tutor tutor) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tutor = tutor;
    }
}
