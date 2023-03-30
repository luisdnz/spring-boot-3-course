package amigoscodecourse;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[]args){
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse("Hi", "fellow kiddo",List.of("Dog", "Spinosaurus", "Capuccino Monkey"), new Person("Luisdnz"));
    }

    public record Person(String name){
        
    }

    public record GreetResponse(String greet, String name, List<String>favAnimals, Person person){

    }
    
}
