package edu.miu.cs.cs425.fairfieldlibraryapp.repository;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
