package lt.zebieksts.xmas.evaluation.model.events;

import lt.zebieksts.xmas.common.model.DomainEvent;
import java.util.UUID;

public record EvaluationRequested(UUID letterId, UUID childId) implements DomainEvent {

}
