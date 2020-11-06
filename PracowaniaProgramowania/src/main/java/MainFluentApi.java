import fluentAPI.Person;
import fluentAPI.PersonBuilderBuilder;
import fluentAPI.interfaces.Title;
import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState;

import java.util.List;
import java.util.function.Function;

public class MainFluentApi {

    public static void main(String[] args) {

        //Package-private constructor is not accessible here, we must use the builder:
        //Person p = new Person("a",Title.PROF);
        PersonBuilderBuilder builder = new PersonBuilderBuilder();
        Person newOne = builder.withName("Bob").build();

        Person friendOne = builder.withName("A").build();
        Person secondPerson = builder.withName("B").build();

        newOne.addFriend(friendOne).addFriend(secondPerson).sayHelloToFriends();
        // Todo
        Function<List<Person>, Person> choose  = friends -> friends.get(0);
        newOne.chooseBestFriend(choose);
    }
}