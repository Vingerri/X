package school.faang.user_service.service.event;

import org.springframework.stereotype.Component;
import school.faang.user_service.dto.event.EventFilterDto;
import school.faang.user_service.entity.event.Event;

import java.util.stream.Stream;

@Component
public class EventOwnerFilter implements EventFilter {
    @Override
    public boolean isApplicable(EventFilterDto filters) {
        return filters.getOwnerId() != 0;
    }

    @Override
    public Stream<Event> applyNotSafe(Stream<Event> events, EventFilterDto filters) {
        return events
                .filter(event -> event.getOwner() != null)
                .filter(event -> event.getOwner().getId() == filters.getOwnerId());
    }
}
