package dmytro.bozhor.springbootdemo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggerDemo {

    @PostConstruct
    public void init(){
        log.info("Init method invocation");
    }

}
