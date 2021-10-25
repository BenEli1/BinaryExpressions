//319086435
import java.util.LinkedList;
import java.util.List;
/**
 * @author Ben Binyamin Eli
 * BinaryExpression class.
 */
abstract class BinaryExpression extends BaseExpression {
    private Expression x;
    private Expression y;

    /**
     * getter for x.
     * @return this.x
     */
    public Expression getX() {
        return this.x;
    }
    /**
     * getter for y.
     * @return this.y
     */
    public Expression getY() {
        return y;
    }

    /**
     * Constructor.
     * @param x first Expression.
     * @param y second Expression.
     */
    protected BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }
    /**
     * getVariables method.
     * @return Returns a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList<String>();
        List<String> xList = this.x.getVariables();
        List<String> yList = this.y.getVariables();
        int first = 0;
        while (xList.size() > 0) {
            if (!(l.contains(xList.get(first)))) {
                l.add(xList.get(first));
            }
            xList.remove(first);
        }
        while (yList.size() > 0) {
            if (!(l.contains(yList.get(first)))) {
                l.add(yList.get(first));
            }
            yList.remove(first);
        }
        return l;
    }
}

