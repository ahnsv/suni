package dev.humphrey.suni.domain.tutor.entity;

import dev.humphrey.suni.domain.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tutors")
public class Tutor extends AbstractEntity {
    @Id
    @GeneratedValue()
    private Long id;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String nickName;

    @OneToOne
    @JoinColumn(name = "account_id")
    private TutorAccount accountId;
    // private List<Course> courses;

    @Builder
    public Tutor(Long id, String firstName, String lastName, TutorAccount accountId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountId = accountId;
    }
}
