public class Model{
    private Viewer viewer;

    Model(Viewer viewer){
        this.viewer = viewer;
    }

    public void doAction(String actionCommand){
        System.out.println("in model " + actionCommand);
    }
}
