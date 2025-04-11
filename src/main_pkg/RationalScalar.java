package main_pkg;

public class RationalScalar implements Scalar
{
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        if (this.numerator == 0)
            return "0";

        String str = "";
        int copyNum = Math.abs(this.numerator);
        int copyDen = Math.abs(this.numerator);
        RationalScalar rs = new RationalScalar(copyNum, copyDen).reduce();
        if (rs.getDenominator() == 1)
            str += rs.getNumerator();
        else
            str += rs.getNumerator() + "/" + rs.getDenominator();

        if (sign() == -1)
            str = "-" + str;
        return str;
    }

    @Override
    public Scalar add(Scalar s){
        return s.addRational(this);
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
        return s.mulRational(this);
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
        return new RationalScalar(-this.numerator, this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        return new RationalScalar((int)Math.pow(this.numerator, exponent), (int)Math.pow(this.denominator, exponent));
    }

    @Override
    public int sign() {
        if (numerator == 0)
            return 0;
        else if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            return -1;
        return 1;
    }

    public RationalScalar reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        return new RationalScalar(this.numerator / gcd, this.denominator / gcd);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerScalar)
            return ((IntegerScalar) o).equals(this);
        else if (o instanceof RationalScalar) {
            RationalScalar rs1 = ((RationalScalar)o).reduce();
            RationalScalar rs2 = this.reduce();
            return rs1.getNumerator() == rs2.getNumerator() && rs1.getDenominator() == rs2.getDenominator();
        }
        return false;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
