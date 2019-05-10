package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.apiService.CommentServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.models.Comment;
import album.apialbum.repositories.AlbumsRepository;
import album.apialbum.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;


    public List<Comment> getComments(){

        List<Comment> commentList = CommentServiceAPI.getComments();

        commentsRepository.saveAll(commentList);

        return commentList;
    }
}
