import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField locationField;
    private JTextArea weatherArea;

    public Main() {
        setLayout(new FlowLayout());

        JLabel locationLabel = new JLabel(" Elysium Planitia");
        add(locationLabel);

        locationField = new JTextField(15);
        add(locationField);

        JButton getWeatherButton = new JButton("Ge mig vädret på Mars");
        getWeatherButton.addActionListener(this);
        add(getWeatherButton);

        weatherArea = new JTextArea(5, 15);
        weatherArea.setEditable(false);
        add(weatherArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mars = locationField.getText();
        String weatherData = fetchWeatherData(mars);
        weatherArea.setText(weatherData);
    }

    private String fetchWeatherData(String mars) {

        return "The är väldigt blåsigt på Mars!";
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300, 200);
        app.setVisible(true);
    }
}
