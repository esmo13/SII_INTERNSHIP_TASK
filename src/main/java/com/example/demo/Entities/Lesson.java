package com.example.demo.Entities;

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
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = User.class,cascade = CascadeType.ALL)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
