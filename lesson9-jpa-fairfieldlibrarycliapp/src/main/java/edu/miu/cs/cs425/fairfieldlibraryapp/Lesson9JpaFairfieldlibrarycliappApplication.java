package edu.miu.cs.cs425.fairfieldlibraryapp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Address;
import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lesson9JpaFairfieldlibrarycliappApplication implements CommandLineRunner {
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(Lesson9JpaFairfieldlibrarycliappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World of SpringBoot");
		System.out.println("Starting FairfieldLibraryCLI App...");
		// Add a new Publisher
		var mcgraw = new Publisher("McGraw-Hill, Inc.", "(123) 456-7890");
		var mcGrawAddress = new Address(null, "1000 N 4th", "Faifield", "IA", "52557");
		mcgraw.setPrimaryAddress(mcGrawAddress);
		mcGrawAddress.setPublisher(mcgraw);
//		var savedMcGraw = createNewPublisher(mcgraw);
//		System.out.println(savedMcGraw);

//		var apress = new Publisher("Apress", null);
//		var savedApress = createNewPublisher(apress);
////		System.out.println(savedApress);



		var allPublishers = getAllPublishers();
		allPublishers.forEach(System.out::println);

		var publisherFound = getPublisherById(1);
		publisherFound.ifPresentOrElse(System.out::println,
				() -> System.out.println("Publisher not found"));

		var optMcGrawFound = getPublisherById(1);
		optMcGrawFound.ifPresentOrElse(
				// Update publisher with adding books and persisting
				(p) -> {
					// TODO
					var book1 = new Book(null, "978-001", "Intro to Alg", LocalDate.of(2011,7,18), p);
					var book2 = new Book(null, "978-002", "PoEAA", LocalDate.of(2015,6,30), p);
					var book3 = new Book(null, "978-003", "Data science", LocalDate.of(2011,1,2), p);
//					p.setBooks(List.of(book1, book2, book3));
					bookService.addNewBook(book1);
					bookService.addNewBook(book2);
					bookService.addNewBook(book3);

					updatePublisher(p);
				},
				() -> System.out.println("Publisher not found")
		);

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
