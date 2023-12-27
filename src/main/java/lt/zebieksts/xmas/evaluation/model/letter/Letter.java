package lt.zebieksts.xmas.evaluation.model.letter;

import java.util.UUID;

public record Letter(UUID id, UUID childId, String request) {
}
