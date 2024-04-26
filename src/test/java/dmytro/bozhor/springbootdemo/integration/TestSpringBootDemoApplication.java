package dmytro.bozhor.springbootdemo.integration;

import dmytro.bozhor.springbootdemo.repository.PersonRepository;
import org.mockito.Mock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestSpringBootDemoApplication {

    @MockBean
    private PersonRepository personRepository;

}
