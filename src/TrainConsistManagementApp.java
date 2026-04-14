import java.util.regex.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        // ✅ Regex Patterns
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern p1 = Pattern.compile(trainPattern);
        Pattern p2 = Pattern.compile(cargoPattern);

        // Create matchers
        Matcher m1 = p1.matcher(trainId);
        Matcher m2 = p2.matcher(cargoCode);

        // Validate
        if (m1.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        if (m2.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }
    }
}