package thanhpm.main.util;

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
        if(words[0].equals(Constant.OPTION_CREATE_CANVAS)){
            if(words.length != 3){
                throw new Exception(Constant.ENTER_COMMAND);
            }
            return;
        }
        if(words[0].equals(Constant.OPTION_DRAW_LINE) || words[0].equals(Constant.OPTION_DRAW_RECTANGLE)){
            if(words.length != 5){
                throw new Exception(Constant.ENTER_COMMAND);
            }
            return;
        }
        if(words[0].equals(Constant.OPTION_FILL_COLOR)){
            if(words.length != 4){
                throw new Exception(Constant.ENTER_COMMAND);
            }
            return;
        }
    }

}
