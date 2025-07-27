package org.algorithm.solution;

public class UserManager {
    User[] users = new User[100];

    public void add(User user){
        for(int i = 0; i < users.length; i++){
            if(users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }

    public User[] getList(){
        int idx = 0;
        for(int i = 0; i < users.length; i++){
            if(users[i] == null) {
                break;
            }
            idx++;
        }

        User[] getUser = new User[idx];
        for(int j = 0; j < getUser.length; j++) {
            getUser[j] = users[j];
        }
        return getUser;
    }

    public User searchByName(String name){
        User searchUser = new User();
        for(User user : this.users) {
            if(user.getName().equals(name)) {
                searchUser = user;
                break;
            }
        }
        return searchUser;
    }
}
