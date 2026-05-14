public class Tea extends CaffeinatedBeverage {
    private int brewTemp;

    public Tea() {
        super();
        this.brewTemp = 0;
    }
    
    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        setBrewTemp(brewTemp);
    }
    
    public Tea(Tea other) {
        if (other == null) {
            this.brewTemp = 0;
        } else {
            this.brewTemp = other.brewTemp;
        }
    }

    public int getBrewTemp() {
        return brewTemp;
    }

    public boolean setBrewTemp(int brewTemp) {
        if (this.brewTemp < 0) {
            this.brewTemp = brewTemp;
            return false;
        }

        this.brewTemp = brewTemp;
        return true;
    }

    public boolean setAll(String name, int ounces, double price, int brewTemp) {
        if (!super.setAll(name, ounces, price)) {
            return false;
        }

        if (!setBrewTemp(brewTemp)) {
            return false;
        }

        return true;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tea)) {
            return false;
        }

        Tea otherTea = (Tea) other;

        return super.equals(otherTea) && this.brewTemp == otherTea.brewTemp;
    }

    @Override
    public String toString() {
        return String.format(
            "Tea: %s, %d, %d, $%.2f",
            getName(),
            getOunces(),
            brewTemp,
            getPrice()
        );
    }
}
