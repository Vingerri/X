package faang.school.projectservice.service.task.filter;

import faang.school.projectservice.dto.task.filter.TaskFilterDto;
import faang.school.projectservice.filter.Filter;
import faang.school.projectservice.model.Task;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class TaskKeyWordFilter implements Filter<TaskFilterDto, Task> {
    @Override
    public boolean isApplicable(TaskFilterDto filters) {
        return filters.getKeyWord() != null;
    }

    @Override
    public Stream<Task> apply(Stream<Task> tasks, TaskFilterDto filters) {
        return tasks.filter(task -> task.getName().contains(filters.getKeyWord()) ||
                task.getDescription().contains(filters.getKeyWord()));
    }
}