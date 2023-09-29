public class Model{
    private Viewer viewer;
    private String infixString;
    private RPN rpn;


    Model(Viewer viewer){
        this.viewer = viewer;
        rpn = new RPN();
        infixString = "";
    }
    private void  deleteLastChar(){
        if(!infixString.isEmpty()){
            infixString = infixString.substring(0,infixString.length() - 1);
        }
    }

    private boolean isOperand(String actionCommand){
        return Character.isDigit(actionCommand.charAt(0));
    }
    private void handleOperation(String symbol){


    }
    private void handleSymbol(String actionCommand){

    }
    private void handleAction(String actionCommand){
        if(actionCommand.equals("divide")){


            System.out.println("it is operation");
            handleOperation("/");
        }else if(actionCommand.equals("multiply")){


            System.out.println("it is operation");
            handleOperation("*");
        }else if(actionCommand.equals("plus")){


            System.out.println("it is operation");
            handleOperation("+");
        }else if(actionCommand.equals("minus")){


            System.out.println("it is operation");
            handleOperation("-");
        }else if(isOperand(actionCommand)){

            infixString += actionCommand;///////
            System.out.println("it is number");
        }else{

            System.out.println("it is symbol");

            handleSymbol(actionCommand);
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
                ////
                break;
            default:
                handleAction(actionCommand);
                break;
        }

        viewer.update("r",infixString);

    }
}
