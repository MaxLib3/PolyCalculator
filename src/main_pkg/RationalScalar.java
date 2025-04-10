package main_pkg;

public class RationalScalar implements Scalar
{
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return null;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return null;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return null;
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return null;
    }

    @Override
    public Scalar neg() {
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
