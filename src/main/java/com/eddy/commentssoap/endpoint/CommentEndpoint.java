package com.eddy.commentssoap.endpoint;

import com.eddy.commentssoap.entity.CommentEntity;
import com.eddy.commentssoap.exception.ResourceNotFoundException;
import com.eddy.commentssoap.repository.CommentRepository;
import commentssoap.eddy.com.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

import java.util.Optional;

@Endpoint
public class CommentEndpoint {
    private static final String NAMESPACE_URI = "com.eddy.commentssoap";

    private final CommentRepository commentRepository;

    public CommentEndpoint(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCommentRequest")
    @ResponsePayload
    public CreateCommentResponse createComment(@RequestPayload CreateCommentRequest createCommentRequest) {
        Comment comment = createCommentRequest.getComment();
        CommentEntity commentEntity = CommentEntity.builder().build();
        commentEntity.setAuthor(comment.getAuthor());
        commentEntity.setText(comment.getText());
        CommentEntity savedCommentEntity = commentRepository.save(commentEntity);

        Comment savedComment = new Comment();
        savedComment.setId(savedCommentEntity.getId());
        savedComment.setText(savedCommentEntity.getText());
        savedComment.setAuthor(savedCommentEntity.getAuthor());

        CreateCommentResponse createCommentResponse = new CreateCommentResponse();
        createCommentResponse.setComment(savedComment);
        return createCommentResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCommentRequest")
    @ResponsePayload
    public GetCommentResponse getComment(@RequestPayload GetCommentRequest getCommentRequest) {
        Optional<CommentEntity> queriedComment = commentRepository.findById(getCommentRequest.getId());

        if (queriedComment.isPresent()) {
            CommentEntity commentEntity = queriedComment.get();
            GetCommentResponse commentResponse = new GetCommentResponse();
            Comment comment = new Comment();
            comment.setId(commentEntity.getId());
            comment.setText(commentEntity.getText());
            comment.setAuthor(commentEntity.getAuthor());

            commentResponse.setComment(comment);

            return commentResponse;
        }
        throw new ResourceNotFoundException("Resource not found");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCommentRequest")
    @ResponsePayload
    public UpdateCommentResponse updateComment(@RequestPayload UpdateCommentRequest updateCommentRequest) {
        Optional<CommentEntity> queriedComment = commentRepository.findById(updateCommentRequest.getId());

        if (queriedComment.isPresent()) {
            CommentEntity commentEntity = queriedComment.get();
            commentEntity.setText(updateCommentRequest.getText());
            UpdateCommentResponse commentResponse = new UpdateCommentResponse();
            Comment comment = new Comment();
            comment.setId(commentEntity.getId());
            comment.setText(updateCommentRequest.getText());
            comment.setAuthor(commentEntity.getAuthor());

            commentRepository.save(commentEntity);
            commentResponse.setComment(comment);

            return commentResponse;
        }
        throw new ResourceNotFoundException("Resource not found");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCommentRequest")
    @ResponsePayload
    public DeleteCommentResponse deleteComment(@RequestPayload DeleteCommentRequest deleteCommentRequest) {
        try {
            commentRepository.deleteById(deleteCommentRequest.getId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Resource not found");
        }

        DeleteCommentResponse deleteCommentResponse = new DeleteCommentResponse();
        deleteCommentResponse.setResponse("Deleted successfully.");
        return deleteCommentResponse;
    }
}
