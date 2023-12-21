import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {

    GUI() throws IOException {
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBackground(Color.RED);
        panelMain.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 25));

        BufferedImage image = ImageIO.read(new File("src/img/Elysium_Planitia_labelled_view.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(image.getScaledInstance(200, 300, Image.SCALE_FAST)));
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(picLabel);

        // Fake it to you make it
        JLabel sol_keys = textColorBakgrund("Current Sol: 4036");
        JLabel at = textColorBakgrund("Atmospheric Temperature: High -4°C | Low -76°C");
        JLabel hws = textColorBakgrund("Wind Speed: 4,2 m/s");
        JLabel pre = textColorBakgrund("Atmospheric Pressure: 696 Pascal");
        JLabel wd = textColorBakgrund("wind direction: ±11.25°");

        sol_keys.setVisible(false);
        at.setVisible(false);
        hws.setVisible(false);
        pre.setVisible(false);
        wd.setVisible(false);

        panelMain.add(sol_keys);
        panelMain.add(at);
        panelMain.add(hws);
        panelMain.add(pre);
        panelMain.add(wd);

        JButton btnRevealText = new JButton("Hur är klimatet i Mars?");
        btnRevealText.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRevealText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sol_keys.setVisible(true);
                at.setVisible(true);
                hws.setVisible(true);
                pre.setVisible(true);
                wd.setVisible(true);
                panelMain.revalidate();
                panelMain.repaint();
            }
        });
        panelMain.add(btnRevealText);

        add(panelMain);
        setTitle("Klimatet i Mars");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
    }

    private static JLabel textColorBakgrund(String text) {
        JLabel textColor = new JLabel(text);
        textColor.setOpaque(true);
        textColor.setBackground(Color.YELLOW);
        textColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textColor;
    }
}