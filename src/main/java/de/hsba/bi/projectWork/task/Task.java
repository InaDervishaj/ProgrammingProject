package de.hsba.bi.projectWork.task;

import de.hsba.bi.projectWork.project.Project;
import de.hsba.bi.projectWork.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private int estimation;
    private int totalTime;
    private String status;
    //private Enum<Status> status;

    @ManyToOne(optional = false)
    private Project project;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "task")
    private List<Booking> times;

    /*@ManyToOne(optional = false)
    private User assignee;*/

    public enum Status {
        IDEA("Idea"),
        PLANNED("Planned"),
        WORK_IN_PROGRESS("Work in progress"),
        TESTING("Testing"),
        DONE("Done");

        private final String displayValue;

        Status(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }


    public int calcTotalTime() {
        int sum = 0;
        for (Booking booking : this.times) {
            int time = booking.timeSpent;
            sum = sum + time;
        }
        this.setTotalTime(sum);
        return sum;
    }

    public Task (String name, String description, int estimation, String status) {
        this.name = name;
        this.description = description;
        this.estimation = estimation;
        this.status = status;
    }

}
