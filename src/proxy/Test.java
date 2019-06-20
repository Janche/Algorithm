package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lirong
 * @desc 反射获取私有属性和方法
 * @date 2019/06/20 20:10
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 1. 获取class对象
        Class clazz = Person.class;
        // 2. 获取私有无参构造
        Constructor c = clazz.getDeclaredConstructor();
        // 3. 设置访问为可见
        c.setAccessible(true);
        // 4. 通过构造器创建实例对象
        Person person = (Person) c.newInstance();

        // 根据字段名称获取class中的字段
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.getName() + " = " + age.get(person));
        // 修改私有变量的默认值
        age.set(person, 18);
        System.out.println(age.getName() + " = " + age.get(person));

        // 5. 获取所有字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            // 设置字段的可见性
            f.setAccessible(true);
            String name = f.getName();
            Object o = f.get(person);
            System.out.println(name + " - " + o);
        }

        // 6. 获取所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            m.setAccessible(true);
            String name = m.getName();
            Object invoke = m.invoke(person, "张三");
            System.out.println(name + " = "+invoke);

        }
    }
}
