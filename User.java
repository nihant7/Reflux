public class User implements Comparable<User> {

    public String name;

    public int id;

    @Override
    public int compareTo(User user) {
        if (id - user.id > 0)
            return 1;

        else if(id - user.id < 0)
            return -1;
        else return 0;

    }

    public User(String name, int id) {
        this.name=name;
        this.id=id;
    }

}
