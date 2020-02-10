package com.example.api.entity;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity

@Table(name = "chapter")
@EntityListeners(AuditingEntityListener.class)
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "chapterTitle", unique = true, nullable = false)
    private String chapterTitle;

    @Column(name = "content", unique = true, nullable = false)
    private String content;

    @Column(name = "book_id", unique = true, nullable = false)
    private String book_id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookId() {
        return this.book_id;
    }

    public void setBookId(String book_id) {
        this.book_id = book_id;
    }
}
