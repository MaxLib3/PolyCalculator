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
    public Scalar add(Scalar s){
        s.addRational(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {

        return s.addRational(this);
    }

    @Override
    public Scalar addRational(RationalScalar s) {

        int numerator1 = ((s.getNumerator() * denominator) + (numerator * s.getDenominator()));
        int denominator1 = (s.getDenominator() * denominator);
        return new RationalScalar(numerator1, denominator1);
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        int numerator1 = (s.getNumerator() * numerator);
        int denominator1 = (s.getDenominator() * denominator);
        return new RationalScalar(numerator1, denominator1);
    }

    @Override
    public Scalar neg() {
        return this.mulInteger(new IntegerScalar(-1));
    }

    @Override
    public Scalar power(int exponent) {
        if (this.sign() < 0)
            throw new IllegalArgumentException();
        Scalar s = new RationalScalar(1, 1);
        for (int i = 0; i < exponent; i++){
            s = s.mul(this);
        }
        return s;
    }

    @Override
    public int sign() {
        if (numerator == 0)
            return 0;
        else if ( (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0) )
            return -1;
        else
            return 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
