package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    public abstract Publisher addNewPublisher(Publisher newPublisher);
    List<Publisher> getAllPublishers();

    public List<Publisher> getAllPublishersSorted();

    public Optional<Publisher> getPublisherById(Integer publisherId);

    Publisher updatePublisher(Publisher publisher);

    void deletePublisherById(Integer publisherId);
}
