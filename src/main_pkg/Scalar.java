package main_pkg;

public interface Scalar
{
    public Scalar add(Scalar s);
    public Scalar addInteger(IntegerScalar s);
    public Scalar addRational(RationalScalar s);

    public Scalar mul(Scalar s);
    public Scalar mulInteger(IntegerScalar s);
    public Scalar mulRational(RationalScalar s);

    public Scalar neg();

    public Scalar power(int exponent);

    public int sign();
}
