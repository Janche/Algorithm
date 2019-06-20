package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lirong
 * @desc �����ȡ˽�����Ժͷ���
 * @date 2019/06/20 20:10
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 1. ��ȡclass����
        Class clazz = Person.class;
        // 2. ��ȡ˽���޲ι���
        Constructor c = clazz.getDeclaredConstructor();
        // 3. ���÷���Ϊ�ɼ�
        c.setAccessible(true);
        // 4. ͨ������������ʵ������
        Person person = (Person) c.newInstance();

        // �����ֶ����ƻ�ȡclass�е��ֶ�
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.getName() + " = " + age.get(person));
        // �޸�˽�б�����Ĭ��ֵ
        age.set(person, 18);
        System.out.println(age.getName() + " = " + age.get(person));

        // 5. ��ȡ�����ֶ�
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            // �����ֶεĿɼ���
            f.setAccessible(true);
            String name = f.getName();
            Object o = f.get(person);
            System.out.println(name + " - " + o);
        }

        // 6. ��ȡ���еķ���
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            m.setAccessible(true);
            String name = m.getName();
            Object invoke = m.invoke(person, "����");
            System.out.println(name + " = "+invoke);

        }
    }
}
