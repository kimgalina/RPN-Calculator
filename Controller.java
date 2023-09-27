import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private Model model;

    Controller(Viewer viewer){
        model = new Model(viewer);
    }

    //The single argument to the method is an ActionEvent object that gives information about the event and its source.
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        model.doAction(command);


    }

}
