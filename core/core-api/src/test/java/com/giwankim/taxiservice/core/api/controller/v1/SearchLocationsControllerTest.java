package com.giwankim.taxiservice.core.api.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsQuery;
import com.giwankim.taxiservice.core.domain.application.port.in.SearchLocationsUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SearchLocationsController.class)
class SearchLocationsControllerTest {

  public static final String ENDPOINT = "/v1/location/search";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SearchLocationsUseCase searchLocationsUseCase;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  @DisplayName("검색어를 통해 위치 정보를 조회한다.")
  void searchLocations() throws Exception {
    mockMvc.perform(get(ENDPOINT)
            .param("keyword", "역")
            .param("page", "1")
            .param("size", "10"))
        .andDo(print())
        .andExpect(status().isOk());

    then(searchLocationsUseCase).should()
        .searchLocations(new SearchLocationsQuery("역", 1, 10));
  }

  @Test
  @DisplayName("page와 size를 입력하지 않을 경우 기본값으로 조회한다.")
  void defaultValues() throws Exception {
    mockMvc.perform(get(ENDPOINT)
            .param("keyword", "역"))
        .andDo(print())
        .andExpect(status().isOk());

    then(searchLocationsUseCase).should()
        .searchLocations(new SearchLocationsQuery("역", 1, 10));
  }

  @ParameterizedTest(name = "keyword = {0}")
  @NullAndEmptySource
  @ValueSource(strings = {"   ", "\t", "\n",
      "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
      "가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하"})
  @DisplayName("키워드를 밸리데이션 한다")
  void validateKeyword(String keyword) throws Exception {
    mockMvc.perform(get(ENDPOINT)
            .param("keyword", keyword)
            .param("page", "1")
            .param("size", "10"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error.code").value("E400"))
        .andExpect(jsonPath("$.error.message").value("요청 변수를 확인해 주세요."));
  }

  @ParameterizedTest(name = "page = {0}, size = {1}")
  @CsvSource({"0,10", "46,10", "1,0", "1,31"})
  @DisplayName("페이지와 사이즈를 밸리데이션 한다.")
  void validatePageAndSize(int page, int size) throws Exception {
    mockMvc.perform(get(ENDPOINT)
            .param("keyword", "역")
            .param("page", String.valueOf(page))
            .param("size", String.valueOf(size)))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error.code").value("E400"))
        .andExpect(jsonPath("$.error.message").value("요청 변수를 확인해 주세요."));
  }
}
