package aoshelper.diceservice;

import aoshelper.common.diceservice.model.RollResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dice-service")
public interface DiceServiceClient {
    @GetMapping("/api/dice/d6")
    RollResult getD6RollResult(@RequestParam Integer amountOfDices);
}
