
package commentssoap.eddy.com;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the commentssoap.eddy.com package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: commentssoap.eddy.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCommentRequest }
     * 
     */
    public GetCommentRequest createGetCommentRequest() {
        return new GetCommentRequest();
    }

    /**
     * Create an instance of {@link GetCommentResponse }
     * 
     */
    public GetCommentResponse createGetCommentResponse() {
        return new GetCommentResponse();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link CreateCommentRequest }
     * 
     */
    public CreateCommentRequest createCreateCommentRequest() {
        return new CreateCommentRequest();
    }

    /**
     * Create an instance of {@link CreateCommentResponse }
     * 
     */
    public CreateCommentResponse createCreateCommentResponse() {
        return new CreateCommentResponse();
    }

    /**
     * Create an instance of {@link UpdateCommentRequest }
     * 
     */
    public UpdateCommentRequest createUpdateCommentRequest() {
        return new UpdateCommentRequest();
    }

    /**
     * Create an instance of {@link UpdateCommentResponse }
     * 
     */
    public UpdateCommentResponse createUpdateCommentResponse() {
        return new UpdateCommentResponse();
    }

    /**
     * Create an instance of {@link DeleteCommentRequest }
     * 
     */
    public DeleteCommentRequest createDeleteCommentRequest() {
        return new DeleteCommentRequest();
    }

    /**
     * Create an instance of {@link DeleteCommentResponse }
     * 
     */
    public DeleteCommentResponse createDeleteCommentResponse() {
        return new DeleteCommentResponse();
    }

}
