public class Utility {
    int firstvalue;
    double secondValue;
    String outputString;

    public void sum(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("Result: " + sum);
    }

    public void convertToUpperCase(String inputString) {
        outputString = inputString.toUpperCase();
        System.out.println("Updated String: " + outputString);
    }
}

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        utility.firstvalue = 10;
        utility.secondValue = 20.5;
        utility.outputString = "hello";
        
        utility.sum(utility.firstvalue, 5);
        utility.convertToUpperCase("world");
    }
}