import java.util.Map;
import java.util.TreeMap;

/**
 * ExpressionsTest class, includes a main class.
 */
public class ExpressionsTest {
    /**
     * main method.
     * @param args args
     */
    public static void main(String[] args) {
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        Map<String, Boolean> ass = new TreeMap<>();
        ass.put("x", false);
        ass.put("y", true);
        ass.put("z", false);
        Expression e1 = new And(new Xor(new And(x, new Val(false)), new Or(y, new Val(false))), z);
        System.out.println(e1);
        try {
            System.out.println(e1.evaluate(ass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(e1.nandify());
        System.out.println(e1.norify());
        System.out.println(e1.simplify());
    }
}
