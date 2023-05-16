import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2023/5/16 2:22 下午
 */
public class Stream {


    public static void main(String[] args) {
        List<User> list =  Arrays.asList(
                new User(1, "a", 10, "足球"),
                new User(4, "d", 19, "篮球"),
                new User(5, "e", 13, "乒乓球"),
                new User(2, "b", 14, "地球"),
                new User(3, "a", 10, "月球"),
                new User(6, "d", 19, "算球")
        );
        System.out.println(JSONObject.toJSONString(list));
        ArrayList<User> collect = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(o -> o.getAge() + ";" + o.getName()))), ArrayList::new));
        System.out.println(JSONObject.toJSONString(collect));
    }


    static class User {
        private int id; // id
        private String name; // 姓名
        private int age; // 年龄
        private String like; // 爱好

        public User(int id , String name, int age, String like) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.like = like;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }
    }


}
