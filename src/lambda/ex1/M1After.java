package lambda.ex1;

import lambda.Procedure;

public class M1After {
	public static void greet(String msg) {
		System.out.println("=== 시작 ===");
		System.out.println(msg);
		System.out.println("=== 끝 ===");
	}
	public static void main(String[] args) {
		greet("Good Morning!");
		greet("Good Afternoon!");
		greet("Good Evening!");
	}
}
