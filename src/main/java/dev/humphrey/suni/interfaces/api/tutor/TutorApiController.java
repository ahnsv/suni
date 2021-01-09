package dev.humphrey.suni.interfaces.api.tutor;

import dev.humphrey.suni.application.TutorFacade;
import dev.humphrey.suni.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/tutor")
@RequiredArgsConstructor
public class TutorApiController {
    private final TutorFacade tutorFacade;

    @PostMapping("/register")
    public CommonResponse registerTutorAccount(@RequestBody TutorAccountDto.TutorAccountForm accountForm) {
        log.info("[TutorApiController.registerTutorAccount] Request = {}", accountForm);
        tutorFacade.createTutorAccount(accountForm);
        return CommonResponse.success(HttpStatus.OK);
    }
}
