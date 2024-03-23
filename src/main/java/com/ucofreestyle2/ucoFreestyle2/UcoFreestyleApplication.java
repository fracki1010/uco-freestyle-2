package com.ucofreestyle2.ucoFreestyle2;


import com.ucofreestyle2.ucoFreestyle2.models.AFFILIATION;
import com.ucofreestyle2.ucoFreestyle2.models.Client;
import com.ucofreestyle2.ucoFreestyle2.models.Event;
import com.ucofreestyle2.ucoFreestyle2.models.Membrership;
import com.ucofreestyle2.ucoFreestyle2.repositories.ClientRepositories;
import com.ucofreestyle2.ucoFreestyle2.repositories.EventRepositories;
import com.ucofreestyle2.ucoFreestyle2.repositories.MembrershipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*import org.springframework.security.crypto.password.PasswordEncoder;*/


@SpringBootApplication
public class UcoFreestyleApplication {

	public static void main(String[] args) {

		SpringApplication.run(UcoFreestyleApplication.class, args);
	}

	/*@Autowired
	PasswordEncoder passwordEncoder;
*/
	@Bean
	public CommandLineRunner initData(ClientRepositories clientRepository, EventRepositories eventRepositories, MembrershipRepository membrershipRepository) {

		return (arg) -> {

			Membrership membership1 = new Membrership("Organizaciones", AFFILIATION.ORGANIZACION, true);


			membrershipRepository.save(membership1);


			Client client1 = new Client("Franco", "Galdame", "franco23@gmail.com","123","123" ,"42793845");
			Client client2 = new Client("Pedro", "Silva", "pedrito@gmail.com", "123","123" ,"42793846");
			membership1.addClient(client1);

			clientRepository.save(client1);
			clientRepository.save(client2);

			Event event1 = new Event("Rap", "Musica en vivo", "bro");
			Event event2 = new Event("Baile", "Baile en vivo", "hola");
			membership1.addEvent(event1);

			eventRepositories.save(event1);
			eventRepositories.save(event2);





			membrershipRepository.save(membership1);
		};
	}

}
