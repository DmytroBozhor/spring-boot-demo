package dmytro.bozhor.springbootdemo.integration;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.annotation.IT;
import dmytro.bozhor.springbootdemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class PersonServiceIT {

    private final PersonService personService;

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
