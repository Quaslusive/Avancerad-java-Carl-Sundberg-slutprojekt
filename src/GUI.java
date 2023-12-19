import org.json.JSONObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {

    GUI() throws IOException {
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));


        BufferedImage image = ImageIO.read(new File("src/img/Elysium_Planitia_labelled_view.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(image.getScaledInstance(300, 400, Image.SCALE_FAST)));
        panelMain.add(picLabel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);


/*
        JSONObject sol = null;
        JSONObject atmosphericPressure = null;
        JSONObject wind = null;

        JSONObject season = null;


 */

        // panelMain.add(new JLabel("Sol: " + sol.toString()));
        // panelMain.add(new JLabel("Atmospheric Pressure: " + atmosphericPressure.toString()));
        // panelMain.add(new JLabel("Wind: " + wind.toString()));

        // panelMain.add(new JLabel("Season: " + season.toString()));

        add(panelMain);
        setTitle("Weather On Mars");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

    }
}
