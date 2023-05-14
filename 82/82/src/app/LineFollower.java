package app;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LineFollower extends Thread {
    static float lastReading = 0;
    static float distance = 0;
    static long startTime = System.currentTimeMillis();
    // DataExchange object
    DataExchange DEObj;
    // wheels connect to ports
    public static RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
    public static RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

    // Speeds variable to store the speed values from the database
    private int speeds = 0;

    private static void sendMileage(float distance, long time) {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://192.168.0.23:8080/rest/robot/distance/" + distance + "/" + time);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (IOException e) {
            System.out.println("Error sending mileage data: " + e.getMessage());
        }
    }

    // constructor
    public LineFollower(DataExchange DE) {
        DEObj = DE;

        // Read data from the database and store it in the speeds variable
        try {
            URL url = new URL("http://192.168.0.23:8080/rest/tadaa/tuduu");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            speeds = Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot get data from the database!");
        }
    }

    private final int lineColor = 15; // Value of the black line to be followed against a white background

    public void run() {
        while (true) {
            // access method inside data exchange
            // Get the line value from the ColorSensor Thread
            float colorDetected = DEObj.getLineChecker();

            if (colorDetected < lineColor) {
                motorA.setSpeed(speeds);
                motorD.setSpeed(speeds - 50);
                motorA.forward();
                motorD.forward();
            } else if (colorDetected > lineColor) {
                motorD.setSpeed(speeds);
                motorA.setSpeed(speeds - 50);
                motorD.forward();
                motorA.forward();
            }

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            if (Button.DOWN.isDown()) {
                // Calculate distance and duration
                float distanceTraveled = (float) (speeds * Math.PI * 5.5 / 360) * (elapsedTime / 1000.0f);
                // Send mileage data
                sendMileage(distanceTraveled, elapsedTime);
                // Update lastReading and startTime
                startTime = currentTime;
            }

            if (Button.getButtons() != 0) {
                // stop motors and break when button is pressed
                motorA.stop();
                motorD.stop();
                break;
            }
        }
    }
}
