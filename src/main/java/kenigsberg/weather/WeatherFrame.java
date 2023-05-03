package kenigsberg.weather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WeatherFrame extends JFrame {
    ForecastWeatherView forecastWeatherView;

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();


    private final WeatherService service = retrofit.create(WeatherService.class);
    private ForecastWeatherController controller;

    public WeatherFrame() {

        setSize(800, 600);
        setTitle("Current Weather");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JTextField location = new JTextField("Staten Island");
        topPanel.add(location);

        JButton button = new JButton("Submit");
        topPanel.add(button);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        forecastWeatherView = new ForecastWeatherView();
        mainPanel.add(forecastWeatherView, BorderLayout.CENTER);

        controller = new ForecastWeatherController(forecastWeatherView, service);

        controller.updateWeather("Staten Island");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateWeather(location.getText());
            }
        });

        setContentPane(mainPanel);

    }

    /*

    WEATHER GUI
    public WeatherFrame() throws IOException {

        setSize(800, 300);
        setTitle("Current Weather");
        //What happens when we hit the exit button
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        JLabel title = new JLabel("Current Weather Info:", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        title.setForeground(Color.BLACK);

        mainPanel.add(title, BorderLayout.NORTH);

        JLabel weatherInfo = new JLabel();
        weatherInfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        weatherInfo.setForeground(Color.LIGHT_GRAY);
        mainPanel.add(weatherInfo, BorderLayout.CENTER);
        weatherInfo.setHorizontalAlignment(SwingConstants.CENTER);


        setContentPane(mainPanel);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();


        WeatherService service = retrofit.create(WeatherService.class);

        Disposable disposable = service.getCurrentWeather("Staten Island")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(
                        currentWeather -> {
                            double info = currentWeather.main.temp;
                            weatherInfo.setText(String.valueOf(info));
                            weatherInfo.setHorizontalAlignment(SwingConstants.CENTER);
                        },
                        Throwable::printStackTrace

                );
        */
}



