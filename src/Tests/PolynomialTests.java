package Tests;
import main_pkg.*;
import org.junit.*;

public class PolynomialTests {
    private Polynomial p;

    @Test
    public void test1build() {
        p = Polynomial.build("3 0 4");
        Assert.assertEquals("Result should be 3+4x^2", "3+4x^2", p.toString());
    }
    @Test
    public void test2build() {
        p = Polynomial.build("1/2 0 3/4");
        Assert.assertEquals("Result should be 1/2+3/4x^2", "1/2+3/4x^2", p.toString());
    }
    @Test
    public void test3build() {
        p = Polynomial.build("-2 0 0");
        Assert.assertEquals("Result should be -2", "-2", p.toString());
    }
    @Test
    public void test4build() {
        p = Polynomial.build("5 1/3 0 8 -10 -11/9");
        Assert.assertEquals("Result should be 5+1/3x+8x^3-10x^4-11/9x^5", "5+1/3x+8x^3-10x^4-11/9x^5", p.toString());
    }
    @Test
    public void test5build() {
        p = Polynomial.build("0 0 7/8");
        Assert.assertEquals("Result should be 7/8x^2", "7/8x^2", p.toString());
    }
    @Test
    public void test6build() {
        Polynomial p = Polynomial.build("2 -2 -7/8");
        Assert.assertEquals("Result should be 2-2x-7/8x^2", "2-2x-7/8x^2", p.toString());
    }
    @Test
    public void test7build() {
        p = Polynomial.build("9 10 11");
        Assert.assertEquals("Result should be 9+10x+11x^2", "9+10x+11x^2", p.toString());
    }
    @Test
    public void test1toString() {
        p = Polynomial.build("3 -2 4");
        Assert.assertEquals("Result should be 3-2x+4x^2", "3-2x+4x^2", p.toString());
    }
    @Test
    public void test2toString() {
        p = Polynomial.build("-1/2 0 3/4");
        Assert.assertEquals("Result should be -1/2+3/4x^2", "-1/2+3/4x^2", p.toString());
    }
    @Test
    public void test3toString() {
        p = Polynomial.build("0 -5 0");
        Assert.assertEquals("Result should be -5x", "-5x", p.toString());
    }
    @Test
    public void test4toString() {
        p = Polynomial.build("5 -1/3 0");
        Assert.assertEquals("Result should be 5-1/3x", "5-1/3x", p.toString());
    }
    @Test
    public void test5toString() {
        p = Polynomial.build("1 -2 3 -4 5 -6 7 8");
        Assert.assertEquals("Result should be 1-2x+3x^2-4x^3+5x^4-6x^5+7x^6+8x^7", "1-2x+3x^2-4x^3+5x^4-6x^5+7x^6+8x^7", p.toString());
    }
    @Test
    public void test6toString() {
        p = Polynomial.build("-2 3 -4");
        Assert.assertEquals("Result should be -2+3x-4x^2", "-2+3x-4x^2", p.toString());
    }
    @Test
    public void test1add() {
        Polynomial p1 = Polynomial.build("3 -2 4 5");
        Polynomial p2 = Polynomial.build("1 2 -4 6");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 4+0x+0x^2+11x^3", "4+11x^3", result.toString());
    }
    @Test
    public void test2add() {
        Polynomial p1 = Polynomial.build("1/2 -1/3 3/4 2");
        Polynomial p2 = Polynomial.build("1/3 1/3 -1/4 -1");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 5/6+1/2x^2+x^3", "5/6+1/2x^2+x^3", result.toString());
    }
    @Test
    public void test3add() {
        Polynomial p1 = Polynomial.build("5 -3 2 7");
        Polynomial p2 = Polynomial.build("-2 4 -1 3");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 3+x+x^2+10x^3", "3+x+x^2+10x^3", result.toString());
    }
    @Test
    public void test4add() {
        Polynomial p1 = Polynomial.build("4 0 -3 2 5");
        Polynomial p2 = Polynomial.build("-1 3 1 -2 -4");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 3+3x-2x^2+0x^3+1x^4", "3+3x-2x^2+x^4", result.toString());
    }
    @Test
    public void test5add() {
        Polynomial p1 = Polynomial.build("1 2 3 4 5");
        Polynomial p2 = Polynomial.build("5 4 3 2 1");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 6+6x+6x^2+6x^3+6x^4", "6+6x+6x^2+6x^3+6x^4", result.toString());
    }
    @Test
    public void test6add() {
        Polynomial p1 = Polynomial.build("1 0 0 0 0 0 1 1");
        Polynomial p2 = Polynomial.build("2 3 4 5 6 7 8 9");
        Polynomial result = p1.add(p2);
        Assert.assertEquals("Result should be 3+3x+4x^2+5x^3+6x^4+7x^5+9x^6+10x^7", "3+3x+4x^2+5x^3+6x^4+7x^5+9x^6+10x^7", result.toString());
    }
    @Test
    public void test1mul() {
        Polynomial p1 = Polynomial.build("3 -2 4");
        Polynomial p2 = Polynomial.build("1 2 -4");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be 3+4x-12x^2+16x^3-16x^4", "3+4x-12x^2+16x^3-16x^4", result.toString());
    }
    @Test
    public void test2mul() {
        Polynomial p1 = Polynomial.build("1/2 -1/3 3/4");
        Polynomial p2 = Polynomial.build("1/2 1/3 -3/4");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be 1/4-1/9x^2+1/2x^3-9/16x^4", "1/4-1/9x^2+1/2x^3-9/16x^4", result.toString());
    }
    @Test
    public void test3mul() {
        Polynomial p1 = Polynomial.build("0 0 0 5");
        Polynomial p2 = Polynomial.build("0 0 0 -5");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be -25x^6", "-25x^6", result.toString());
    }
    @Test
    public void test4mul() {
        Polynomial p1 = Polynomial.build("5 -1/3 0 7");
        Polynomial p2 = Polynomial.build("-5 1/3 0 -7");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be -25+10/3x-1/9x^2-70x^3+14/3x^4-49x^6", "-25+10/3x-1/9x^2-70x^3+14/3x^4-49x^6", result.toString());
    }
    @Test
    public void test5mul() {
        Polynomial p1 = Polynomial.build("1 2 3 4 5");
        Polynomial p2 = Polynomial.build("-1 -2 -3 -4 -5");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be -1-4x-10x^2-20x^3-35x^4-44x^5-46x^6-40x^7-25x^8", "-1-4x-10x^2-20x^3-35x^4-44x^5-46x^6-40x^7-25x^8", result.toString());
    }
    @Test
    public void test6mul() {
        Polynomial p1 = Polynomial.build("1 0 0 0 0 0 0 1");
        Polynomial p2 = Polynomial.build("0 0 0 0 0 0 0 -1");
        Polynomial result = p1.mul(p2);
        Assert.assertEquals("Result should be -x^7-x^14", "-x^7-x^14", result.toString());
    }
    @Test
    public void test1evaluate() {
        p = Polynomial.build("3 0 4");
        Scalar s = new IntegerScalar(2);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 19", "19", result.toString());
    }
    @Test
    public void test2evaluate() {
        p = Polynomial.build("1/2 0 3/4");
        Scalar s = new IntegerScalar(2);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 7/2", "7/2", result.toString());
    }
    @Test
    public void test3evaluate() {
        p = Polynomial.build("0 0 0");
        Scalar s = new IntegerScalar(10);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test4evaluate() {
        p = Polynomial.build("5 1/3 0");
        Scalar s = new RationalScalar(3, 1);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 6", "6", result.toString());
    }
    @Test
    public void test5evaluate() {
        p = Polynomial.build("0 0 0 7/8");
        Scalar s = new RationalScalar(2, 1);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 7", "7", result.toString());
    }
    @Test
    public void test6evaluate() {
        p = Polynomial.build("2 0 0");
        Scalar s = new RationalScalar(5, 3);
        Scalar result = p.evaluate(s);
        Assert.assertEquals("Result should be 2", "2", result.toString());
    }
    @Test
    public void test1derivative() {
        p = Polynomial.build("3 0 4");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 8x", "8x", result.toString());
    }
    @Test
    public void test2derivative() {
        p = Polynomial.build("1/2 0 3/4");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 3/2x", "3/2x", result.toString());
    }
    @Test
    public void test3derivative() {
        p = Polynomial.build("0 0 0");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 0", "0", result.toString());
    }
    @Test
    public void test4derivative() {
        p = Polynomial.build("5 1/3 0");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 1/3", "1/3", result.toString());
    }
    @Test
    public void test5derivative() {
        p = Polynomial.build("0 0 7/8");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 7/4x", "7/4x", result.toString());
    }
    @Test
    public void test6derivative() {
        p = Polynomial.build("2 3 4 5 6 7 8 9");
        Polynomial result = p.derivative();
        Assert.assertEquals("Result should be 3+8x+15x^2+24x^3+35x^4+48x^5+63x^6", "3+8x+15x^2+24x^3+35x^4+48x^5+63x^6", result.toString());
    }
    @Test
    public void test1equals() {
        Polynomial p1 = Polynomial.build("3 -2 4 5");
        Polynomial p2 = Polynomial.build("3 -2 4 5");
        Assert.assertEquals("Polynomials should be equal", p1, p2);
    }
    @Test
    public void test2equals() {
        Polynomial p1 = Polynomial.build("1/2 -1/3 3/4 2");
        Polynomial p2 = Polynomial.build("1/2 -1/3 3/4 2");
        Assert.assertEquals("Polynomials should be equal", p1, p2);
    }
    @Test
    public void test3equals() {
        Polynomial p1 = Polynomial.build("5 -3 2 7");
        Polynomial p2 = Polynomial.build("5 -3 2 7");
        Assert.assertEquals("Polynomials should be equal", p1, p2);
    }
    @Test
    public void test4equals() {
        Polynomial p1 = Polynomial.build("3 -2 4 5");
        Polynomial p2 = Polynomial.build("3 -2 4 6");
        Assert.assertNotEquals("Polynomials should not be equal", p1, p2);
    }
    @Test
    public void test5equals() {
        Polynomial p1 = Polynomial.build("1/2 -1/3 3/4 2");
        Polynomial p2 = Polynomial.build("1/2 -1/3 3/4 3");
        Assert.assertNotEquals("Polynomials should not be equal", p1, p2);
    }
    @Test
    public void test6equals() {
        Polynomial p1 = Polynomial.build("5 -3 2 7");
        Polynomial p2 = Polynomial.build("5 -3 2");
        Assert.assertNotEquals("Polynomials should not be equal", p1, p2);
    }
}
