package lt.zebieksts.xmas.evaluation.usecases;

import lombok.AllArgsConstructor;
import lt.zebieksts.xmas.common.events.LetterReceived;
import lt.zebieksts.xmas.evaluation.services.LetterService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HandleLetterUseCase {

  private LetterService letterService;

  @EventListener
  public void handleLetterReceived(LetterReceived letterReceived) {
    letterService.storeLetter(letterReceived.name(), letterReceived.address(), letterReceived.request());
  }
}
