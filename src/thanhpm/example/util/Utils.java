package thanhpm.example.util;

public class Utils {

    /**
     * This method can check the number is positive or not
     * @param value This is value to check
     * @throws Exception when number is not positive
     */
    public static void checkPositiveInt(int value) throws Exception {
        if (value < 1) {
            throw new Exception("Value must be greater than 0");
        }
    }

    /**
     * This method can check the number is positive or not
     * @param words This is command to check
     * @throws Exception when number is not positive
     */
    public static void checkCommand(String[] words) throws Exception{
        if(words.length > 5 && words.length < 3){
            throw new Exception(Constant.ENTER_COMMAND);
        }
    }

}
