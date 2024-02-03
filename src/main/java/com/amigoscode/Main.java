package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("greet")
    public GreetResponse greet() {
        GreetResponse greetResponse = new GreetResponse("Hello", List.of("Java", "Golang", "Javascript"), new Person("Amir", 18, 30_000)); // Es wird ein Objekt der Klasse erstellt und zurückgegeben
        return greetResponse;
    }

    record Person(String name, int age, double savings) {
    }

    record GreetResponse(String greett, List<String> favProgrammingLanguages, Person person) {
    }

    @GetMapping("programminglist")
    public Language getList() {
        List<String> listOfProgrammingLanguages = Arrays.asList("Java", "Python", "C++");
        Language language = new Language(listOfProgrammingLanguages);

        return language;
    }

    @GetMapping("languages")
    public List languages() {
        List<String> languages = Arrays.asList("German, English");
        return languages;
    }


    class Language {

        List<String> listOfProgrammingLanguages;

        public Language(List List) {
            this.listOfProgrammingLanguages = List;
        }

        public List getProgrammingList() {
            return listOfProgrammingLanguages;
        }


    }

}











