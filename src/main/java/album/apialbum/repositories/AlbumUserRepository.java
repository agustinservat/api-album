package album.apialbum.repositories;

import album.apialbum.models.AlbumUser;
import album.apialbum.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumUserRepository extends JpaRepository<AlbumUser, Integer> {

    @Query(value = "select a.* from album_user a where a.id = :id", nativeQuery = true)
    AlbumUser findOneById(@Param("id") Integer id);
    List<AlbumUser> findAlbumUserByAlbumIdAndReadOnly(Integer albumId, Boolean readOnly);
    AlbumUser findByAlbumIdAndUserId(Integer albumId, Integer userId);
}
