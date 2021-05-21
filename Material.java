package Fi06.candles;

public enum Material {

    PARAFIN(0.9, 7.5), STEARIN(0.93, 6.5), BEEWAX(0.95, 4.0);

    private final double density;
    private final double burnSpeed;
    private String name;

    Material(double density, double speed) {
        this.density = density;
        this.burnSpeed = speed;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public double getBurnSpeed() {
        return burnSpeed;
    }

    @Override
    public String toString() {
        return getName();
    }
}




