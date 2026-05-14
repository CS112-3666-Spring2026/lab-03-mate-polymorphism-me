public class YerbaMate extends Tea{
    private int numPasses;

    public YerbaMate() {
        super();
        this.numPasses = 0;
    }

    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);

        if (numPasses >= 0) {
            this.numPasses = numPasses;
        } else {
            this.numPasses = 0;
        }
    }

    public YerbaMate(YerbaMate other) {
        super(other);

        if (other == null) {
            this.numPasses = 0;
        } else {
            this.numPasses = other.numPasses;
        }
    }

    public int getNumPasses() {
        return numPasses;
    }
    
    public void passMate() {
        numPasses++;
        System.out.println("The mate was passed. Current number of passes: " + numPasses);
    }

    public void refill(int ounces) {
        if (ounces > 0) {
            setOunces(getOunces() + ounces);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof YerbaMate)) {
            return false;
        }

        YerbaMate otherMate = (YerbaMate) other;

        return super.equals(otherMate)
                && this.numPasses == otherMate.numPasses;
    }

    @Override
    public String toString() {
        return String.format(
                "Yerba Mate: %s, %d, %d, $%.2f, %d",
                getName(),
                getOunces(),
                getBrewTemp(),
                getPrice(),
                numPasses
        );
    }
}
