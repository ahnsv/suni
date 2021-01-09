package dev.humphrey.suni.interfaces.api.tutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import dev.humphrey.suni.application.TutorFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest(classes = {TutorApiController.class})
@ExtendWith({SpringExtension.class})
class TutorApiControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private TutorFacade tutorFacade;


    @BeforeEach
    void setUp() {
        var mappingJackson2HttpMessageConverter = new
                MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(new ObjectMapper().setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE));
        mockMvc = standaloneSetup(new TutorApiController(tutorFacade))
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .setMessageConverters(mappingJackson2HttpMessageConverter)
                .alwaysDo(print()).build();
    }

    @Test
    @DisplayName("/api/v1/tutor/register가 200코드와 json을 반환해야한다.")
    void createTutorAccount() throws Exception {
        // given
        TutorAccountDto.TutorAccountForm accountForm = new TutorAccountDto.TutorAccountForm();
        accountForm.setEmail("abc@def.com");
        accountForm.setUsername("abcdef");
        accountForm.setPassword("ghijklmnop");
        var mapper = new ObjectMapper();
        var accountFormJson = mapper.writeValueAsString(accountForm);

        // when, then
        mockMvc.perform(post("/api/v1/tutor/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(accountFormJson)).andExpect(status().isOk());
    }
}