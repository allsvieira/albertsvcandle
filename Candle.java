package Fi06.candles;

public class Candle {

    private Material material;
    private double length;
    private double diameter;
    private double weight;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = notNegative(length);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = notNegative(diameter);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = notNegative(weight);
    }

    private double notNegative(double value){
        return value > 0.0 ? value : 0.0;
    }

}
