package aoshelper.diceservice.service;

import org.springframework.stereotype.Service;

@Service
public class DiceRollService {
    public int rollD6() {
        return (int) (Math.random() * 6) + 1;
    }
}
