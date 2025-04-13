package main_pkg;
import java.util.*;

public class Polynomial
{
    private HashMap<Integer, Monomial> monomials;

    public Polynomial() {
        this.monomials = new HashMap<Integer, Monomial>();
    }

    public static Polynomial build(String input)
    {
        Polynomial p = new Polynomial();
        String[] splited = input.split("\\s+");

        int i = 0;
        for (String s: splited) {
            if (s.contains("/")) {
                int index = s.indexOf("/");
                if (strToInt(s.substring(0, index)) != 0) {
                    int numerator = strToInt(s.substring(0, index));
                    int denominator = strToInt(s.substring(index + 1));
                    Monomial newM = new Monomial(i, new RationalScalar(numerator, denominator));
                    p.getMonomials().put(i, newM);
                }
            } else  if (strToInt(s) != 0) {
                p.getMonomials().put(i, new Monomial(i, new IntegerScalar(strToInt(s))));
            }
            i++;
        }
        return p;
    }

    public Polynomial add(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Monomial> entry: this.monomials.entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();
            if (p.getMonomials().containsKey(exponent))
                result.getMonomials().put(exponent, monomial.add(p.getMonomials().get(exponent)));
            else
                result.getMonomials().put(exponent, monomial);
        }

        for (Map.Entry<Integer, Monomial> entry : p.getMonomials().entrySet()) {
            int degree = entry.getKey();
            if (!this.monomials.containsKey(degree)) {
                result.monomials.put(degree, entry.getValue());
            }
        }
        return result;
    }

    public Polynomial mul(Polynomial p) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry1 : this.monomials.entrySet()) {
            for (Map.Entry<Integer, Monomial> entry2 : p.monomials.entrySet()) {
                int newDegree = entry1.getKey() + entry2.getKey();
                Monomial product = entry1.getValue().mul(entry2.getValue());

                if (result.monomials.containsKey(newDegree)) {
                    Monomial existing = result.monomials.get(newDegree);
                    result.monomials.put(newDegree, existing.add(product));
                } else {
                    result.monomials.put(newDegree, product);
                }
            }
        }
        return result;
    }

    public Scalar evaluate(Scalar s) {
        Scalar result = new IntegerScalar(0);
        for (Monomial mon: this.monomials.values()) {
            result = result.add(mon.evaluate(s));
        }
        return result;
    }

    public Polynomial derivative() {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : this.monomials.entrySet()) {
            Monomial monomial = entry.getValue();
            Monomial derivative = monomial.derivative();

            if (derivative.getExponent() != -1) {
                result.monomials.put(derivative.getExponent(), derivative);
            }
        }
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof Polynomial) {
            Polynomial polynomial = (Polynomial)o;
            if (this.monomials.size() != polynomial.getMonomials().size())
                return false;

            for (Map.Entry<Integer, Monomial> entry : this.monomials.entrySet()) {
                Monomial thisMonomial = entry.getValue();
                Monomial otherMonomial = polynomial.getMonomials().get(entry.getKey());
                if (!thisMonomial.equals(otherMonomial))
                    return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        if (this.monomials.keySet().isEmpty())
            return "0";

        List<Integer> exponents = new ArrayList<>(this.monomials.keySet());
        Collections.sort(exponents);

        String result = "";
        for (int exponent: exponents) {
            Monomial m = this.monomials.get(exponent);
            if (!m.getCoefficient().equals(new IntegerScalar(0))) {
                if (m.getCoefficient().sign() == 1)
                    result += '+';
                result += m.toString();
            }
        }
        if (result.charAt(0) == '+')
            result = result.substring(1);
        return result;
    }

    private static int strToInt(String str) {
        int i = 0;
        int num = 0;
        boolean isNeg = false;

        if (str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }
        while (i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0';
        }

        if (isNeg)
            num = -num;
        return num;
    }


    public HashMap<Integer, Monomial> getMonomials() {
        return this.monomials;
    }
}
