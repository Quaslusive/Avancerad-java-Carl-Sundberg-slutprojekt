import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Skriven av Carl Sundberg
 */
public class WeatherOnMars extends JFrame {

    private final JTextArea[] dayTexts = new JTextArea[7];
    JLabel[] dayLabels = new JLabel[7];

    WeatherOnMars() {

        //By making the days in columns instead of rows it's easier for the user to skim through the days.
        JPanel mainPanel = new JPanel(new GridLayout(0, 7)); // Column

        // Deklarerar dagens datum och början av veckan
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        // Formaterar LocalDate till string
        // Jag har försökt att implementer "DateTimeFormatter" i själva veckokalendern, men jag kunde inte få det att
        // funka ihop med "TemporalAccessor". Jag använder detta formatering i "setTitle"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL");
        String formattedToday = today.format(formatter);

        for (int i = 0; i < 7; i++) {
            //Adding every day in their own JPanel and adding a border to better accentuate the days.
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            //Adding a second panel to the bottom of the day and adding my buttons to it to further make the calendar more readable.
            JPanel bottomPanel = new JPanel(new GridLayout(2, 0));

            LocalDate day = startOfWeek.plusDays(i); // Incrementer en dag
            dayLabels[i] = new JLabel(String.valueOf(day)); // Lägger in datum på elementen
            if (day.equals(today))  // Om en dag == med dagens datum, blir texten röd
                dayLabels[i].setForeground(Color.RED);

            //dayTexts displays your activity
            dayTexts[i] = new JTextArea();
            dayTexts[i].setEditable(false);


            //Adding all the elements to their corresponding dayPanels and bottomPanels then adding them to mainPanel
            dayPanel.add(dayLabels[i], BorderLayout.NORTH);
            dayPanel.add(dayTexts[i]);
            dayPanel.add(bottomPanel, BorderLayout.SOUTH);
            mainPanel.add(dayPanel);
        }
        //Adding all the new dayPanels to the frame and setting some values for the frame
        add(mainPanel);
        setTitle("Hur är vädret på Mars? " + formattedToday);
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
       new WeatherOnMars();
    }

}