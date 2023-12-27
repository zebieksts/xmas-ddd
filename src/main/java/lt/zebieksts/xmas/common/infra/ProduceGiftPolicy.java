package lt.zebieksts.xmas.common.infra;

import lt.zebieksts.xmas.common.model.DomainEventPublisher;
import lt.zebieksts.xmas.evaluation.model.RequestApproved;
import lt.zebieksts.xmas.production.model.GiftProductionRequested;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record ProduceGiftPolicy(DomainEventPublisher domainEventPublisher) {
  @EventListener
  void requestGiftProduction(RequestApproved requestApproved) {
    domainEventPublisher.publish(new GiftProductionRequested(requestApproved.id()));
  }
}
