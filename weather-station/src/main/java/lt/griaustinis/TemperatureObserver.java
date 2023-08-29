package lt.griaustinis;

import java.time.LocalDateTime;

public interface TemperatureObserver {
    void notify(LocalDateTime dt, float value);
}
