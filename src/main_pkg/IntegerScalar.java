package main_pkg;

public class IntegerScalar implements Scalar
{
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    public String toString() {
        String str = "";
        str += this.number;
        return str;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar other) {
        return new IntegerScalar(this.number + other.getNumber());
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        return new RationalScalar(this.number * s.getDenominator() + s.getNumerator(), s.getDenominator());
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(s.getNumber() * this.number);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator());
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int)Math.pow(this.number, exponent));
    }

    @Override
    public int sign() {
        if (this.number == 0)
            return 0;
        if (this.number > 0)
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerScalar)
            return this.number == ((IntegerScalar) o).getNumber();
        else if (o instanceof RationalScalar) {
            RationalScalar rs = ((RationalScalar)o).reduce();
            if (rs.getDenominator() == 1)
                return this.number == rs.getNumerator();
            return false;
        }
        return false;
    }

    public int getNumber() {
        return this.number;
    }

}
