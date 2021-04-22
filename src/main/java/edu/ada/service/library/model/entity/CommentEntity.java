package edu.ada.service.library.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
public class CommentEntity {
    @Id
   private String id;
    private String bookExtId;
    private String commentAuthName;
    private String commentContent;
}
