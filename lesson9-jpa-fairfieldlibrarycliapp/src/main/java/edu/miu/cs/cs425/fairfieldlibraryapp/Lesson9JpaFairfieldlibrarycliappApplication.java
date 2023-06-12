package edu.miu.cs.cs425.fairfieldlibraryapp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lesson9JpaFairfieldlibrarycliappApplication implements CommandLineRunner {
	@Autowired
	private PublisherService publisherService;

	public static void main(String[] args) {
		SpringApplication.run(Lesson9JpaFairfieldlibrarycliappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World of SpringBoot");
		System.out.println("Starting FairfieldLibraryCLI App...");
		// Add a new Publisher
//		var mcgraw = new Publisher("McGraw-Hill, Inc.", "(123) 456-7890");
//		var savedMcGraw = createNewPublisher(mcgraw);
//		System.out.println(savedMcGraw);

//		var apress = new Publisher("Apress", null);
//		var savedApress = createNewPublisher(apress);
//		System.out.println(savedApress);

		var allPublishers = getAllPublishers();
		allPublishers.forEach(System.out::println);

		var publisherFound = getPublisherById(3);
		publisherFound.ifPresentOrElse(System.out::println,
				() -> System.out.println("Publisher not found"));

		var optApress = getPublisherById(2);
		if(optApress.isPresent()) {
			var apress = optApress.get();
			apress.setContactPhoneNumber("(641) 123-1234");
			var updatedApress = updatePublisher(apress);
			System.out.println(updatedApress);
		} else {
			System.out.println("Publisher not found");
		}

		// Delete by Id
		publisherService.deletePublisherById(2);
	}

	private Publisher createNewPublisher(Publisher newPublisher) {
		return publisherService.addNewPublisher(newPublisher);
	}

	private List<Publisher> getAllPublishers() {
		return publisherService.getAllPublishersSorted();
	}

	private Optional<Publisher> getPublisherById(Integer publisherId) {
		return publisherService.getPublisherById(publisherId);
	}

	private Publisher updatePublisher(Publisher publisher) {
		return publisherService.updatePublisher(publisher);
	}

}
