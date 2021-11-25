import java.util.Map;
/**
 * @author Ben Binyamin Eli
 * Not class.
 */
public class Not extends UnaryExpression {
    /**
     * Constructor.
     * @param x first Expression
     */
    public Not(Expression x) {
        super(x);
    }
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     *  is thrown.
     * @param assignment a mapping which assigns variables to boolean values.
     * @return boolean result
     * @throws Exception if can't evaluate
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            return !getX().evaluate(assignment);
        } catch (Exception e) {
            throw new Exception("can't evaluate");
        }
    }
    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return evaluates the boolean value of the expression.
     * @throws Exception when can't evaluate.
     */
    @Override
    public Boolean evaluate() throws Exception {
        try {
            return !getX().evaluate();
        } catch (Exception e) {
            throw new Exception("can't evaluate");
        }
    }

    /**
     * // Returns a list of the variables in the expression.
     *
     * @return
     */

    /**
     *  Returns a new expression in which all occurrences of the variable
     *  var are replaced with the provided expression (Does not modify the
     *  current expression).
     * @param var varible to replace.
     * @param expression expression to put in the varibale.
     * @return returns new replaced expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(getX().assign(var, expression));
    }
    /**
     * nandify method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        //nandify first and then return nandified expression.
        Expression nandX = getX().nandify();
        return new Nand(nandX, nandX);
    }
    /**
     * noritfy method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        //norify first and then return norified expression.
        Expression norX = getX().norify();
        return new Nor(norX, norX);
    }

    /**
     * simplify method.
     * @return Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        //simplify first expression,then check the redundant situations.
        Expression simpleExp = new Not(getX().simplify());
        String strX = getX().simplify().toString();
        if (strX.equals("T")) {
            return new Val(false);
        }
        if (strX.equals("F")) {
            return new Val(true);
        }
        return simpleExp;
    }
    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    public String toString() {
        return "~(" + super.toString() + ")";
    }
}
