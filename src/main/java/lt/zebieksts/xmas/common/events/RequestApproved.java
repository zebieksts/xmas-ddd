package lt.zebieksts.xmas.common.events;

import lt.zebieksts.xmas.common.model.DomainEvent;

import java.util.UUID;

public record RequestApproved(UUID letterId) implements DomainEvent {
}