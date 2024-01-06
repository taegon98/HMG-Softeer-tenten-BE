package softeer.tenten.entity.popup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softeer.tenten.entity.area.Destination;
import softeer.tenten.entity.area.Option;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content_image", nullable = false)
    private String contentImage;

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

    @Column(name = "url")
    private String url;

    @Column(name = "scrap")
    private Integer scrap;

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Destination> destination = new ArrayList<>();

    @OneToMany(mappedBy = "popup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> option = new ArrayList<>();
}
