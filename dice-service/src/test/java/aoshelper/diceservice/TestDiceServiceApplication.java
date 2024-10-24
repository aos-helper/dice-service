package aoshelper.diceservice;

import org.springframework.boot.SpringApplication;

public class TestDiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(DiceServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
