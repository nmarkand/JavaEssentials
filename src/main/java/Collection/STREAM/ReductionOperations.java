package Collection.STREAM;

import Collection.STREAM.object.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ReductionOperations {
    public static void main(String[] args) {
        Long userId = 1L;
        List<User> userList = Arrays.asList(
                new User(1L, 8, LocalDate.now()),
                new User(2L, 2, LocalDate.now()),
                new User(1L, 5, LocalDate.now()),
                new User(2L, 5, LocalDate.now()),
                new User(1L, 9, LocalDate.now()));

        Integer sum = userList.stream().filter(user -> user.getUserId().equals(userId))
                .map(usr -> usr.getAmount()).reduce(0, (total , amt) -> total + amt);

       Integer sum2 = userList.stream().filter(user -> user.getUserId().equals(userId))
                .map(User::getAmount).reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(sum2);


        //***************************************************************************************************
    }
}
