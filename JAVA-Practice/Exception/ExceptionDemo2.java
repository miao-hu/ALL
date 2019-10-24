public class ExceptionDemo2 {
    public static void main(String[] args) {
        try{
            throwExceptionMethod(true);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("处理数组下标越界异常");
        }catch(NullPointerException ex){
            System.out.println("处理空指针异常");
        }
        finally {
            System.out.println("无论怎样都得来我这一趟");
        }
    }
    /*
        抛出异常之前
        处理空指针异常
        无论怎样都得来我这一趟
     */

    private static void throwExceptionMethod(boolean isThrow) {
        System.out.println("抛出异常之前");
        if(isThrow){
            throw new NullPointerException();
        }
        System.out.println("抛出异常之后");
    }
}
