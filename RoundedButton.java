import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * The 'RoundedButton' class is the class for creating round buttons
 * It extends 'JButton' class and ovverides methods

 */
class RoundedButton extends JButton {
    private int cornerRadius;

    /**
     * Initializes a new instance of the `RoundedButton` class.
     *
     * @param text  text of the button
     * @param cornerRadius radius of the button's corners
     */
    public RoundedButton(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    /**
     * This method draws a rounded button using value of cornerRadius
     * @param g  the Graphics object 
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        // Drawing a rounded button shape
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        //Drawing the text
        super.paintComponent(g);

        g2.dispose();
    }

}
