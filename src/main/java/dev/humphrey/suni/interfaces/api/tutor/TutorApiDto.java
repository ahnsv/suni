package dev.humphrey.suni.interfaces.api.tutor;


import dev.humphrey.suni.application.TutorCriteria;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

public class TutorApiDto {

    @Data
    @Builder
    public static class TutorInfoUpdateForm {
        private String firstName;
        private String lastName;
        private String nickName;
    }

    @Data
    @Builder
    @ToString(exclude = "password")
    public static class TutorAccountForm {
        private String username;
        private String password;
        private String email;
    }

    @Getter
    @Builder
    public static class TutorScheduleForm {
        private String title;
        private String description;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;
        private ZonedDateTime willNotifyAt;

        public TutorCriteria.TutorCreateScheduleRequest convert() {
            return TutorCriteria.TutorCreateScheduleRequest.builder()
                    .title(title)
                    .description(description)
                    .endAt(endAt)
                    .startAt(startAt)
                    .willNotifyAt(willNotifyAt)
                    .build();
        }
    }

    public static class TutorScheduleUpdateForm {
        private String title;
        private String description;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;
        private ZonedDateTime willNotifyAt;
    }
}
