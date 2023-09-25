import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private Model model;

    Controller(Viewer viewer){
        model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent event){
        



    }

}
