package com.giwankim.taxiservice.client;

public class FareClientFixture {
  private FareClientFixture() {}

  public static final String KAKAO_FARE_SUCCESS_RESPONSE_BODY =
      """
          {
            "trans_id": "018fe74870bc767384ed9490f21a4c9d",
            "routes": [
              {
                "result_code": 0,
                "result_msg": "길찾기 성공",
                "summary": {
                  "origin": {
                    "name": "",
                    "x": 127.11015051307636,
                    "y": 37.394725518530834
                  },
                  "destination": {
                    "name": "",
                    "x": 127.10823557165544,
                    "y": 37.401928707331656
                  },
                  "waypoints": [],
                  "priority": "RECOMMEND",
                  "bound": {
                    "min_x": 127.10833536148644,
                    "min_y": 37.39445954360996,
                    "max_x": 127.1098222529551,
                    "max_y": 37.40242724407785
                  },
                  "fare": {
                    "taxi": 5200,
                    "toll": 0
                  },
                  "distance": 1033,
                  "duration": 320
                },
                "sections": [
                  {
                    "distance": 1033,
                    "duration": 320,
                    "bound": {
                      "min_x": 127.10824109988312,
                      "min_y": 37.394469584427156,
                      "max_x": 127.10991634747967,
                      "max_y": 37.40242613861426
                    },
                    "roads": [
                      {
                        "name": "",
                        "distance": 22,
                        "duration": 5,
                        "traffic_speed": 16.0,
                        "traffic_state": 0,
                        "vertexes": [
                          127.10991634747967,
                          37.39447145478345,
                          127.10966790676201,
                          37.394469584427156
                        ]
                      },
                      {
                        "name": "판교역로",
                        "distance": 883,
                        "duration": 227,
                        "traffic_speed": 11.0,
                        "traffic_state": 2,
                        "vertexes": [
                          127.10966790676201,
                          37.394469584427156,
                          127.10967141980313,
                          37.39512739646385,
                          127.10968100356395,
                          37.396226781360426,
                          127.10967417816033,
                          37.39775855885587,
                          127.10968323318781,
                          37.39794785293074,
                          127.10967534594126,
                          37.39861458950405,
                          127.10967214334856,
                          37.399840028043634,
                          127.1096931266438,
                          37.40093048716485,
                          127.10967543155922,
                          37.40242613861426
                        ]
                      },
                      {
                        "name": "판교역로241번길",
                        "distance": 128,
                        "duration": 88,
                        "traffic_speed": 11.0,
                        "traffic_state": 2,
                        "vertexes": [
                          127.10967543155922,
                          37.40242613861426,
                          127.10860261294675,
                          37.40240904474889,
                          127.10824109988312,
                          37.402415329497174
                        ]
                      }
                    ],
                    "guides": [
                      {
                        "name": "출발지",
                        "x": 127.10991634747967,
                        "y": 37.39447145478345,
                        "distance": 0,
                        "duration": 0,
                        "type": 100,
                        "guidance": "출발지",
                        "road_index": 0
                      },
                      {
                        "name": "",
                        "x": 127.10966790676201,
                        "y": 37.394469584427156,
                        "distance": 22,
                        "duration": 5,
                        "type": 2,
                        "guidance": "우회전",
                        "road_index": 1
                      },
                      {
                        "name": "",
                        "x": 127.10967543155922,
                        "y": 37.40242613861426,
                        "distance": 883,
                        "duration": 227,
                        "type": 1,
                        "guidance": "좌회전",
                        "road_index": 2
                      },
                      {
                        "name": "목적지",
                        "x": 127.10824109988312,
                        "y": 37.402415329497174,
                        "distance": 128,
                        "duration": 88,
                        "type": 101,
                        "guidance": "목적지",
                        "road_index": -1
                      }
                    ]
                  }
                ]
              }
            ]
          }
          """;
}
