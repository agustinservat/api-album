package album.apialbum.repositories;

import album.apialbum.models.AlbumUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumUserRepository extends JpaRepository<AlbumUser, Integer> {
}
