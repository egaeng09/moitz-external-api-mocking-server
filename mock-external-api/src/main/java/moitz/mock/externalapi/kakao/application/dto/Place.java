package moitz.mock.externalapi.kakao.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Place {

    @JsonProperty("place_name") private String placeName;
    private double x;
    private double y;
    @JsonProperty("category_name") private String categoryName;
    private int distance;
    @JsonProperty("place_url") private String url;

    public Place(String placeName, double x, double y, String categoryName, int distance, String url) {
        this.placeName = placeName;
        this.x = x;
        this.y = y;
        this.categoryName = categoryName;
        this.distance = distance;
        this.url = url;
    }

}
