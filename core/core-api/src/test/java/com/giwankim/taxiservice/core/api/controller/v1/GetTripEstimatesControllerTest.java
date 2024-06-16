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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}
