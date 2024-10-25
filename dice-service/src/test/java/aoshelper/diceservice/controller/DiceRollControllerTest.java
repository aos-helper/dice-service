package aoshelper.diceservice.controller;

import aoshelper.diceservice.service.DiceRollService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiceRollControllerTest {

    private final DiceRollService diceRollService = mock();
    private final DiceRollController diceRollController = new DiceRollController(diceRollService);

    @Test
    void getD6RollResult() {
        when(diceRollService.rollD6())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3);

        var result = diceRollController.getD6RollResult(3);

        // then
        assertThat(result.getResults()).containsExactly(1, 2, 3);
    }
}