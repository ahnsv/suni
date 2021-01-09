package dev.humphrey.suni.domain.schedule.entity;

import dev.humphrey.suni.domain.common.AbstractEntity;
import dev.humphrey.suni.domain.tutor.entity.Tutor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "schedules")
@Getter
@NoArgsConstructor
public class Schedule extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @ManyToOne
    private Tutor tutor;
    // private Course course;
    // private Tutee tutee;
    private ZonedDateTime willStartAt;
    private ZonedDateTime willEndAt;
    private ZonedDateTime willNotifyAt;

    @Builder
    public Schedule(UUID id, String title, String description, Tutor tutor, ZonedDateTime willStartAt, ZonedDateTime willEndAt, ZonedDateTime willNotifyAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tutor = tutor;
        this.willStartAt = willStartAt;
        this.willEndAt = willEndAt;
        this.willNotifyAt = willNotifyAt;
    }
}
