public class Model{

    private Viewer viewer;
    private String infixString;
    private RPN rpn;
    private boolean isDotSet;
    private Stack<Character> stack;


    Model(Viewer viewer){
        this.viewer = viewer;
        rpn = new RPN();
        infixString = "";
        isDotSet = false;
        stack = new Stack<>();
    }
    private void  deleteLastChar(){
        if(!infixString.isEmpty()){
            infixString = infixString.substring(0,infixString.length() - 1);
        }
    }

    private boolean isOperand(char symbol){
        return Character.isDigit(symbol);
    }
    private boolean isOperation(char symbol){
        return symbol == '*' || symbol == '/' || symbol == '-' || symbol == '+';
    }
    private void handleOperand(char symbol,char lastChar){
        if (lastChar == ')') {
            infixString += "*" + symbol;
        } else {
            infixString += symbol;
        }
    }
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

    private void closeAllBrackets(){
        while(!stack.isEmpty()){
            stack.pop();
            infixString += ")";
        }
    }

    public void doAction(String actionCommand){
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
                return;
            default:
                handleAction(actionCommand);
                break;
        }

        viewer.update(infixString,"0");

    }

    private String resultFormat(Double result){
            //logic of formatting result
            return Double.toString(result);
    }
}
