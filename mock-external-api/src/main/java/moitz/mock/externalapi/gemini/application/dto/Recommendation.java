package moitz.mock.externalapi.gemini.application.dto;

public record Recommendation(
        String locationName,
        String summarize_reason,
        String detail_reason
) {

}
