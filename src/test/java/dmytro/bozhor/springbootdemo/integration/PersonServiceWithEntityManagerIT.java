package dmytro.bozhor.springbootdemo.integration;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RequiredArgsConstructor
@IT
@Transactional
public class PersonServiceWithEntityManagerIT {

    private final EntityManager entityManager;

    @Test
    void whenSave_returnSavedEntity() {

        var person = Person.builder()
                .name("Ban")
                .surname("Whatson")
                .age(42)
                .build();

        entityManager.persist(person);

        assertAll(
                () -> assertThat(person.getId()).isNotNull()
        );

    }
}
