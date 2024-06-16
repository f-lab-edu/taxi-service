package com.giwankim.taxiservice.core.api.controller.v1;

import static com.giwankim.taxiservice.domain.Fixtures.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.GetTripEstimatesUseCase;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = GetTripEstimatesController.class)
class GetTripEstimatesControllerTest {
  public static final String ENDPOINT = "/v1/trip/estimate";
  @Autowired private MockMvc mockMvc;
  @MockBean GetTripEstimatesUseCase getTripEstimatesUseCase;

  @Test
  @DisplayName("택시 요금 정보를 조회한다.")
  void getTripEstimates() throws Exception {
    given(getTripEstimatesUseCase.getTripEstimates(any(GetTripEstimatesQuery.class)))
        .willReturn(aTripEstimates().build());

    mockMvc
        .perform(
            get(ENDPOINT)
                .param("origin", "127.11015051307636,37.394725518530834")
                .param("destination", "127.10823557165544,37.401928707331656"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.estimates").isNotEmpty());

    then(getTripEstimatesUseCase)
        .should()
        .getTripEstimates(new GetTripEstimatesQuery(anOrigin().build(), aDestination().build()));
  }

  @ParameterizedTest(name = "origin = {0}, destination = {1}")
  @MethodSource("queryParamProvider")
  @DisplayName("요청 변수를 밸리데이션한다.")
  void validation(String origin, String destination) throws Exception {
    mockMvc
        .perform(get(ENDPOINT).param("origin", origin).param("destination", destination))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error.code").value("E400"))
        .andExpect(jsonPath("$.error.message").value("요청 변수를 확인해 주세요."));
  }

  private static Stream<Arguments> queryParamProvider() {
    return Stream.of(
        Arguments.of("127.11015051307636,37.394725518530834", ""),
        Arguments.of("", "127.10823557165544,37.401928707331656"),
        Arguments.of("", ""),
        Arguments.of("-180.1,37.394725518530834", "127.10823557165544,37.401928707331656"),
        Arguments.of("127.11015051307636,37.394725518530834", "180.1,37.401928707331656"),
        Arguments.of("127.11015051307636,-90.1", "127.10823557165544,37.401928707331656"),
        Arguments.of("127.11015051307636,37.394725518530834", "127.10823557165544,90.1"));
  }
}
