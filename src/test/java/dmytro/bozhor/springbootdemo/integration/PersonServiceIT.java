package dmytro.bozhor.springbootdemo.integration;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonServiceIT {

    @Autowired
    private PersonService personService;

    @Test
    void whenSave_returnSavedEntity() {

        var person = Person.builder()
                .name("Ban")
                .surname("Whatson")
                .age(42)
                .build();

        var actual = personService.save(person);

        assertAll(
                () -> assertThat(actual).isEqualTo(person),
                () -> assertThat(actual.getId()).isNotNull()
        );
    }

}
