package es.codeurjc.daw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	public List<Post> getPosts() {
		return postRepository.findAll();
	}

	public Post getPost(long id) {
		return postRepository.findById(id).get();
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	public Comment getComment(long commentId) {
		return this.commentRepository.findById(commentId).get();
	}

	public Comment saveComment(Comment comment) {
		return this.commentRepository.save(comment);
	}

	public void deleteComment(long commentId) {
		this.commentRepository.deleteById(commentId);
	}

}
