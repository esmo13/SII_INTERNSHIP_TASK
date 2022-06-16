package Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    @Id
    @SequenceGenerator(name="lessonid_sequence",
            sequenceName = "lessonid_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="lessonid_sequence"
    )
    private Long id;
    private String topic;
    private LocalDateTime dateTime;
    @ManyToMany(fetch = FetchType.EAGER,targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinTable(name="reservations",joinColumns =@JoinColumn(name="lesson_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users;

    public Lesson(String topic, LocalDateTime dateTime, Set<User> users) {
        this.topic = topic;
        this.dateTime = dateTime;
        this.users = users;
    }

    public Lesson(Long id, String topic, LocalDateTime dateTime, Set<User> users) {
        this.id = id;
        this.topic = topic;
        this.dateTime = dateTime;
        this.users = users;
    }

    public Lesson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id.equals(lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
