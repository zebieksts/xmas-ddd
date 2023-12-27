package lt.zebieksts.xmas.evaluation.model.letter;

import lt.zebieksts.xmas.common.model.DomainEvent;
import lt.zebieksts.xmas.evaluation.model.child.ChildAddress;
import lt.zebieksts.xmas.evaluation.model.child.ChildName;

public record LetterReceived(ChildName name, ChildAddress address, String request) implements DomainEvent {
}