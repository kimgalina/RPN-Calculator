/**
 * The `Model` class represents the core logic of a calculator application.
 * It manages the calculator's state, processes user input, and performs calculations.
 *
 * This class maintains the current infix expression, the full expression, and the Reverse
 * Polish Notation (RPN) calculator for evaluating expressions. It also interacts with a
 * viewer component to display the current state of the calculator.
 *
 */
public class Model{

    private Viewer viewer;        // Instance of Viewer for displaying results
    private String infixString;   // The string that contains infix form of expression
    private RPN rpn;             // Reverse Polish Notation calculator
    private boolean isDotSet;   // Flag to track if a decimal point is set
    private Stack<Character> stack;  // stack for managing parentheses

    /**
     * Constructs a new `Model` instance.
     *
     * @param viewer The viewer component responsible for displaying calculator output.
     */
     Model(Viewer viewer){
        this.viewer = viewer;
        rpn = new RPN();
        infixString = "";
        isDotSet = false;
        stack = new Stack<>();
    }

    /**
     * Deletes the last character in the infix expression if it is not empty.
     */
    private void  deleteLastChar(){
        if(!infixString.isEmpty()){
            infixString = infixString.substring(0,infixString.length() - 1);
        }
    }

    /**
     * Checks if a character is an operand (digit).
     *
     * @param input The character to check.
     * @return True if the character is an operand; otherwise, false.
     */
    private boolean isOperand(char symbol){
        return Character.isDigit(symbol);
    }

    /**
     * Checks if a character is an operation (+, -, *, /).
     *
     * @param input The character to check.
     * @return True if the character is an operator; otherwise, false.
     */
    private boolean isOperation(char symbol){
        return symbol == '*' || symbol == '/' || symbol == '-' || symbol == '+';
    }


    /**
     * Handles an operand  in the infix expression.
     *
     * @param symbol   The  symbol to handle.
     * @param lastChar The last character in the infix expression.
     */
    private void handleOperand(char symbol,char lastChar){
        if (lastChar == ')') {
            infixString += "*" + symbol;
        } else {
            infixString += symbol;
        }
    }

    /**
     * Handles an operation symbol in the infix expression.
     *
     * @param symbol   The operator symbol to handle.
     * @param lastChar The last character in the infix expression.
     */
    private void handleOperation(char symbol,char lastChar){
        isDotSet = false;

       if (infixString.isEmpty() && symbol == '-') {
           infixString += "0" + symbol;///////////
       } else if (isOperation(lastChar)) {
           deleteLastChar();
           infixString += symbol;
       } else if (lastChar == '(' && symbol == '-') {
           infixString += symbol;
       } else if (isOperand(lastChar)) {
           infixString += symbol;
       } else if (lastChar == ')') {
           infixString += symbol;
       }

    }


    /**
     * Handles another symbol (parentheses or decimal point) in the infix expression.
     *
     * @param symbol   The special symbol to handle.
     * @param lastChar The last character in the infix expression.
     */
    private void handleSymbol(char symbol,char lastChar){
        if (symbol == '(') {
            if (isOperand(lastChar) || lastChar == ')') {
                infixString += "*" + symbol;
                stack.push('(');
                isDotSet = false;
            } else if (lastChar != '.') {
                infixString += symbol;
                stack.push('(');
            }
        } else if (symbol == ')' && "+-*/".indexOf(lastChar) == -1 && isOperand(lastChar)) {
            if (!stack.isEmpty()) {
                infixString += symbol;
                stack.pop();
            }
        } else if (symbol == '.' && !isDotSet) {
            infixString += symbol;
            isDotSet = true;
        }

    }

    /**
     * Handles action (operand, operation or  other symbol) in the infix expression.
     *
     * @param actionCommand The action to handle.
     */
    private void handleAction(String actionCommand){
        char lastChar = infixString.isEmpty() ? '&' : infixString.charAt(infixString.length() - 1);
        char symbol = actionCommand.charAt(0);
        if(isOperation(symbol)){
            handleOperation(symbol,lastChar);

        }else if(isOperand(symbol)){
            handleOperand(symbol,lastChar);

        }else{
            handleSymbol(symbol,lastChar);

        }
    }

    /**
     * Closes all open parentheses in the infix expression.
     */
    private void closeAllBrackets(){
        while(!stack.isEmpty()){
            stack.pop();
            infixString += ")";
        }
    }

    /**
     * Performs an action based on the provided actionCommand.
     *
     * @param actionCommand The command representing a user action or input.
     */
     public void doAction(String actionCommand){
         // Handle different symbols and update the calculator's state
        switch(actionCommand){
            case "clear":
                infixString = "";
                break;
            case "delete":
                deleteLastChar();
                break;
            case "equal":
                closeAllBrackets();
                rpn.translateToPostfix(infixString);// initializing field postfixString
                Double result = rpn.calculate();
                String resultStr = resultFormat(result);
                viewer.update(resultStr,infixString + " = ");
                infixString = "";

                return;
            default:
                handleAction(actionCommand);
                break;
        }
        // Update the viewer with the current calculator state
        viewer.update(infixString,"0");

    }
    /**
     * Converts a Double result to a formatted String, removing trailing zeros and decimal point
     * if necessary.
     *
     * @param result The Double result to convert.
     * @return The formatted result as a String.
     */

    private String resultFormat(Double result){
        String stringResult = String.valueOf(result);
        char expectedPoint = stringResult.charAt(stringResult.length() - 2);
        char expectedZero = stringResult.charAt(stringResult.length() - 1);

        if (expectedPoint == '.' && expectedZero == '0') {
            return stringResult.substring(0, stringResult.length() - 2);
        } else {
            return stringResult;
        }
    }
}
