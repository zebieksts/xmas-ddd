package lt.zebieksts.xmas.evaluation.model.child;

import java.util.UUID;

public record Child(UUID id, ChildAddress address, Behavior behavior) {
}
