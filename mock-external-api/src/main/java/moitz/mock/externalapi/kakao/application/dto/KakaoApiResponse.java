package moitz.mock.externalapi.kakao.application.dto;

import java.util.List;
import lombok.Data;

@Data
public class KakaoApiResponse {

    private List<Place> documents;

    public KakaoApiResponse(List<Place> documents) {
        this.documents = documents;
    }

}
