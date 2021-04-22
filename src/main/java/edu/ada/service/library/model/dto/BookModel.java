package edu.ada.service.library.model.dto;

import edu.ada.service.library.model.entity.BookEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class BookModel implements Serializable {
    private Long id;
    private String title;
    private String category;
    private String author;
    private String publish_date;
    private String availability;
    private List<CommentModel> comments;
public BookModel(BookEntity book){
    this.id=book.getId();
    this.author=book.getAuthor();
    this.category=book.getCategory();
    this.publish_date=book.getPublish_date();
    this.title=book.getTitle();
    this.availability=book.getAvailability();
}
public void setComments(List<CommentModel> comments){
    this.comments=comments;
}

    public void setComments() {
    }
}