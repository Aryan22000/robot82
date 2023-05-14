//package app;
//
//import lejos.hardware.Button;
//import lejos.hardware.motor.EV3LargeRegulatedMotor;
//import lejos.hardware.port.MotorPort;
//import lejos.robotics.RegulatedMotor;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class Measurement extends Thread {
//	
//	  static float lastReading = 0;
//	  static float distance = 0;
//	  static long startTime = System.currentTimeMillis();
//
//
//    public static RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
//    public static RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
//
//    // Speeds variable to store the speed values from the database
//    private int speeds = 0;
//
//    private static void sendMileage(float distance, long time) {
//        HttpURLConnection conn = null;
//
//        try {
//            URL url = new URL("http://192.168.0.17:8080/rest/robot/distance/"+ distance + "/" + time);
//            conn = (HttpURLConnection)url.openConnection();
//            conn.setDoOutput(true);  
//            int responseCode = conn.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//        } catch (IOException e) {
//            System.out.println("Error sending mileage data: " + e.getMessage());
//        }
//    }
//    public Measurement( ) {
//  
//
//        // Read data from the database and store it in the speeds variable
//        try {
////			url = new URL("https://ev3test-380115.appspot.com/rest/ev3service/sayhello");
////			url = new URL("http://192.168.0.102:8080/rest/ev3service/sayhello");
////			url = new URL("http://192.168.1.64:8080/rest/laptopservive/servicename");
//            URL url = new URL("http://192.168.0.17:8080/rest/tadaa/tuduu");
////        	url = new URL("http://192.168.0.101");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            InputStream is = conn.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String s = br.readLine();
//            speeds = Integer.parseInt(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Cannot get data from the database!");
//        }
//    }
//
//    public void run() {
//        while (true) {         
//            if (Button.DOWN.isDown()) {
////          int NewSpeed = Motors.getMotorSpeedFromServer();
//                // Calculate distance and duration
//                float x = (float) (speeds*Math.PI*5.5/360);
//                long time = System.currentTimeMillis() - startTime;
//                float distance = x*(time/1000);
//                // Send mileage data
//                sendMileage(100, 100);
//                // Update lastReading and startTime
////          lastReading = currentReading;
//                startTime = System.currentTimeMillis();
//            }
//            //Call sendMileage to send data to the database
////            sendMileage(distance, time);
//
//            if (Thread.interrupted()) {
//                break;
//            }
//        }
//    }
//
//}
