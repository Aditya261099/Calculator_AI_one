import java.util.Scanner;
import java.lang.Math;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator!");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(">>===CALSY===>>>Please select an option: ");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Functions");
            System.out.println("3. Financial Calculator");
            System.out.println("4. Unit Conversions");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    basicArithmetic();
                    break;
                case 2:
                    scientificFunctions();
                    break;
                case 3:
                    financialCalculator();
                    break;
                case 4:
                    unitConversions();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }

    public static void basicArithmetic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Basic Arithmetic ===");
        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("Enter an operator (+, -, *, /): ");
        String operator = scanner.next();
        double result = 0;
        boolean valid = true;
        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else
                    System.out.println("Cannot divide by zero.");
                valid = false;
                break;
            default:
                System.out.println("Invalid operator.");
                valid = false;
                break;
        }
        if (valid)
            System.out.println("Operation completed successfully.\n");
        scanner.close();
    }

    public static void scientificFunctions() {
        System.out.println("Scientific Functions selected.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Scientific Functions ===");
        System.out.println("1. Sine (sin)" );
        System.out.println("2. Cosine (cos)" );
        System.out.println("3. Tangent (tan)");
        System.out.println("4. Logarithm (log)");
        System.out.println("5. Natural Logarithm (ln)");
        System.out.println("6. Exponential Function (x^y)");
        System.out.println("7. Square Root (√)");
        System.out.println("Enter Your Choice: ");

        int choice = scanner.nextInt();
        double num, result = 0;

        switch (choice) {
            case 1:
                System.out.println("Enter angle in degrees: ");
                num = scanner.nextDouble();
                result = Math.sin(Math.toRadians(num));
                System.out.println("sin(" + num + ") = " + result);
                break;
            case 2:
                System.out.println("Enter angle in degrees: ");
                num = scanner.nextDouble();
                result = Math.cos(Math.toRadians(num));
                System.out.println("cos(" + num + ") = " + result);
                break;
            case 3:
                System.out.println("Enter angle in degrees: ");
                num = scanner.nextDouble();
                result = Math.tan(Math.toRadians(num));
                System.out.println("tan(" + num + ") = " + result);
                break;
            case 4:
                System.out.println("Enter a positive number: ");
                num = scanner.nextDouble();
                if (num > 0)
                {
                    result = Math.log10(num);
                    System.out.println("log(" + num + ") = " + result);
                }
                else {
                    System.out.println("Invalid number. Please try again.");
                }
                    break;
                case 5:
                    System.out.println("Enter a positive number: ");
                    num = scanner.nextDouble();
                    if (num > 0)
                    {
                        result = Math.log(num);
                        System.out.println("ln(" + num + ") = " + result);
                    }
                    else {
                        System.out.println("Invalid number. Please try again.");
                    }
                        break;
                case 6:
                    System.out.println("Enter base number (x): ");
                    System.out.println("Enter base number (x): ");
                    double base = scanner.nextDouble();
                    System.out.println("Enter exponent (y): ");
                    double exponent = scanner.nextDouble();
                    result = Math.pow(base, exponent);
                    System.out.println(base + "^" + exponent + " = " + result);
                    break;
                case 7:
                    System.out.println("Enter a Number: ");
                    num = scanner.nextDouble();
                    if (num >= 0)
                    {
                        result = Math.sqrt(num);
                        System.out.println("√" + num + " = " + result);
                    }
                    else {
                        System.out.println("Error: Square root of a negative number is not real.");
                    }
                        break;
                default:
                    System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void financialCalculator() {

        System.out.println("Financial Calculator selected.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Financial Calculator ===");
        System.out.println("1. Loan EMI Calculator");
        System.out.println("2. Simple Interest");
        System.out.println("3. Compound Interest");
        System.out.println("4. Currency Conversion (Real Time)");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nLoan EMI Calculator");
                System.out.println("Enter principal amount: ");
                double principal = scanner.nextDouble();
                System.out.println("Enter interest rate: ");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter number of years: ");
                double years = scanner.nextDouble();
                double interest = principal * (interestRate / 100) * years;
                System.out.println("Total Interest: " + interest);
                double monthlyInterest = interest / (12 * years);
                System.out.println("Monthly Interest: " + monthlyInterest);
                double emiRate = interestRate / (12 * 100);
                double numberOfMonths = years * 12;
                double monthlyPayment = (principal * emiRate * Math.pow(1 + emiRate, numberOfMonths)) / (Math.pow(1 + emiRate, numberOfMonths) - 1);
                System.out.println("Monthly Payment: " + monthlyPayment);
                double totalPayment = monthlyPayment * 12 * years;
                System.out.println("Total Payment: " + totalPayment);
                break;
            case 2:
                System.out.println("Simple Interest");
                System.out.println("Enter principal amount: ");
                principal = scanner.nextDouble();
                System.out.println("Enter interest rate: ");
                interestRate = scanner.nextDouble();
                System.out.println("Enter number of years: ");
                years = scanner.nextDouble();
                interest = principal * (interestRate / 100) * years;
                System.out.println("Total Interest: " + interest);
                break;
            case 3:
                System.out.println("Compound Interest");
                System.out.println("Enter principal amount: ");
                principal = scanner.nextDouble();
                System.out.println("Enter interest rate: ");
                interestRate = scanner.nextDouble();
                System.out.println("Enter number of years: ");
                years = scanner.nextDouble();
                System.out.println("Enter number of times compounded per year: ");
                double compoundedPerYear = scanner.nextDouble();
                interest = principal * (Math.pow((1 + interestRate / 100), compoundedPerYear * years));
                System.out.println("Total Interest: " + interest);
                break;
            case 4:
                System.out.println("\nCurrency Conversion (Real Time)");
                currencyConverter();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        }
    public static void currencyConverter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter BASE CURRENCY (e.g., USD, EUR, INR): ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.println("Enter TARGET CURRENCY (e.g., USD, EUR, INR): ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.println("Enter AMOUNT TO CONVERT: ");
        double amount = scanner.nextDouble();

        try {
            String apiKey = "0bc14e0d6a62cb22d574975b";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.connect();

            // Read the API response
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the response to JSON
            JSONObject json = new JSONObject(response.toString());
            if (json.getString("result").equals("success")) {
                // Extract conversion rates
                JSONObject conversionRates = json.getJSONObject("conversion_rates");
                if (conversionRates.has(targetCurrency)) {
                    // Get the exchange rate for the target currency
                    double exchangeRate = conversionRates.getDouble(targetCurrency);
                    double convertedAmount = amount * exchangeRate;
                    System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
                } else {
                    System.out.println("Error: Target currency not found in conversion rates.");
                }
            } else {
                System.out.println("Error: API response indicates failure.");
            }
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }
    }

    public static void unitConversions() {
        System.out.println("Unit Conversions selected.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Unit Conversions ===");
        System.out.println("1. Temperature Conversion");
        System.out.println("2. Area Conversion");
        System.out.println("3. Volume Conversion");
        System.out.println("4. Weight Conversion");
        System.out.println("5. Pressure Conversion");
        System.out.println("6. Speed Conversion");
        System.out.println("7. Energy Conversion");
        System.out.println("8. Currency Conversion");
        System.out.println("9. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Temperature Conversion");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.println("3. Kelvin to Celsius");
                System.out.println("4. Celsius to Kelvin");
                System.out.println("5. Fahrenheit to Kelvin");
                System.out.println("6. Kelvin to Fahrenheit");
                System.out.println("Enter your choice: ");
                int tempChoice = scanner.nextInt();
                System.out.println("Enter the temperature value: ");
                double tempValue = scanner.nextDouble();
                double convertedTemp = 0;
                switch (tempChoice) {
                    case 1:
                        convertedTemp = (tempValue * 9 / 5) + 32;
                        System.out.println(tempValue + "°C is " + convertedTemp + "°F");
                        break;
                    case 2:
                        convertedTemp = (tempValue - 32) * 5 / 9;
                        System.out.println(tempValue + "°F is " + convertedTemp + "°C");
                        break;
                    case 3:
                        convertedTemp = tempValue - 273.15;
                        System.out.println(tempValue + "K is " + convertedTemp + "°C");
                        break;
                    case 4:
                        convertedTemp = tempValue + 273.15;
                        System.out.println(tempValue +"°C is " + convertedTemp + "K");
                        break;
                    case 5:
                        convertedTemp = (tempValue - 32) * 5 / 9 + 273.15;
                        System.out.println(tempValue + "°F is " + convertedTemp + "K");
                        break;
                    case 6:
                        convertedTemp = (tempValue - 273.15) * 9 / 5 + 32;
                        System.out.println(tempValue + "K is " + convertedTemp + "°F");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 2:
                System.out.println("Area Conversion");
                System.out.println("1. Meters to Miles");
                System.out.println("2. Miles to Meters");
                System.out.println("3. Meters to Kilometers");
                System.out.println("4. Kilometers to Meters");
                System.out.println("5. Kilometers to Miles");
                System.out.println("6. Miles to Kilometers");
                System.out.println("7. Feet to Meters");
                System.out.println("8. Meters to Feet");
                System.out.println("9. Inches to Meters");
                System.out.println("10. Meters to Inches");
                System.out.println("11. Centimeters to Meters");
                System.out.println("12. Meters to Centimeters");
                System.out.println("Enter your choice: ");
                int areaChoice = scanner.nextInt();
                System.out.println("Enter the area value: ");
                double areaValue = scanner.nextDouble();
                double result = 0;

                switch (areaChoice)
                {
                    case 1:
                        result = areaValue * 0.000621371;
                        System.out.println(areaValue + " Meters is " + result + "Miles");
                        break;
                    case 2:
                        result = areaValue * 1609.344;
                        System.out.println(areaValue + " Miles is " + result + "Meters");
                        break;
                    case 3:
                        result = areaValue * 0.001;
                        System.out.println(areaValue + " Meters is " + result + "Kilometers");
                        break;
                    case 4:
                        result = areaValue * 1000;
                        System.out.println(areaValue + " Kilometers is " + result + "Meters");
                        break;
                    case 5:
                        result = areaValue * 0.000621371;
                        System.out.println(areaValue + " Meters is " + result + "Kilometers");
                        break;
                    case 6:
                        result = areaValue * 1609.344;
                        System.out.println(areaValue + " Kilometers is " + result + "Miles");
                        break;
                    case 7:
                        result = areaValue * 0.3048;
                        System.out.println(areaValue + " Meters is " + result + "Feet");
                        break;
                    case 8:
                        result = areaValue * 3.28084;
                        System.out.println(areaValue + " Feet is " + result + "Meters");
                        break;
                    case 9:
                        result = areaValue * 0.0254;
                        System.out.println(areaValue + " Meters is " + result + "Inches");
                        break;
                    case 10:
                        result = areaValue * 39.3701;
                        System.out.println(areaValue + " Inches is " + result + "Meters");
                        break;
                    case 11:
                        result = areaValue * 0.01;
                        System.out.println(areaValue + " Meters is " + result + "Centimeters");
                        break;
                    case 12:
                        result = areaValue * 100;
                        System.out.println(areaValue + " Centimeters is " + result + "Meters");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 3:
                System.out.println("Volume Conversion");
                System.out.println("1. Cubic Meters to Liters");
                System.out.println("2. Liters to Cubic Meters");
                System.out.println("3. Cubic Feet to Liters");
                System.out.println("4. Liters to Cubic Feet");
                System.out.println("Enter your choice: ");
                int volChoice = scanner.nextInt();
                System.out.println("Enter the volume value: ");
                double volValue = scanner.nextDouble();
                double resultVol = 0;

                switch (volChoice)
                {
                    case 1:
                        resultVol = volValue * 1000;
                        System.out.println(volValue + " Cubic Meters is " + resultVol + "Liters");
                        break;
                    case 2:
                        resultVol = volValue / 1000;
                        System.out.println(volValue + " Liters is " + resultVol + "Cubic Meters");
                        break;
                    case 3:
                        resultVol = volValue * 28.316846592;
                        System.out.println(volValue + " Cubic Feet is " + resultVol + "Liters");
                        break;
                    case 4:
                        resultVol = volValue / 28.316846592;
                        System.out.println(volValue + " Liters is " + resultVol + "Cubic Feet");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 4:
                System.out.println("Weight Conversion");
                System.out.println("1. Kilograms to Pounds");
                System.out.println("2. Pounds to Kilograms");
                System.out.println("3. Kilograms to Ounces");
                System.out.println("4. Ounces to Kilograms");
                System.out.println("Enter your choice: ");
                int weightChoice = scanner.nextInt();
                System.out.println("Enter the weight value: ");
                double weightValue = scanner.nextDouble();
                double resultWeight = 0;

                switch (weightChoice)
                {
                    case 1:
                        resultWeight = weightValue * 2.20462;
                        System.out.println(weightValue + " Kilograms is " + resultWeight + "Pounds");
                        break;
                    case 2:
                        resultWeight = weightValue / 2.20462;
                        System.out.println(weightValue + " Pounds is " + resultWeight + "Kilograms");
                        break;
                    case 3:
                        resultWeight = weightValue * 0.0625;
                        System.out.println(weightValue + " Kilograms is " + resultWeight + "Ounces");
                        break;
                    case 4:
                        resultWeight = weightValue / 0.0625;
                        System.out.println(weightValue + " Ounces is " + resultWeight + "Kilograms");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 5:
                System.out.println("Pressure Conversion");
                System.out.println("1. Pascals to Pounds Per Square Inch");
                System.out.println("2. Pounds Per Square Inch to Pascals");
                System.out.println("Enter your choice: ");
                int pressureChoice = scanner.nextInt();
                System.out.println("Enter the pressure value: ");
                double pressureValue = scanner.nextDouble();
                double resultPressure = 0;
                switch (pressureChoice)
                {
                    case 1:
                        resultPressure = pressureValue * 0.000245;
                        System.out.println(pressureValue + " Pascals is " + resultPressure + "Pounds Per Square Inch");
                        break;
                    case 2:
                        resultPressure = pressureValue / 0.000245;
                        System.out.println(pressureValue + " Pounds Per Square Inch is " + resultPressure + "Pascals");
                        break;
                }
                break;
            case 6:
                System.out.println("Speed Conversion");
                System.out.println("1. Miles Per Hour to Kilometers Per Hour");
                System.out.println("2. Kilometers Per Hour to Miles Per Hour");
                System.out.println("Enter your choice: ");
                int speedChoice = scanner.nextInt();
                System.out.println("Enter the speed value: ");
                double speedValue = scanner.nextDouble();
                double resultSpeed = 0;
                switch (speedChoice)
                {
                    case 1:
                        resultSpeed = speedValue * 1.60934;
                        System.out.println(speedValue + " Miles Per Hour is " + resultSpeed + "Kilometers Per Hour");
                        break;
                    case 2:
                        resultSpeed = speedValue / 1.60934;
                        System.out.println(speedValue + " Kilometers Per Hour is " + resultSpeed + "Miles Per Hour");
                        break;
                }
                break;
            case 7:
                System.out.println("Energy Conversion");
                System.out.println("1. Joules to Kilojoules");
                System.out.println("2. Kilojoules to Joules");
                System.out.println("3. Joules to Calories");
                System.out.println("4. Calories to Joules");
                System.out.println("Enter your choice: ");
                int energyChoice = scanner.nextInt();
                System.out.println("Enter the energy value: ");
                double energyValue = scanner.nextDouble();
                double resultEnergy = 0;
                switch (energyChoice)
                {
                    case 1:
                        resultEnergy = energyValue / 1000;
                        System.out.println(energyValue + " Joules is " + resultEnergy + "Kilojoules");
                        break;
                    case 2:
                        resultEnergy = energyValue * 1000;
                        System.out.println(energyValue + " Kilojoules is " + resultEnergy + "Joules");
                        break;
                    case 3:
                        resultEnergy = energyValue * 4.184;
                        System.out.println(energyValue + " Joules is " + resultEnergy + "Calories");
                        break;
                    case 4:
                        resultEnergy = energyValue / 4.184;
                        System.out.println(energyValue + " Calories is " + resultEnergy + "Joules");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 8:
                System.out.println("\nCurrency Conversion (Real Time)");
                currencyConverter();
                break;
            case 9:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
