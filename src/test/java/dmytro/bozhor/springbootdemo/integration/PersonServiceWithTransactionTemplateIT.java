package dmytro.bozhor.springbootdemo.integration;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.annotation.IT;
import dmytro.bozhor.springbootdemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@IT
@RequiredArgsConstructor
public class PersonServiceWithTransactionTemplateIT {

    private final PersonService personService;
    private final TransactionTemplate transactionTemplate;

    @Test
    void whenSave_returnSavedEntity() {

        transactionTemplate.executeWithoutResult(transactionStatus -> {
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
        });
    }

}
