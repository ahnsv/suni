package dev.humphrey.suni.domain.tutor.entity;

import dev.humphrey.suni.domain.common.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String username;
    private String password;
    private String email;

    public TutorAccount(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
