package dmytro.bozhor.springbootdemo.unit.service;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.repository.PersonRepository;
import dmytro.bozhor.springbootdemo.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@DisplayName("PersonRepositoryTest")
@ExtendWith(MockitoExtension.class)
class PersonServiceTests {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void whenSave_returnSavedEntity() {

        var person = Person.builder()
                .name("Ban")
                .surname("Whatson")
                .age(42)
                .build();

        doReturn(person).when(personRepository).save(person);

        var actual = personService.save(person);

        assertThat(actual).isEqualTo(person);

        verify(personRepository).save(any(Person.class));
    }
}