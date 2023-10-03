package com.crio.starter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crio.starter.exchange.ResponseDto;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

// @ExtendWith(MockitoExtension.class)
// @MockitoSettings(strictness = Strictness.STRICT_STUBS)
class GreetingsServiceTest {

    // @Autowired
    // private XmemeService xmemeService;
  
    // private ResponseDto responseDto;
  
    // @BeforeEach
    // public void setup() {
    //     responseDto = new ResponseDto(1L, "Meme", "https://test.com/meme", "Caption");
    //     xmemeService.saveXmeme(responseDto);
    // }
  
    // @Test
    // public void testSaveMemes() {
  
    //     ResponseDto dummy = new ResponseDto(2L, "Meme2", "https://test2.com/meme", "Caption2");
  
    //     xmemeService.saveXmeme(dummy);
  
    //     ResponseDto response = xmemeService.getMemeById(dummy.getId());
  
    //     assertEquals(dummy.getId(), response.getId());
    //     assertEquals(dummy.getName(), response.getName());
    //     assertEquals(dummy.getUrl(), response.getUrl());
    //     assertEquals(dummy.getCaption(), response.getCaption());
  
    // }
  
 }