package proxy;

/**
 * @author lirong
 * @desc ≤‚ ‘∂‘œÛ
 * @date 2019/06/20 20:07
 */

public class Person {

    private int age = 5;

    private String name;

    private Person(){}

    private String test(String name){
        System.out.println("name: "+name);
        return "test";
    }
}
