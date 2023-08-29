package lt.griaustinis;

import javax.swing.*;
import java.time.LocalDateTime;

public class TemperatureWidget extends JPanel implements TemperatureObserver {
    private JLabel tempValue;
    private int offset;
    public TemperatureWidget(int offset) {
        tempValue = new JLabel("??? °C");
        this.add(tempValue);
        WeatherService.getInstance().subscribe(this);
        this.offset = offset;
    }

    @Override
    public void notify(LocalDateTime dt, float value) {
        if (LocalDateTime.now().getHour() + offset == dt.getHour()) {
            tempValue.setText(String.format("%d:00 %.1f °C", dt.getHour(), value));
        }
    }
}
