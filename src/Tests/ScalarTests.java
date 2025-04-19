package Tests;
import main_pkg.*;
import org.junit.*;

public class ScalarTests {
    private Scalar scalar;

    @Test
    public void test1toString(){
        scalar = new IntegerScalar(1);
        Assert.assertEquals("scalar should be 1", "1", scalar.toString());
    }
    @Test
    public void test2toString(){
        scalar = new IntegerScalar(991);
        Assert.assertEquals("scalar should be 991", "991", scalar.toString());
    }
    @Test
    public void test3toString(){
        scalar = new IntegerScalar(-3);
        Assert.assertEquals("scalar should be -3", "-3", scalar.toString());
    }
    @Test
    public void test4toString(){
        scalar = new RationalScalar(1, 10);
        Assert.assertEquals("scalar should be 1/10", "1/10", scalar.toString());
    }
    @Test
    public void test5toString(){
        scalar = new RationalScalar(12, -4);
        Assert.assertEquals("scalar should be -3", "-3", scalar.toString());
    }
    @Test
    public void test6toString(){
        scalar = new RationalScalar(0,-3);
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test1add(){
        scalar = new IntegerScalar(1);
        Scalar s = new IntegerScalar(100);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be 101", "101", scalar.toString());
    }
    @Test
    public void test2add(){
        scalar = new IntegerScalar(8);
        Scalar s = new RationalScalar(4,2);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be 10", "10", scalar.toString());
    }
    @Test
    public void test3add(){
        scalar = new IntegerScalar(-5);
        Scalar s = new RationalScalar(12,4);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be -2", "-2", scalar.toString());
    }
    @Test
    public void test4add(){
        scalar = new RationalScalar(1,  10);
        Scalar s = new IntegerScalar(100);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be 1001/10", "1001/10", scalar.toString());
    }
    @Test
    public void test5add(){
        scalar = new RationalScalar(8, 3);
        Scalar s = new RationalScalar(4,3);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be 4", "4", scalar.toString());
    }
    @Test
    public void test6add(){
        scalar = new IntegerScalar(0);
        Scalar s = new RationalScalar(0,4);
        scalar = scalar.add(s);
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test1addInteger(){
        scalar = new IntegerScalar(0);
        scalar = scalar.add(new IntegerScalar(100));
        Assert.assertEquals("scalar should be 100", "100", scalar.toString());
    }
    @Test
    public void test2addInteger(){
        scalar = new IntegerScalar(-1000);
        scalar = scalar.add(new IntegerScalar(5));
        Assert.assertEquals("scalar should be -995", "-995", scalar.toString());
    }
    @Test
    public void test3addInteger(){
        scalar = new IntegerScalar(500);
        scalar = scalar.add(new IntegerScalar(195));
        Assert.assertEquals("scalar should be 695", "695", scalar.toString());
    }
    @Test
    public void test4addInteger(){
        scalar = new RationalScalar(10 ,3);
        scalar = scalar.add(new IntegerScalar(20));
        Assert.assertEquals("scalar should be 70/3", "70/3", scalar.toString());
    }
    @Test
    public void test5addInteger(){
        scalar = new RationalScalar(-5 ,4);
        scalar = scalar.add(new IntegerScalar(1));
        Assert.assertEquals("scalar should be equals to -1/4", "-1/4", scalar.toString());
    }
    @Test
    public void test6addInteger(){
        scalar = new RationalScalar(500 , 11);
        scalar = scalar.add(new IntegerScalar(1));
        Assert.assertEquals("scalar should be 511/11", "511/11", scalar.toString());
    }
    @Test
    public void test1addRational(){
        scalar = new IntegerScalar(18);
        scalar = scalar.add(new RationalScalar(18,9));
        Assert.assertEquals("scalar should be 20", "20", scalar.toString());
    }
    @Test
    public void test2addRational(){
        scalar = new IntegerScalar(-10);
        scalar = scalar.add(new RationalScalar(17,9));
        Assert.assertEquals("scalar should be -73/9", "-73/9", scalar.toString());
    }
    @Test
    public void test3addRational(){
        scalar = new IntegerScalar(-7);
        scalar = scalar.add(new RationalScalar(-18,9));
        Assert.assertEquals("scalar should be -9", "-9", scalar.toString());
    }
    @Test
    public void test4addRational(){
        scalar = new RationalScalar(91,9);
        scalar = scalar.add(new RationalScalar(18,9));
        Assert.assertEquals("scalar should be 109/9", "109/9", scalar.toString());
    }
    @Test
    public void test5addRational(){
        scalar = new RationalScalar(10,7);
        scalar = scalar.add(new RationalScalar(-17,9));
        Assert.assertEquals("scalar should be -29/63", "-29/63", scalar.toString());
    }
    @Test
    public void test6addRational(){
        scalar = new RationalScalar(-7,3);
        scalar = scalar.add(new RationalScalar(-11, 5));
        Assert.assertEquals("scalar should be -68/15", "-68/15", scalar.toString());
    }
    @Test
    public void test1mul() {
        scalar = new IntegerScalar(2);
        Scalar s = new IntegerScalar(3);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be 6", "6", scalar.toString());
    }
    @Test
    public void test2mul() {
        scalar = new IntegerScalar(5);
        Scalar s = new RationalScalar(3, 2);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be 15/2", "15/2", scalar.toString());
    }
    @Test
    public void test3mul() {
        scalar = new RationalScalar(4, 3);
        Scalar s = new RationalScalar(3, 2);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be 2", "2", scalar.toString());
    }
    @Test
    public void test4mul() {
        scalar = new RationalScalar(-5, 4);
        Scalar s = new RationalScalar(8, 30);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be -1/3", "-1/3", scalar.toString());
    }
    @Test
    public void test5mul() {
        scalar = new RationalScalar(7, 3);
        Scalar s = new RationalScalar(-9, 14);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be -3/2", "-3/2", scalar.toString());
    }
    @Test
    public void test6mul() {
        scalar = new IntegerScalar(0);
        Scalar s = new RationalScalar(5, 7);
        scalar = scalar.mul(s);
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test1mulInteger() {
        scalar = new IntegerScalar(3);
        scalar = scalar.mulInteger(new IntegerScalar(4));
        Assert.assertEquals("scalar should be 12", "12", scalar.toString());
    }
    @Test
    public void test2mulInteger() {
        scalar = new IntegerScalar(-7);
        scalar = scalar.mulInteger(new IntegerScalar(5));
        Assert.assertEquals("scalar should be -35", "-35", scalar.toString());
    }
    @Test
    public void test3mulInteger() {
        scalar = new RationalScalar(10, 3);
        scalar = scalar.mulInteger(new IntegerScalar(6));
        Assert.assertEquals("scalar should be 20", "20", scalar.toString());
    }
    @Test
    public void test4mulInteger() {
        scalar = new RationalScalar(-5, 8);
        scalar = scalar.mulInteger(new IntegerScalar(16));
        Assert.assertEquals("scalar should be -10", "-10", scalar.toString());
    }
    @Test
    public void test5mulInteger() {
        scalar = new IntegerScalar(0);
        scalar = scalar.mulInteger(new IntegerScalar(100));
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test6mulInteger() {
        scalar = new RationalScalar(7, 11);
        scalar = scalar.mulInteger(new IntegerScalar(-11));
        Assert.assertEquals("scalar should be -7", "-7", scalar.toString());
    }
    @Test
    public void test1mulRational() {
        scalar = new IntegerScalar(5);
        scalar = scalar.mulRational(new RationalScalar(3, 2));
        Assert.assertEquals("scalar should be 15/2", "15/2", scalar.toString());
    }
    @Test
    public void test2mulRational() {
        scalar = new RationalScalar(4, 3);
        scalar = scalar.mulRational(new RationalScalar(3, 2));
        Assert.assertEquals("scalar should be 2", "2", scalar.toString());
    }
    @Test
    public void test3mulRational() {
        scalar = new RationalScalar(-5, 4);
        scalar = scalar.mulRational(new RationalScalar(8, 3));
        Assert.assertEquals("scalar should be -10/3", "-10/3", scalar.toString());
    }
    @Test
    public void test4mulRational() {
        scalar = new RationalScalar(7, 3);
        scalar = scalar.mulRational(new RationalScalar(-9, 14));
        Assert.assertEquals("scalar should be -3/2", "-3/2", scalar.toString());
    }
    @Test
    public void test5mulRational() {
        scalar = new IntegerScalar(0);
        scalar = scalar.mulRational(new RationalScalar(5, 7));
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test6mulRational() {
        scalar = new RationalScalar(7, 11);
        scalar = scalar.mulRational(new RationalScalar(-11, 7));
        Assert.assertEquals("scalar should be -1", "-1", scalar.toString());
    }
    @Test
    public void test1neg() {
        scalar = new IntegerScalar(5);
        scalar = scalar.neg();
        Assert.assertEquals("scalar should be -5", "-5", scalar.toString());
    }
    @Test
    public void test2neg() {
        scalar = new IntegerScalar(-10);
        scalar = scalar.neg();
        Assert.assertEquals("scalar should be 10", "10", scalar.toString());
    }
    @Test
    public void test3neg() {
        scalar = new RationalScalar(7, 3);
        scalar = scalar.neg();
        Assert.assertEquals("scalar should be -7/3", "-7/3", scalar.toString());
    }
    @Test
    public void test4neg() {
        scalar = new RationalScalar(-4, 5);
        scalar = scalar.neg();
        Assert.assertEquals("scalar should be 4/5", "4/5", scalar.toString());
    }
    @Test
    public void test5neg() {
        scalar = new IntegerScalar(0);
        scalar = scalar.neg();
        Assert.assertEquals("scalar should be 0", "0", scalar.toString());
    }
    @Test
    public void test1power() {
        scalar = new IntegerScalar(2);
        scalar = scalar.power(3);
        Assert.assertEquals("scalar should be 8", "8", scalar.toString());
    }
    @Test
    public void test2power() {
        scalar = new IntegerScalar(-3);
        scalar = scalar.power(2);
        Assert.assertEquals("scalar should be 9", "9", scalar.toString());
    }
    @Test
    public void test3power() {
        scalar = new RationalScalar(2, 3);
        scalar = scalar.power(3);
        Assert.assertEquals("scalar should be 8/27", "8/27", scalar.toString());
    }
    @Test
    public void test4power() {
        scalar = new RationalScalar(-1, 2);
        scalar = scalar.power(3);
        Assert.assertEquals("scalar should be -1/8", "-1/8", scalar.toString());
    }
    @Test
    public void test5power() {
        scalar = new IntegerScalar(5);
        scalar = scalar.power(0);
        Assert.assertEquals("scalar should be 1", "1", scalar.toString());
    }
    @Test
    public void test6power() {
        scalar = new RationalScalar(3, 4);
        scalar = scalar.power(2);
        Assert.assertEquals("scalar should be 9/16", "9/16", scalar.toString());
    }
    @Test
    public void test1sign() {
        scalar = new IntegerScalar(5);
        Assert.assertEquals("sign should be 1", 1, scalar.sign());
    }
    @Test
    public void test2sign() {
        scalar = new IntegerScalar(-10);
        Assert.assertEquals("sign should be -1", -1, scalar.sign());
    }
    @Test
    public void test3sign() {
        scalar = new IntegerScalar(0);
        Assert.assertEquals("sign should be 0", 0, scalar.sign());
    }
    @Test
    public void test4sign() {
        scalar = new RationalScalar(7, 3);
        Assert.assertEquals("sign should be 1", 1, scalar.sign());
    }
    @Test
    public void test5sign() {
        scalar = new RationalScalar(-4, 5);
        Assert.assertEquals("sign should be -1", -1, scalar.sign());
    }
    @Test
    public void test6sign() {
        scalar = new RationalScalar(1, 1);
        Assert.assertEquals("sign should be 1", 1, scalar.sign());
    }
    @Test
    public void test1equals() {
        scalar = new IntegerScalar(5);
        Scalar other = new IntegerScalar(5);
        Assert.assertEquals("scalars should be equal", scalar, other);
    }
    @Test
    public void test2equals() {
        scalar = new IntegerScalar(5);
        Scalar other = new IntegerScalar(-5);
        Assert.assertNotEquals("scalars should not be equal", scalar, other);
    }
    @Test
    public void test3equals() {
        scalar = new RationalScalar(4, 2);
        Scalar other = new IntegerScalar(2);
        Assert.assertEquals("scalars should be equal", scalar, other);
    }
    @Test
    public void test4equals() {
        scalar = new RationalScalar(7, 3);
        Scalar other = new RationalScalar(14, 6);
        Assert.assertEquals("scalars should be equal", scalar, other);
    }
    @Test
    public void test5equals() {
        scalar = new RationalScalar(7, 3);
        Scalar other = new RationalScalar(7, 4);
        Assert.assertNotEquals("scalars should not be equal", scalar, other);
    }
    @Test
    public void test6equals() {
        scalar = new IntegerScalar(0);
        Scalar other = new RationalScalar(0, 1);
        Assert.assertEquals("scalars should be equal", scalar, other);
    }
    @Test
    public void test7equals() {
        scalar = new IntegerScalar(5);
        Object other = "Not a scalar";
        Assert.assertNotEquals("scalar should not be equal to a non-scalar object", scalar, other);
    }
    @Test
    public void test1reduce() {
        RationalScalar scalar1 = new RationalScalar(6,3);
        scalar1 = scalar1.reduce();
        Assert.assertEquals("scalars should be 2", "2", scalar1.toString());
    }
    @Test
    public void test2reduce() {
        RationalScalar scalar1 = new RationalScalar(5,-10);
        scalar1 = scalar1.reduce();
        Assert.assertEquals("scalars should be -1/2", "-1/2", scalar1.toString());
    }
    @Test
    public void test3reduce() {
        RationalScalar scalar1 = new RationalScalar(-100,-10);
        scalar1 = scalar1.reduce();
        Assert.assertEquals("scalars should be equal", "10" ,scalar1.toString());
    }
    @Test
    public void test4reduce() {
        RationalScalar scalar1 = new RationalScalar(7, 3);
        scalar1 = scalar1.reduce();
        Assert.assertEquals("scalars should be equal", "7/3" ,scalar1.toString());
    }
}
