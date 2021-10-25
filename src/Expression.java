//319086435
import java.util.Map;
import java.util.List;

/**
 * This represents Expression Inerface.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     *  is thrown.
     * @param assignment a mapping which assigns variables to boolean values.
     * @return boolean result
     * @throws Exception if can;t evaluate
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;


    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return evaluates the boolean value of the expression.
     * @throws Exception when can't evaluate.
     */
    Boolean evaluate() throws Exception;


    /**
     * getVariables method.
     * @return Returns a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * toString method.
     * @return Returns a nice string representation of the expression.
     */
    String toString();

    /**
     *  Returns a new expression in which all occurrences of the variable
     *  var are replaced with the provided expression (Does not modify the
     *  current expression).
     * @param var varible to replace.
     * @param expression expression to put in the varibale.
     * @return returns new replaced expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * nandify method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();
    /**
     * noritfy method.
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     *  simplify method.
      * @return Returned a simplified version of the current expression.
     */
    Expression simplify();
}