public class Util {
    public static void  process(String s) throws ExceptionStart {
        if(!s.startsWith("docnum") && !s.startsWith("contract")){
            String  message ="документ "+s+" должен начинаться с docnum или contract ";
            throw new ExceptionStart(message);
        }
//        if (!s.startsWith("contract")){
//            String  message ="документ "+s+" должен начинаться с docnum или contract ";
//            throw new ExceptionStart(message);
//        }
    }

    public static void  process1(String s) throws ExceptionLength {
        if(s.length()!=15){
            String  message ="документ "+s+" должен состоять из 15 символов ";
            throw new ExceptionLength(message);
        }
    }
}
