package strategy;

import org.example.exception.BattleException;
import org.example.model.Block;
import org.example.strategy.impl.RandomFire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomFireTest {

    RandomFire randomFire;

    @BeforeEach
    void setup() {
        randomFire = new RandomFire();
    }

    @Test
    public void testFireThrowsBattleExceptionOnEmptyBoard() throws BattleException {
        List<Block> board = null;
        Assertions.assertThrows(BattleException.class, () -> randomFire.fire(board));
    }
}
