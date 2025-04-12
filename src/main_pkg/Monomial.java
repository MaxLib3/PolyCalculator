package main_pkg;

public class Monomial
{
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent != m.getExponent())
            return null;
        return new Monomial(this.exponent, this.coefficient.add(m.getCoefficient()));
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.exponent + m.getExponent(), this.coefficient.mul(m.getCoefficient()));
    }

    public Scalar evaluate(Scalar s) {
        return s.power(this.exponent).mul(this.coefficient);
    }

    public Monomial derivative() {
        return new Monomial(this.exponent - 1, this.coefficient.mul(new IntegerScalar(this.exponent)));
    }

    public int sign() {
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Monomial m) {
            return coefficient.equals(m.getCoefficient()) && this.exponent == m.getExponent();
        }
        return false;
    }

    public String toString() {
        if (new IntegerScalar(1).equals(this.coefficient))
            return "x^" + this.exponent;
        else if (new IntegerScalar(-1).equals(this.coefficient))
            return "-x^" + this.exponent;
        else if (new IntegerScalar(0).equals(this.coefficient))
            return "0";
        else if (this.exponent == 0)
            return this.coefficient.toString();
        else if (this.exponent == 1)
            return this.coefficient.toString() + "x";
        return this.coefficient.toString() + "x^" + this.exponent;
    }

    public int getExponent() {
        return this.exponent;
    }

    public Scalar getCoefficient() {
        return this.coefficient;
    }
}
