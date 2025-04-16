package Tests;
import main_pkg.*;
import org.junit.*;

public class MonomialTests {
    private Monomial m;

    @Test
    public void test1toString() {
        m = new Monomial(2, new IntegerScalar(3));
        Assert.assertEquals("Result should be 3x^2", "3x^2", m.toString());
    }
    @Test
    public void test2toString() {
        m = new Monomial(0, new IntegerScalar(5));
        Assert.assertEquals("Result should be 5", "5", m.toString());
    }
    @Test
    public void test3toString() {
        m = new Monomial(1, new IntegerScalar(-1));
        Assert.assertEquals("Result should be -x^1", "-x^1", m.toString());
    }
    @Test
    public void test4toString() {
        m = new Monomial(3, new RationalScalar(2, 3));
        Assert.assertEquals("Result should be 2/3x^3", "2/3x^3", m.toString());
    }
    @Test
    public void test5toString() {
        m = new Monomial(1, new RationalScalar(5, 6));
        Assert.assertEquals("Result should be 5/6x", "5/6x", m.toString());
    }
    @Test
    public void test6toString() {
        m = new Monomial(0, new RationalScalar(0, 1));
        Assert.assertEquals("Result should be 0", "0", m.toString());
    }
    @Test
    public void test1addMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(4));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be 7x^2", "7x^2", result.toString());
    }
    @Test
    public void test2addMonomial() {
        Monomial m1 = new Monomial(3, new IntegerScalar(5));
        Monomial m2 = new Monomial(3, new RationalScalar(10, 2));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be 10x^3", "10x^3", result.toString());
    }
    @Test
    public void test3addMonomial() {
        Monomial m1 = new Monomial(0, new IntegerScalar(3));
        Monomial m2 = new Monomial(0, new RationalScalar(-3, 1));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test4addMonomial() {
        Monomial m1 = new Monomial(1, new RationalScalar(1, 2));
        Monomial m2 = new Monomial(1, new RationalScalar(1, 2));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be x", "x", result.toString());
    }
    @Test
    public void test5addMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(0));
        Monomial m2 = new Monomial(2, new RationalScalar(5, 3));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be 5/3x^2", "5/3x^2", result.toString());
    }
    @Test
    public void test6addMonomial() {
        Monomial m1 = new Monomial(3, new RationalScalar(7, 3));
        Monomial m2 = new Monomial(3, new IntegerScalar(2));
        Monomial result = m1.add(m2);
        Assert.assertEquals("Result should be 13/3x^3", "13/3x^3", result.toString());
    }
    @Test
    public void test1mulMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(4));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be 12x^5", "12x^5", result.toString());
    }
    @Test
    public void test2mulMonomial() {
        Monomial m1 = new Monomial(0, new IntegerScalar(5));
        Monomial m2 = new Monomial(3, new RationalScalar(2, 3));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be 10/3x^3", "10/3x^3", result.toString());
    }
    @Test
    public void test3mulMonomial() {
        Monomial m1 = new Monomial(1, new RationalScalar(1, 2));
        Monomial m2 = new Monomial(1, new RationalScalar(3, 4));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be 3/8x^2", "3/8x^2", result.toString());
    }
    @Test
    public void test4mulMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(-1));
        Monomial m2 = new Monomial(2, new RationalScalar(1, 2));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be -1/2x^4", "-1/2x^4", result.toString());
    }
    @Test
    public void test5mulMonomial() {
        Monomial m1 = new Monomial(0, new RationalScalar(7, 3));
        Monomial m2 = new Monomial(0, new IntegerScalar(3));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be 7", "7", result.toString());
    }
    @Test
    public void test6mulMonomial() {
        Monomial m1 = new Monomial(1, new RationalScalar(5, 6));
        Monomial m2 = new Monomial(1, new RationalScalar(-6, 5));
        Monomial result = m1.mul(m2);
        Assert.assertEquals("Result should be -x^2", "-x^2", result.toString());
    }
    @Test
    public void test1evaluate() {
        m = new Monomial(2, new IntegerScalar(3));
        Scalar s = new IntegerScalar(2);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 12", "12", result.toString());
    }
    @Test
    public void test2evaluate() {
        m = new Monomial(0, new IntegerScalar(5));
        Scalar s = new IntegerScalar(10);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 5", "5", result.toString());
    }
    @Test
    public void test3evaluate() {
        m = new Monomial(3, new RationalScalar(1, 2));
        Scalar s = new IntegerScalar(2);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 4", "4", result.toString());
    }
    @Test
    public void test4evaluate() {
        m = new Monomial(1, new RationalScalar(3, 4));
        Scalar s = new RationalScalar(2, 1);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 3/2", "3/2", result.toString());
    }
    @Test
    public void test5evaluate() {
        m = new Monomial(2, new IntegerScalar(0));
        Scalar s = new RationalScalar(5, 3);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test6evaluate() {
        m = new Monomial(0, new RationalScalar(7, 3));
        Scalar s = new RationalScalar(3, 7);
        Scalar result = m.evaluate(s);
        Assert.assertEquals("Result should be 7/3", "7/3", result.toString());
    }
    @Test
    public void test1derivative() {
        m = new Monomial(3, new IntegerScalar(4));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 12x^2", "12x^2", result.toString());
    }
    @Test
    public void test2derivative() {
        m = new Monomial(1, new IntegerScalar(5));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 5", "5", result.toString());
    }
    @Test
    public void test3derivative() {
        m = new Monomial(0, new IntegerScalar(7));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test4derivative() {
        m = new Monomial(2, new RationalScalar(3, 4));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 3/2x", "3/2x", result.toString());
    }
    @Test
    public void test5derivative() {
        m = new Monomial(1, new RationalScalar(5, 6));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 5/6", "5/6", result.toString());
    }
    @Test
    public void test6derivative() {
        m = new Monomial(0, new RationalScalar(7, 3));
        Monomial result = m.derivative();
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test1sign() {
        m = new Monomial(2, new IntegerScalar(3));
        Assert.assertEquals("Sign should be 1", 1, m.sign());
    }
    @Test
    public void test2sign() {
        m = new Monomial(2, new IntegerScalar(-3));
        Assert.assertEquals("Sign should be -1", -1, m.sign());
    }
    @Test
    public void test3sign() {
        m = new Monomial(2, new IntegerScalar(0));
        Assert.assertEquals("Sign should be 0", 0, m.sign());
    }
    @Test
    public void test4sign() {
        m = new Monomial(2, new RationalScalar(3, 4));
        Assert.assertEquals("Sign should be 1", 1, m.sign());
    }
    @Test
    public void test5sign() {
        m = new Monomial(2, new RationalScalar(-5, 6));
        Assert.assertEquals("Sign should be -1", -1, m.sign());
    }
    @Test
    public void test6sign() {
        m = new Monomial(2, new RationalScalar(0, 1));
        Assert.assertEquals("Sign should be 0", 0, m.sign());
    }
    @Test
    public void test1equalsMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(3));
        Assert.assertEquals("Monomials should be equal", m1, m2);
    }
    @Test
    public void test2equalsMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(3));
        Assert.assertNotEquals("Monomials should not be equal", m1, m2);
    }
    @Test
    public void test3equalsMonomial() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Object m2 = "Not a Monomial";
        Assert.assertNotEquals("Monomial should not be equal to a non-Monomial object", m1, m2);
    }
    @Test
    public void test4equalsMonomial() {
        Monomial m1 = new Monomial(2, new RationalScalar(3, 4));
        Monomial m2 = new Monomial(2, new RationalScalar(3, 4));
        Assert.assertEquals("Monomials should be equal", m1, m2);
    }
    @Test
    public void test5equalsMonomial() {
        Monomial m1 = new Monomial(2, new RationalScalar(3, 4));
        Monomial m2 = new Monomial(2, new RationalScalar(5, 6));
        Assert.assertNotEquals("Monomials should not be equal", m1, m2);
    }
    @Test
    public void test6equalsMonomial() {
        Monomial m1 = new Monomial(2, new RationalScalar(3, 4));
        Monomial m2 = new Monomial(3, new RationalScalar(3, 4));
        Assert.assertNotEquals("Monomials should not be equal", m1, m2);
    }
}
