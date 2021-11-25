import java.util.Map;
/**
 * @author Ben Binyamin Eli
 * Or class.
 */
public class Or extends BinaryExpression  {
    /**
     * Constructor.
     * @param x first Expression
     * @param y second Expression
     */
    public Or(Expression x, Expression y) {
        super(x, y);
    }
    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    @Override
    public String toString() {
        return ("(" + getX().toString() + " | " + getY().toString() + ")");
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
            return getX().evaluate(assignment) || getY().evaluate(assignment);
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
            return getX().evaluate() || getY().evaluate();
        } catch (Exception e) {
            throw new Exception("can't evaluate");
        }
    }
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
        return new Or(getX().assign(var, expression), getY().assign(var, expression));
    }
    /**
     * nandify method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        //nandify first and second expression and then return nandified expression.
        Expression nandX = getX().nandify();
        Expression nandY = getY().nandify();
        return new Nand(new Nand(nandX, nandX), new Nand(nandY, nandY));
    }
    /**
     * noritfy method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        //norify first and second expression and then return norified expression.
        Expression norX = getX().norify();
        Expression norY = getY().norify();
        return new Nor(new Nor(norX, norY), new Nor(norX, norY));
    }

    /**
     * simplify method.
     * @return Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        //simplify first expression and second expression,then check the redundant situations.
        Expression simpleExp = new Or(getX().simplify(), getY().simplify());
        String strX = getX().simplify().toString();
        String strY = getY().simplify().toString();
        if (strX.equals("T") || strX.equals("F")) {
            if (strY.equals("T") || strY.equals("F")) {
                try {
                    return new Val(new Or(getX().simplify(), getY().simplify()).evaluate());
                } catch (Exception e) {
                    boolean xFlag = strX.equals("T");
                    boolean yFlag = strY.equals("T");
                    return new Val(xFlag || yFlag);
                }
            }
            if (strX.equals("T")) {
                return new Val(true);
            } else {
                return getY().simplify();
            }
        } else if (strY.equals("T")) {
            return new Val(true);
        } else if (strY.equals("F")) {
            return getX().simplify();
        }
        if (strX.equals(strY)) {
            return (getX()).simplify();
        }
        return simpleExp;
    }

}
