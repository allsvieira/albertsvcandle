package Fi06.candles;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static junit.framework.TestCase.assertEquals;


class CandleCalculatorTest {

    private Candle candle;
    private CandleCalculator candleCalculator;

    @BeforeEach
    void setUp() {
        this.candleCalculator = new CandleCalculator(new Candle());
        this.candle = this.candleCalculator.getCandle();
    }

    @Test
    @DisplayName("Candle.weight = 1.0 => 1.0")
    void calcWeight() {
        this.candle.setWeight(1.0);
        assertEquals(1.0, this.candleCalculator.calcWeight());
    }

    @Test
    @DisplayName("Candle.weight = -1.0 => 0.0")
    void calcNegativeWeight() {
        this.candle.setWeight(-1.0);
        this.candle.setMaterial(Material.BEEWAX);
         assertEquals(0.0, this.candleCalculator.calcWeight());
    }

    @Test
    @DisplayName("Height = 1, diameter = 2, density = 0.9 => 2.827 ")
    void calcWeightWithHeightAndDens() {
        this.candle.setMaterial(Material.PARAFIN);
        this.candle.setLength(1.0);
        this.candle.setDiameter(2.0);
        assertEquals(2.827, this.candleCalculator.calcWeight(), 0.01);
    }

    @Test
    @DisplayName("Height = 10.1, diameter = 10.1, density = 0.93 => 752.5527")
    void calcWeightWithDigits() {
        this.candle.setMaterial(Material.STEARIN);
        this.candle.setLength(10.1);
        this.candle.setDiameter(10.1);
        assertEquals(752.5527, this.candleCalculator.calcWeight(), 0.001);
    }

    @Test
    @DisplayName("Height = 0, diameter = 0, density = 0.9 => 0 ")
    void calcWeightZero() {
        this.candle.setMaterial(Material.PARAFIN);
        this.candle.setLength(0);
        this.candle.setDiameter(0);
        assertEquals(0.0, this.candleCalculator.calcWeight());
    }

    @Test
    @DisplayName("Height = -1, diameter = -1, density = 0.9 => 0 ")
    void calcWeightNegative() {
        this.candle.setMaterial(Material.PARAFIN);
        this.candle.setLength(-1);
        this.candle.setDiameter(-1);
        assertEquals(0.0, this.candleCalculator.calcWeight());
    }

    @Test
    @DisplayName("Weight = 7.5, Speed = 7.5g/h => 1")
    void calcDuration() {
        this.candle.setWeight(7.5);
        this.candle.setMaterial(Material.PARAFIN);
        assertEquals(1, this.candleCalculator.calcDuration());
    }

    @Test
    @DisplayName("Weight = 2.0, Speed = 4.0g/h => 0.5")
    void calcHalfDuration() {
        this.candle.setWeight(2.0);
        this.candle.setMaterial(Material.BEEWAX);
        assertEquals(0.5, this.candleCalculator.calcDuration());
    }

    @Test
    @DisplayName("Weight = -2.0, Speed = -4.0g/h => 0.0")
    void calcNegativeDuration() {
        this.candle.setWeight(-2.0);
        this.candle.setMaterial(Material.BEEWAX);
        assertEquals(0.0, this.candleCalculator.calcDuration());
    }


    @Test
    @DisplayName("Height = 1, diameter = 2, density = 0.9 => 0 hour 22 minutes")
    void calcWeightWithHeightAndDensThenDuration() {
        this.candle.setMaterial(Material.PARAFIN);
        this.candle.setLength(1.0);
        this.candle.setDiameter(2.0);
        assertEquals("0:22", this.candleCalculator.getTimeLeft());
    }

    @Test
    @DisplayName("Material = null => 0.0")
    void testNull(){
        assertEquals(0.0, this.candleCalculator.calcDuration() );
    }

}