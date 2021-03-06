package leetcode.problems;

public class A263_Ugly_Number {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while ((num & 1) == 0) {
            num >>= 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
