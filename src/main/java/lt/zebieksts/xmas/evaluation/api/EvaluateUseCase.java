package lt.zebieksts.xmas.evaluation.api;

import lt.zebieksts.xmas.evaluation.model.EvaluationService;
import lt.zebieksts.xmas.evaluation.model.letter.LetterReceived;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record EvaluateUseCase(EvaluationService evaluationService) {
  @EventListener
  public void evaluate(LetterReceived letterReceived) {
    evaluationService.evaluate(letterReceived.name(), letterReceived.address(), letterReceived.request());
  }
}
