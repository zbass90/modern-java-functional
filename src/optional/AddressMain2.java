package optional;

import java.util.Optional;

import optional.model.Address;
import optional.model.User;

public class AddressMain2 {
    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
                System.out::println, // 값이 있을 때
                () -> System.out.println("Unknown") // 값이 없을 때
        );
    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user) // user가 null일 수 있으므로 ofNullable 사용
                .map(User::getAddress)
                .map(Address::getStreet); // address.getStreet() 처리
        // null.메소드() 가 불가하므로 u -> u.getAddress().getStreet() 처리 안됨!!!
        // 여기서 map 체이닝 중간에 null이면 Optional.empty()를 반환
    }
}
