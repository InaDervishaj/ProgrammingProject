package de.hsba.bi.projectWork.task;

import de.hsba.bi.projectWork.project.Project;
import de.hsba.bi.projectWork.user.User;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Task implements Comparable<Task>{

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private int estimation;
    private int totalTime;
    private String status;
    private LocalDate dueDate;
    @Transient
    private int daysLeft;
    //private Enum<Status> status;

    @ManyToOne(optional = false)
    private Project project;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "task")
    private List<Booking> times;

    @ManyToOne
    private User assignee;

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
            int time = booking.getTimeSpent();
            sum = sum + time;
        }
        this.setTotalTime(sum);
        return sum;
    }

    public Task(String name, String description, int estimation, String status, String dueDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dueDate, dateTimeFormatter);

        this.name = name;
        this.description = description;
        this.estimation = estimation;
        this.status = status;
        this.dueDate = localDate;
    }

    public void calcDaysLeft() {
        LocalDate dueDate = this.dueDate;
        LocalDate todaysDate = LocalDate.now();
        Period period;

        period = Period.between(todaysDate, dueDate);
        this.daysLeft = period.getDays();
    }

    @Override
    public int compareTo(Task task) {
        return getDueDate().compareTo(task.getDueDate());
    }
}
