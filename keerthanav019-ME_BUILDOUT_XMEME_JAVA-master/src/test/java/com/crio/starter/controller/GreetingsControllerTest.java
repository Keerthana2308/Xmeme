package com.crio.starter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.crio.starter.App;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.XmemeRepository;
import com.crio.starter.service.XmemeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;


class XmemeControllerTest {

  @Autowired
  private XmemeService xmemeService;

  private ResponseDto responseDto;

  @BeforeEach
  public void setup() {
      responseDto = new ResponseDto(1L, "Meme", "https://test.com/meme", "Caption");
      xmemeService.saveXmeme(responseDto);
  }

  @Test
  public void testSaveMemes() {

      ResponseDto dummy = new ResponseDto(2L, "Meme2", "https://test2.com/meme", "Caption2");

      xmemeService.saveXmeme(dummy);

      ResponseDto response = xmemeService.getMemeById(dummy.getId());

      assertEquals(dummy.getId(), response.getId());
      assertEquals(dummy.getName(), response.getName());
      assertEquals(dummy.getUrl(), response.getUrl());
      assertEquals(dummy.getCaption(), response.getCaption());

  }

}