import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class hangmanTest {
    @Test
    void checkIfHintIsGiven() {
        hints hintGenerator = new hints();
        assertEquals("It might be a country", hintGenerator.giveHint("Sweden", 1));
        assertEquals("There are usually snow at this place!", hintGenerator.giveHint("Sweden", 2));
    }


}
