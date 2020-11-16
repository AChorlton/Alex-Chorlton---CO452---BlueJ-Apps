/**
 * Enumeration class Coin - write a description of the enum class here
 *
 * @author (Alex Chorlton)
 * @version (0.1)
 */
public enum Coin
{
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        private final int value;

        private Coin(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
}
