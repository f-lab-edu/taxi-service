package com.giwankim.taxiservice.core.api.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase.SearchLocationsQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SearchLocationsController.class)
class SearchLocationsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SearchLocationsUseCase searchLocationsUseCase;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  @DisplayName("검색어를 통해 위치 정보를 조회한다.")
  void searchLocations() throws Exception {
    mockMvc.perform(get("/location/search")
        .param("keyword", "역")
        .param("page", "1")
        .param("size", "10"))
      .andDo(print())
      .andExpect(status().isOk());

    then(searchLocationsUseCase).should()
      .searchLocations(new SearchLocationsQuery("역", 1, 10));
  }
}
