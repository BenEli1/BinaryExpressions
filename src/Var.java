//319086435
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * @author Ben Binyamin Eli
 * Var class.
 */
public class Var implements Expression {
    private String varName;
    /**
     * Constructor.
     * @param varName varibale name
     */
    public Var(String varName) {
        this.varName = varName;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(this.varName)) {
            return assignment.get(this.varName);
        } else {
            throw new Exception("no key was found");
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
        throw new Exception("can't evauluate");
    }
    /**
     * getVariables method.
     * @return Returns a list of the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList<String>();
        l.add(this.varName);
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
        if (var.equals(this.varName)) {
            return (expression);
        }
        return new Var(this.varName);
    }
    /**
     * nandify method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    @Override
    public Expression nandify() {
        return new Var(this.varName);
    }
    /**
     * noritfy method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    @Override
    public Expression norify() {
        return new Var(this.varName);
    }

    /**
     * simplify method.
     * @return Returned a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        return new Var(this.varName);
    }
    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    @Override
    public String toString() {
        return this.varName;
    }
}
