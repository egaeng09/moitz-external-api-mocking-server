package moitz.mock.externalapi.gemini.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import moitz.mock.externalapi.gemini.application.MockGeminiService;
import moitz.mock.externalapi.gemini.application.dto.MockGeminiRequest;
import moitz.mock.externalapi.gemini.application.dto.MockGeminiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MockGeminiController {

    private final MockGeminiService mockGeminiService;

    @PostMapping("/mock/gemini/generate")
    public MockGeminiResponse generateContent(@RequestBody MockGeminiRequest request) throws JsonProcessingException {
        return mockGeminiService.generateContent(request);
    }

}
