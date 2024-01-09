package softeer.tenten.entity.area;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softeer.tenten.entity.popup.Popup;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "started_at", columnDefinition = "DATE")
    private LocalDate startedAt;

    @Column(name = "ended_at", columnDefinition = "DATE")
    private LocalDate endedAt;

    @Column(name = "x_coord")
    private Double xCoord;

    @Column(name = "y_coord")
    private Double yCoord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "popup_id")
    private Popup popup;
}
