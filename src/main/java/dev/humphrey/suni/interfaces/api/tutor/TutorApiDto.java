package dev.humphrey.suni.interfaces.api.tutor;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

public class TutorApiDto {

    @Data
    @Builder
    public static class TutorInfoUpdateForm {
        private String firstName;
        private String lastName;
        private String nickName;
    }

    @Data
    @ToString(exclude = "password")
    public static class TutorAccountForm {
        private String username;
        private String password;
        private String email;
    }
}
