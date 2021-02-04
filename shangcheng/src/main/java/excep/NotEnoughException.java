package excep;

/**
 * ClassName:NotEnoughException
 * Package:excep
 * Description:
 *
 * @Data:2020/11/4 9:48
 * Author:崔建新
 */
//自定义的运行时异常
public class NotEnoughException extends RuntimeException{
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
