package dev.humphrey.suni.interfaces.api.tutor;

import dev.humphrey.suni.application.TutorFacade;
import dev.humphrey.suni.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/tutor")
@RequiredArgsConstructor
public class TutorApiController {
    private final TutorFacade tutorFacade;

    @PostMapping("/register")
    public CommonResponse registerTutorAccount(@RequestBody TutorApiDto.TutorAccountForm accountForm) {
        log.info("[TutorApiController.registerTutorAccount] Request = {}", accountForm);
        var response = tutorFacade.createTutorAccount(accountForm);
        return CommonResponse.success(response);
    }

    @PostMapping("/update/info")
    public CommonResponse updateTutorInfo(@RequestParam String username, @RequestBody TutorApiDto.TutorInfoUpdateForm infoUpdateForm) {
        log.info("[TutorApiController.updateTutorInfo] Request = {}", infoUpdateForm);
        tutorFacade.updateTutorInfo(username, infoUpdateForm);
        return CommonResponse.success(HttpStatus.OK);
    }
}
