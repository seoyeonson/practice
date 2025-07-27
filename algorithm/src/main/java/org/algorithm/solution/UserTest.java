package org.algorithm.solution;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User("김사과");
        User user2 = new User("박바나나");

        UserManager um = new UserManager();
        um.add(user1);
        um.add(user2);

        for(User user:um.getList()){
            System.out.println("getList: " + user.getName());
        }
        System.out.println(um.searchByName("김사과").getName());
        System.out.println(um.getList().length);
    }
}
