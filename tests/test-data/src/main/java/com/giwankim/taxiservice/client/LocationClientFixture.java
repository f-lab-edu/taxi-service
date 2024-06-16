package com.giwankim.taxiservice.client;

public class LocationClientFixture {
  private LocationClientFixture() {}

  public static final String KAKAO_LOCATION_RESPONSE_BODY =
      """
                    {
                      "documents": [
                      {
                        "address": {
                          "address_name": "전북특별자치도 익산시 부송동 100",
                          "b_code": "5214013400",
                          "h_code": "5214069000",
                          "main_address_no": "100",
                          "mountain_yn": "N",
                          "region_1depth_name": "전북특별자치도",
                          "region_2depth_name": "익산시",
                          "region_3depth_h_name": "삼성동",
                          "region_3depth_name": "부송동",
                          "sub_address_no": "",
                          "x": "126.99597495347",
                          "y": "35.9766482774572"
                        },
                        "address_name": "전북특별자치도 익산시 부송동 100",
                        "address_type": "REGION_ADDR",
                        "road_address": null,
                        "x": "126.99597495347",
                        "y": "35.9766482774572"
                      },
                      {
                        "address": {
                          "address_name": "전북특별자치도 익산시 임상동 100",
                          "b_code": "5214013200",
                          "h_code": "5214069000",
                          "main_address_no": "100",
                          "mountain_yn": "N",
                          "region_1depth_name": "전북특별자치도",
                          "region_2depth_name": "익산시",
                          "region_3depth_h_name": "삼성동",
                          "region_3depth_name": "임상동",
                          "sub_address_no": "",
                          "x": "126.980268573424",
                          "y": "35.9816612949048"
                        },
                        "address_name": "전북특별자치도 익산시 임상동 100",
                        "address_type": "REGION_ADDR",
                        "road_address": null,
                        "x": "126.980268573424",
                        "y": "35.9816612949048"
                      },
                      {
                        "address": {
                          "address_name": "전북특별자치도 익산시 정족동 100",
                          "b_code": "5214013100",
                          "h_code": "5214069000",
                          "main_address_no": "100",
                          "mountain_yn": "N",
                          "region_1depth_name": "전북특별자치도",
                          "region_2depth_name": "익산시",
                          "region_3depth_h_name": "삼성동",
                          "region_3depth_name": "정족동",
                          "sub_address_no": "",
                          "x": "127.002020445866",
                          "y": "35.9829740190917"
                        },
                        "address_name": "전북특별자치도 익산시 정족동 100",
                        "address_type": "REGION_ADDR",
                        "road_address": null,
                        "x": "127.002020445866",
                        "y": "35.9829740190917"
                      }
                      ],
                      "meta": {
                      "is_end": true,
                      "pageable_count": 3,
                      "total_count": 3
                      }
                    }
          """;
}
