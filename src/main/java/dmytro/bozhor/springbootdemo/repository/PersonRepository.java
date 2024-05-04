package dmytro.bozhor.springbootdemo.repository;

import dmytro.bozhor.springbootdemo.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameContainingIgnoreCase(String name);

    List<Person> findAllByAge(Integer age);

    List<Person> findBySurnameContaining(String surname);

    Optional<Person> findBySurname(String surname);

    List<Person> findAllBy(Pageable pageable);

}
