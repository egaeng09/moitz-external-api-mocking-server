package moitz.mock.externalapi.gemini.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockGeminiResponse {

    private final List<Candidate> candidates;

    @Getter
    @AllArgsConstructor
    public static class Candidate {
        private Content content;
    }

    @Getter
    @AllArgsConstructor
    public static class Content {
        private List<Part> parts;
        private String role;
    }

    @Getter
    @AllArgsConstructor
    public static class Part {
        private String text;
    }

    public static MockGeminiResponse of(final String text) {
        final Part part = new Part(text);
        final Content content = new Content(List.of(part), "model");
        final Candidate candidate = new Candidate(content);
        return new MockGeminiResponse(List.of(candidate));
    }

}
