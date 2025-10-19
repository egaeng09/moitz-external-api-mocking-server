package moitz.mock.externalapi.kakao.ui;

import lombok.RequiredArgsConstructor;
import moitz.mock.externalapi.kakao.application.MockKakaoMapService;
import moitz.mock.externalapi.kakao.application.dto.KakaoApiResponse;
import moitz.mock.externalapi.kakao.application.dto.Place;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock/kakaomap")
public class MockKakaoMapController {

    private final MockKakaoMapService mockKakaoMapService;

    @GetMapping("/keyword.json")
    public KakaoApiResponse searchKeyword(
            @RequestParam String query,
            @RequestParam(required = false) String x,
            @RequestParam(required = false) String y,
            @RequestParam(required = false) Integer radius,
            @RequestParam(required = false) Integer size
    ) throws InterruptedException {
        return mockKakaoMapService.searchKeyword(query, x, y, radius, size);
    }

    @GetMapping("/point.json")
    public Place searchPoint(@RequestParam String query) throws InterruptedException {
        return mockKakaoMapService.searchPoint(query);
    }

}
