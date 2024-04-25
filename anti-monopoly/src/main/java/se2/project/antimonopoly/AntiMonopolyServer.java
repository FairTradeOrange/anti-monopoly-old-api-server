package se2.project.antimonopoly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import se2.project.antimonopoly.entity.UserRedis;
import se2.project.antimonopoly.service.UserRedisService;

@EnableCaching
@EntityScan("se2.project.antimonopoly.entity")
@EnableJpaRepositories(basePackages = "se2.project.antimonopoly.dao.jpa")
@EnableRedisRepositories(basePackages = "se2.project.antimonopoly.dao.redis")
@ComponentScan(basePackages = { "se2.project.antimonopoly.*" })
@SpringBootApplication
public class AntiMonopolyServer {

	public static void main(String[] args) {
		SpringApplication.run(AntiMonopolyServer.class, args);
	}

	@Bean
	CommandLineRunner loadTestData(UserRedisService userRedisService) {
		return args -> {
			//repo.delete("thor");

			String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You.";

			// Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
			//Person thor = Person.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), Set.of("hammer", "biceps", "hair", "heart"));
			UserRedis thor = new UserRedis("Thor");
			thor.setUserID("666");

			userRedisService.saveUser(thor);
		};
	}
}

