package lt.griaustinis;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JFrame {
    private JPanel content = new JPanel();

    public Main() {
        this.setSize(640, 480);
        this.setTitle("Weather App Example");

        this.add(content);

        this.content.add(new TemperatureWidget(-1));
        this.content.add(new TemperatureWidget(0));
        this.content.add(new TemperatureWidget(1));
        this.content.add(new TemperatureWidget(2));
        this.content.add(new TemperatureWidget(3));
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
        Thread t = new Thread(new WeatherService.WeatherUpdater());
        t.setDaemon(true);
        t.start();
    }
}