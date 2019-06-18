package 小技巧;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class 集合去重 {
	public static void main(String[] args) {
		ArrayList<String> ss = new ArrayList<String>();
		ss.add("JAVA");
		ss.add("J2EE");
		ss.add("JSP");
		ss.add("Android");
		ss.add("Eclipse");
		ss.add("JAVA");
		ss.add("JSP");
		
		System.out.println(ss);
		System.out.println("------1------");
		
		HashSet<String> set = new HashSet<String>(ss);
		System.out.println(set);
		System.out.println("------2------");
		
		ArrayList<String> ss1 = new ArrayList<String>(set);
		System.out.println(ss1);
		System.out.println("------3------");
		
		LinkedHashSet<String> lls = new LinkedHashSet<String>(ss);
		System.out.println(lls);
		System.out.println("------4------");
		
		ArrayList<String> ss2 = new ArrayList<String>(lls);
		System.out.println(ss2);
		System.out.println("------5------"); 
		
	}
}

/*
[JAVA, J2EE, JSP, Android, Eclipse, JAVA, JSP]
------1------
[JAVA, JSP, Eclipse, J2EE, Android]
------2------
[JAVA, JSP, Eclipse, J2EE, Android]
------3------
[JAVA, J2EE, JSP, Android, Eclipse]
------4------
[JAVA, J2EE, JSP, Android, Eclipse]
------5------
*/
