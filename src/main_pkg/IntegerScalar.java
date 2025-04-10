package main_pkg;

public class IntegerScalar implements Scalar
{
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    public String toString() {
        if (this.number == 0)
            return "0";

        String str = "";
        int copyNum = this.number;
        while (copyNum != 0)
        {
            str = (copyNum % 10) + str;
            copyNum /= 10;
        }

        if (sign() == -1)
            str = "-" + str;
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

    public int getNumber() {
        return this.number;
    }
}
