package moitz.mock.externalapi.gemini.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Random;
import moitz.mock.externalapi.gemini.application.dto.MockGeminiRequest;
import moitz.mock.externalapi.gemini.application.dto.MockGeminiResponse;
import moitz.mock.externalapi.gemini.application.dto.Recommendation;
import moitz.mock.externalapi.gemini.application.dto.RecommendationResponse;
import org.springframework.stereotype.Service;

@Service
public class MockGeminiService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public MockGeminiResponse generateContent(final MockGeminiRequest request) throws JsonProcessingException {
        final List<Recommendation> recommendations = List.of(
                new Recommendation(
                        "강남역",
                        "대한민국에서 가장 핫한 곳! 🔥",
                        "강남역은 하루 유동 인구가 많은 번화가로, 다양한 연령층이 많이 이용하며, 주변에는 대형 빌딩, 쇼핑몰, 학원, 음식점 등이 밀집되어 있습니다."
                ),
                new Recommendation(
                        "홍대입구역",
                        "젊음과 예술의 거리! 🎨",
                        "홍대입구역은 독특한 문화와 예술이 공존하는 곳입니다. 개성 넘치는 패션, 다양한 버스킹 공연, 맛집들이 즐비해 항상 활기가 넘칩니다."
                ),
                new Recommendation(
                        "광화문역",
                        "역사와 현재가 만나는 곳! 🏛️",
                        "광화문역은 경복궁, 세종문화회관 등 대한민국의 역사와 문화를 느낄 수 있는 중심지입니다. 주변에 큰 기업들과 정부 기관도 많습니다."
                )
        );

        final RecommendationResponse recommendationResponse = new RecommendationResponse(recommendations);

        final String jsonResponseString = objectMapper.writeValueAsString(recommendationResponse);
        try {
            Thread.sleep(1500 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return MockGeminiResponse.of(jsonResponseString);
    }

}
