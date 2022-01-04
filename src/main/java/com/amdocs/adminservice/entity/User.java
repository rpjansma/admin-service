package com.amdocs.adminservice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "contacts_contact_id")
    private Contacts contacts;

    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedbacks;

    @Column(name= "reg_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime reg_date;

    @UpdateTimestamp
    private LocalDateTime last_update;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                ", reg_date=" + reg_date +
                ", last_update=" + last_update +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(contacts, user.contacts) && Objects.equals(feedbacks, user.feedbacks) && Objects.equals(reg_date, user.reg_date) && Objects.equals(last_update, user.last_update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, contacts, feedbacks, reg_date, last_update);
    }
}
