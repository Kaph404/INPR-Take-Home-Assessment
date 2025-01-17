public class FizzBus {
    /**
     * Complete the method to return the correct String depending on the value of the parameter num
     * Use selection and String concatenation to achieve this
     * @param num - the number to check
     */
    int a = 0;
    int b = 0;
    int c = 0;
    public static void checkNum(int num) {
        String outputStr;
        if (num % 3 == 0 && num % 5 == 0) {
            outputStr = "FezzBus";
            a++;
        } else if (num % 3 == 0) {
            outputStr = "Fezz";
            b++;
        } else if (num % 5 == 0) {
            outputStr = "Bus";
            c++;
        }else {
            outputStr = ""+num;
        }
        System.out.println(outputStr);
    }

    /**
     * THis will generate a sequence of numbers (integers) from 0 to range - 1
     * @param range
     */
    public static void doFizzBus(int range) {
        for (int i = 1; i < range + 1; i++) {
            checkNum(i);
        }
    }
}