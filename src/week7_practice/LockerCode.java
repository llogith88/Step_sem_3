package week7_practice;


public class LockerCode {

    private String code;
    private final int lockerNumber;

    public LockerCode(int lockerNumber, String code) {

        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {

        if (code.equals(currentCode)) {

            code = newCode;

            System.out.println("Code changed successfully");

        } else {

            System.out.println("Code change rejected");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {

        LockerCode l =
                new LockerCode(101, "1234");

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}