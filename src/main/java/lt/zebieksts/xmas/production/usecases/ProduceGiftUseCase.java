package lt.zebieksts.xmas.production.usecases;

import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.common.events.RequestApproved;
import lt.zebieksts.xmas.production.services.GiftProductionService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProduceGiftUseCase {

  private GiftProductionService giftProductionService;

  @EventListener
  public void handleRequestApproved(RequestApproved request) {
    giftProductionService.produce(request.letterId());
  }

}
