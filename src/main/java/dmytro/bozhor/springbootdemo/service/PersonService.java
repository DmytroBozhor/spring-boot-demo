package dmytro.bozhor.springbootdemo.service;

import dmytro.bozhor.springbootdemo.Person;
import dmytro.bozhor.springbootdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

}
