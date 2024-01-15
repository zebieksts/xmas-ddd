package lt.zebieksts.xmas.common.events;

import lt.zebieksts.xmas.common.model.DomainEvent;

import java.util.UUID;

public record RequestRejected(UUID letterId) implements DomainEvent {
}

