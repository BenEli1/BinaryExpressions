//319086435
import java.util.LinkedList;
import java.util.List;
/**
 * @author Ben Binyamin Eli
 * UnaryExpression class.
 */
abstract class UnaryExpression extends BaseExpression {
    private Expression x;
    /**
     * getter for x.
     * @return this.x
     */
    public Expression getX() {
        return this.x;
    }

    /**
     * Constructor.
     * @param x first Expression
     */
    protected UnaryExpression(Expression x) {
        this.x = x;
    }
    /**
     * getVariables method.
     * @return Returns a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList<String>();
        List<String> xList = this.x.getVariables();
        int first = 0;
        while (xList.size() > 0) {
            if (!(l.contains(xList.get(first)))) {
                l.add(xList.get(first));
            }
            xList.remove(first);
        }
        return l;
    }
    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    public String toString() {
        return getX().toString();
    }
}
