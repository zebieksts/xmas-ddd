package lt.zebieksts.xmas.production.model;

import lt.zebieksts.xmas.common.model.DomainEvent;

import java.util.UUID;

public record GiftProductionRequested(UUID requestId) implements DomainEvent {
}
