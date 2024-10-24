package aoshelper.diceservice.controller;


import aoshelper.diceservice.service.DiceRollService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiceRollControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiceRollService diceRollService;

    @Test
    void shouldReturnDefaultMessage() throws Exception {

        when(diceRollService.rollD6())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3);

        this.mockMvc
                .perform(
                        get("/api/dice/d6")
                                .param("amountOfDices", "3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                {"results":[1,2,3]}
                                """));
    }
}
