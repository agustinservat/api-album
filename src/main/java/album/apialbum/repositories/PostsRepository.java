package album.apialbum.repositories;

import album.apialbum.models.Album;
import album.apialbum.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {
}
