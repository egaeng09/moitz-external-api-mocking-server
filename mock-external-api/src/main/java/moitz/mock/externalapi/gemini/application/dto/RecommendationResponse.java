package moitz.mock.externalapi.gemini.application.dto;

import java.util.List;

public record RecommendationResponse(
        List<Recommendation> recommendations
) {

}
