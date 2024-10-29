package aoshelper.diceservice;

import aoshelper.common.diceservice.model.RollResult;

public interface DiceServiceApi {
    RollResult getD6RollResult(Integer amountOfDices);
}
