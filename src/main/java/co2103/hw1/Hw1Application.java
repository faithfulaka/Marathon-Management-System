package co2103.hw1;

import co2103.hw1.domain.Marathon;
import co2103.hw1.domain.Runner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {
    public static List<Marathon> marathons;


    public static void main(String[] args) {

        SpringApplication.run(Hw1Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        marathons = new ArrayList<>();
        Marathon a = new Marathon();
        a.setId(1);
        a.setLocation("Germany");
        a.setMonth("May");

        List<Runner> runners = new ArrayList<>();
        Runner b = new Runner();
        b.setName("Mark");
        b.setNationality("Canadian");
        b.setCategory("runner");
        b.setNumber(12);

        Runner c = new Runner();
        c.setName("James");
        c.setNationality("British");
        c.setCategory("sprinter");
        c.setNumber(13);

        runners.add(b);
        runners.add(c);
        a.setRunners(runners);
        marathons.add(a);
    }
}