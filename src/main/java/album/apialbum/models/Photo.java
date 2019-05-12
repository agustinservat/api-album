package album.apialbum.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Photo {

    @Id
    private Integer id;
    private Integer albumId;
    private Integer userId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo() {
    }

    public Photo(Integer id, Integer albumId, Integer userId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.userId = userId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
