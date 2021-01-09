package dev.humphrey.suni.interfaces.api.tutor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class TutorAccountDto {
    @Data
    @ToString(exclude = "password")
    public static class TutorAccountForm {
        private String username;
        private String password;
        private String email;
    }

}
