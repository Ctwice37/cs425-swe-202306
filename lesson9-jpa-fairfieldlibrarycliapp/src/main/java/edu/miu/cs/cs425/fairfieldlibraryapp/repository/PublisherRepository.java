package edu.miu.cs.cs425.fairfieldlibraryapp.repository;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = "select p from Publisher p where p.name = :name")
    Optional<Publisher> getPublisherWithName(String name);

    @Query(value = "select * from `cs425-swe-202306-fairfieldlibrarydb`.publishers p where p.name like 'name%'", nativeQuery = true)
    Optional<Publisher> getPublisherWithName2(String name);

    Optional<Publisher> findPublisherByNameContainingIgnoreCase(String name);

}
