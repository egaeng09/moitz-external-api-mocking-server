package moitz.mock.externalapi.kakao.application.dto;

import lombok.Data;

@Data
public class Place {

    private String placeName;
    private double x;
    private double y;

    public Place(String placeName, double x, double y) {
        this.placeName = placeName;
        this.x = x;
        this.y = y;
    }

}
