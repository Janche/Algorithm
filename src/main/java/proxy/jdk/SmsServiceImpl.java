package proxy.jdk;

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String msg) {
        System.out.println("send message£º" + msg);
        return msg;
    }
}
