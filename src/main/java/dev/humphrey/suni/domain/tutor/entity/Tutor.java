package dev.humphrey.suni.domain.tutor.entity;

import dev.humphrey.suni.domain.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tutors")
public class Tutor extends AbstractEntity {
    @Id
    @GeneratedValue()
    private UUID id;
    private String firstName;
    private String lastName;
    // private List<Course> courses;

    @Builder
    public Tutor(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
