package dmytro.bozhor.springbootdemo.unit.repository;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
@ActiveProfiles("test")
@DataJpaTest
public class PersonRepositoryTests {

    private final PersonRepository personRepository;

    @Test
    @Rollback(value = false)
    @Order(1)
    void fillTheDataBase() {
        var personOne = Person.builder()
                .name("William")
                .surname("Shekspir")
                .age(25)
                .build();
        var personTwo = Person.builder()
                .name("Adam")
                .surname("Jakson")
                .age(47)
                .build();

        var people = personRepository.saveAll(List.of(personOne, personTwo));
        assertThat(people).hasSize(2);
    }

    @Test
    @Order(2)
    void testPageable() {
        var pageRequest = PageRequest.of(0, 2, Sort.sort(Person.class).by(Person::getName));
        var people = personRepository.findAllBy(pageRequest);
        assertThat(people).hasSize(2);
    }
}
