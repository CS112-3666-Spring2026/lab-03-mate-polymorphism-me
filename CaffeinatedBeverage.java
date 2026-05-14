public class CaffeinatedBeverage
{
    private String name;
    private int ounces;
    private double price;

    public CaffeinatedBeverage(){
        this.name = "Unknown";
        this.ounces = 0;
        this.price = 0.0;
    }

    public CaffeinatedBeverage(String name, int ounces, double price) {
        this.name = name;
        this.ounces = ounces;
        this.price = price;
    }

    public CaffeinatedBeverage(CaffeinatedBeverage other) {
        if (other == null) {
            this.name = "Unknown";
            this.ounces = 0;
            this.price = 0.0;
        } else {
            this.name = other.name;
            this.ounces = other.ounces;
            this.price = other.price;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean setName(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        this.name = name;
        return true;
    }

    public int getOunces() {
        return this.ounces;
    }

    public boolean setOunces(int ounces) {
        if (ounces < 0) {
            return false;
        }
        this.ounces = ounces;
        return true;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean setPrice(double price) {
        if (price < 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    public boolean setAll(String name, int ounces, double price) {
        if (name == null || name.isBlank() || ounces < 0 || price < 0) {
            return false;
        }

        this.name = name;
        this.ounces = ounces;
        this.price = price;
        return true;
    }

    public boolean sip(int ounces) {
        this.ounces -= ounces;
        if (this.ounces <= 0) {
            this.ounces = 0;
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 &&
                this.name.equals(that.name);
    }
    
    @Override
    public String toString() {
        return "Caffeinated Beverage{" + "name='" + name + '\'' + ", ounces=" + ounces + ", price= $" + price + '}';
    }
}