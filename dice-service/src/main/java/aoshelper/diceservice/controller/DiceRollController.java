package aoshelper.diceservice.controller;

import aoshelper.common.diceservice.model.RollResult;
import aoshelper.diceservice.DiceServiceApi;
import aoshelper.diceservice.service.DiceRollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dice")
public class DiceRollController implements DiceServiceApi {

    private final DiceRollService diceRollService;

    @GetMapping("/d6")
    public RollResult getD6RollResult(@RequestParam Integer amountOfDices) {
        var result = new RollResult();

        for (int i = 0; i < amountOfDices; i++) {
            result.addResult(diceRollService.rollD6());
        }

        return result;
    }
}
