package lt.zebieksts.xmas.common.events;

import lt.zebieksts.xmas.common.model.Address;
import lt.zebieksts.xmas.common.model.DomainEvent;
import lt.zebieksts.xmas.common.model.Name;

public record LetterReceived(Name name, Address address, String request) implements DomainEvent {
}