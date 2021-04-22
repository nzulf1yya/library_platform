package edu.ada.service.library.service;

import edu.ada.service.library.model.entity.CommentEntity;

import java.util.List;

public interface CommentService {
    List<CommentModel> getCommentByBookExtId(long id);
}
