package lt.zebieksts.xmas.evaluation.model;

import lt.zebieksts.xmas.common.model.ApprovalStatus;

import java.util.UUID;

public record Evaluation(UUID id, UUID letterId, ApprovalStatus approvalStatus) {
}
