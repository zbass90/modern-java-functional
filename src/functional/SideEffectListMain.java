package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {
    /**
     * changeList1 : 리스트 원본을 직접 변경해서 부수 효과 발생
     * changeList2 : 새로운 리스트 생성 & 반환, 원본 리스트 변경 X -> 함수형 프로그래밍 권장 방식
     */
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("apple"); // apple-> apple_complete
        list1.add("banana"); // banana -> banana_complete

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");

        System.out.println("before list2 = " + list2);
        List<String> result = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("result = " + result);
    }

    private static List<String> changeList2(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(s + "_complete");
        }
        return newList;
    }

    private static void changeList1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + "_complete");
        }

    }
}
