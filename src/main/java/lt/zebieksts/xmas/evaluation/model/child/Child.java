package lt.zebieksts.xmas.evaluation.model.child;

import lt.zebieksts.xmas.common.model.Address;
import java.util.UUID;

public record Child(UUID id, Address address, Behavior behavior) {
}
