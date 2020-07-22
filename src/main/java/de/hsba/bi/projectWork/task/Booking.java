package de.hsba.bi.projectWork.task;

import de.hsba.bi.projectWork.project.Project;
import de.hsba.bi.projectWork.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private LocalDate date;
    private int timeSpent;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Task task;

    @ManyToOne(optional = false)
    private Project project;

    public Booking(User user, LocalDate date, int timeSpent) {
        this.user = user;
        this.date = date;
        this.timeSpent = timeSpent;
    }
}