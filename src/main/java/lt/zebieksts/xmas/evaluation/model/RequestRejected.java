package lt.zebieksts.xmas.evaluation.model;

import lt.zebieksts.xmas.common.model.DomainEvent;

import java.util.UUID;

public record RequestRejected(UUID id) implements DomainEvent {
}

