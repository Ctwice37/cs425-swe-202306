package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String FirstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
