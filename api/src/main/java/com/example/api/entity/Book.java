package com.example.api.entity;
import java.util.Set;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity

@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "bookTitle", unique = true, nullable = false)
    private String bookTitle;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "releaseDate", nullable = false)
    private String releaseDate;

    @Column(name = "resume", nullable = false)
    private String resume;

    @Column(name = "type_id", nullable = true)
    private String type_id ;

    public long getId() {
    	return this.id;
    }
    public void setId(long id) {
    	this.id = id;
    }
 
    public String getbookTitle() {
    	return this.bookTitle;
    }
    public void setbookTitle(String bookTitle) {
    	this.bookTitle = bookTitle;
    }

    public String getAuthor() {
    	return this.author;
    }
    public void setBookTitle(String author) {
    	this.author = author;
    }

    public String getReleaseDate() {
    	return this.releaseDate;
    }
    public void setReleaseDate (String releaseDate) {
    	this.releaseDate = releaseDate;
    }
    
    public String getResume() {
    	return this.resume;
    }
    public void setResume (String resume) {
    	this.resume = resume;
    }
    
    public String getTypeId() {
    	return this.type_id;
    }
    public void setTypeId (String type_id) {
    	this.type_id = type_id ;
    }
    
    
   
   
    
    @OneToMany(mappedBy = "Book")
    @JsonIgnoreProperties("Book")
    private Set<Chapter> chapter;
  
}
