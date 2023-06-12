package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

//    @Autowired
    private PublisherRepository publisherRepository; // Field Injection


//    @Autowired // Or no annotation
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getAllPublishersSorted() {
        return publisherRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }


}
