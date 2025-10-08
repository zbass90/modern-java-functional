package medthodref;

public class Person {

    private String name;
    private String name2;

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this.name = name;
    }
    public Person(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    // 정적 메서드
    public static String greeting() {
        return "Hello";
    }

    // 정적 메서드, 매개변수
    public static String greetingWithName(String name) {
        return "Hello " + name;
    }

    public String getName() {
        return name;
    }

    // 인스턴스 메서드
    public String introduce() {
        return "I am " + name;
    }

    // 인스턴스 메서드, 매개변수
    public String introduceWithNumber(int number) {
        return "I am " + name + ", my number is " + number;
    }

}
