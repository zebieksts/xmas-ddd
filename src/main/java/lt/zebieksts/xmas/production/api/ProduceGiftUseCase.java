package lt.zebieksts.xmas.production.api;

import lt.zebieksts.xmas.production.model.GiftProductionRequested;
import org.springframework.context.event.EventListener;

public class ProduceGiftUseCase {

  @EventListener
  public void produceGift(GiftProductionRequested request) {

  }
}
