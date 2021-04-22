package edu.ada.service.library.service.impl;

import edu.ada.service.library.model.entity.CommentEntity;
import edu.ada.service.library.repository.CommentRepository;
import edu.ada.service.library.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public List<CommentModel> getCommentByBookExtId(long id) {
        List<CommentModel> comments = new ArrayList<>(1);
        Optional<List<CommentEntity>> result = commentRepository.findAllByBookExtId(id);

        if (!result.isEmpty()) return comments;

        if (result.get().size() > 0) {
            result.get().stream().forEach((commentEntity -> {
                comments.add(new CommentModel(commentEntity));
            }));
        }

        return comments;
    }
}