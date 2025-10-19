package moitz.mock.externalapi.kakao.ui;

import java.util.List;
import java.util.Random;
import moitz.mock.externalapi.kakao.application.dto.KakaoApiResponse;
import moitz.mock.externalapi.kakao.application.dto.Place;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/kakaomap")
public class MockKakaoMapController {

    private static final List<Place> SAMPLE_PLACES = List.of(
            new Place("스타벅스", 127.0276, 37.4979, "카페", 800, "http://www.starbucks.co.kr"),
            new Place("이디야", 127.0280, 37.4980, "카페", 700, "http://www.ediya.com"),
            new Place("카페베네", 127.0265, 37.4975, "카페", 550, "http://www.caffebene.co.kr")
    );

    private final Random random = new Random();

    @GetMapping("/keyword.json")
    public KakaoApiResponse searchKeyword(
            @RequestParam String query,
            @RequestParam(required = false) String x,
            @RequestParam(required = false) String y,
            @RequestParam(required = false) Integer radius,
            @RequestParam(required = false) Integer size
    ) throws InterruptedException {
        Thread.sleep(200 + random.nextInt(200));

        List<Place> result = SAMPLE_PLACES;
        if (size != null && size > 0 && size < SAMPLE_PLACES.size()) {
            result = SAMPLE_PLACES.subList(0, size);
        }

        return new KakaoApiResponse(result);
    }

    @GetMapping("/point.json")
    public Place searchPoint(@RequestParam String query) throws InterruptedException {
        Thread.sleep(50 + random.nextInt(50));
        return SAMPLE_PLACES.get(random.nextInt(SAMPLE_PLACES.size()));
    }

}
