package lt.zebieksts.xmas.common.model;

public interface DomainEventPublisher {
  void publish(DomainEvent event);
}
