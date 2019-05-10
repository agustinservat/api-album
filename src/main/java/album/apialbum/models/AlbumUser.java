package album.apialbum.models;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"albumId", "userId"})})
public class AlbumUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer albumId;
    private Integer userId;
    private Boolean readOnly;


    public AlbumUser() {
    }

    public AlbumUser(Integer id, Integer albumId, Integer userId, Boolean readOnly) {
        this.id = id;
        this.albumId = albumId;
        this.userId = userId;
        this.readOnly = readOnly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }
}
