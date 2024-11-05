package faang.school.achievement.service.achievement.filter;

import faang.school.achievement.dto.achievement.AchievementFilterDto;
import faang.school.achievement.model.Achievement;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class NameFilter implements AchievementFilter {


    @Override
    public boolean isApplicable(AchievementFilterDto filter) {
        return filter.getTitle() != null && !filter.getTitle().isBlank();
    }

    @Override
    public Stream<Achievement> apply(Stream<Achievement> achievements, AchievementFilterDto filter) {
        return achievements.filter(achievement -> achievement.getTitle().toLowerCase().contains(filter.getTitle().toLowerCase()));
    }
}