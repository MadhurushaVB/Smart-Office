import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(float temperature, float humidity, float pressure);
}

class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

class TemperatureDisplay implements Observer {
    private float temperature;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current temperature: " + temperature + "C");
    }
}

public class ObserverPattern{
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay tempDisplay = new TemperatureDisplay();

        weatherStation.registerObserver(tempDisplay);
        weatherStation.setMeasurements(30, 65, 1013);
    }
}