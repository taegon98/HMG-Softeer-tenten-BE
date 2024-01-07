package softeer.tenten.entity.popup.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softeer.tenten.entity.popup.criteria.Brand;
import softeer.tenten.entity.popup.criteria.Category;
import softeer.tenten.entity.popup.criteria.PopupTag;
import softeer.tenten.entity.popup.area.Destination;
import softeer.tenten.entity.popup.area.Option;
import softeer.tenten.entity.popup.event.Waiting;
import softeer.tenten.entity.popup.review.Review;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "popup")
public class Popup {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @Column(name = "content_image", nullable = false)
    private String contentImage;

    @Column(name = "other_image", nullable = false)
    private String otherImage;

    @Column(name = "started_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime startedAt;

    @Column(name = "ended_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime endedAt;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "scrap")
    private Integer scrap;

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Destination> destination = new ArrayList<>();

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> option = new ArrayList<>();

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PopupImage> popupImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PopupTag> popupTags = new ArrayList<>();

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Waiting> waiting = new ArrayList<>();

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}
