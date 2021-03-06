package de.hsba.bi.projectWork.project;

import de.hsba.bi.projectWork.task.Booking;
import de.hsba.bi.projectWork.task.Task;
import de.hsba.bi.projectWork.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @OrderBy
    private List<User> members;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @OrderBy
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @OrderBy
    private List<Booking> bookedTimes = new ArrayList<>();

    @Transient
    private transient double usersTimeSpentInProject;

    public Project(String name) {
        this.name = name;
    }

    public int findTasks(String status) {
        List<Task> allTasks = this.getTasks();
        List<Task> tasks = new ArrayList<>();
        for (Task task : allTasks) {
            if (task.getStatus().equals(status)) {
                tasks.add(task);
            }
        }
        return tasks.size();
    }

}
