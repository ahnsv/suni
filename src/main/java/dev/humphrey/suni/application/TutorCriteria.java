package dev.humphrey.suni.application;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

public class TutorCriteria {
    @Getter
    @Builder
    public static class TutorCreateScheduleRequest {
        private String title;
        private String description;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;
        private ZonedDateTime willNotifyAt;
    }
}
