//319086435
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * @author Ben Binyamin Eli
 * Val class.
 */
public class Val implements Expression {
    private boolean value;
    /**
     * Constructor.
     * @param value true/false.
     */
    public Val(boolean value) {
        this.value = value;
    }
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     *  is thrown.
     * @param assignment a mapping which assigns variables to boolean values.
     * @return boolean result
     * @throws Exception if can;t evaluate
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }
    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return evaluates the boolean value of the expression.
     * @throws Exception when can't evaluate.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return this.value;
    }
    /**
     * getVariables method.
     * @return Returns a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList<String>();
        return l;
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
        return new Val(this.value);
    }
    /**
     * nandify method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        return new Val(this.value);
    }
    /**
     * noritfy method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        return new Val(this.value);
    }

    /**
     * simplify method.
     * @return Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        return new Val(this.value);
    }
    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    @Override
    public String toString() {
        if (this.value) {
            return "T";
        }
            return "F";
    }
}
