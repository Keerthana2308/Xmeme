package com.crio.starter.service;

import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.XmemeRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;


public interface XmemeService {

  public ResponseDto saveXmeme(ResponseDto ResponseDto);
  public List<ResponseDto> getMemes();
  public ResponseDto getMemeById(long id);
}
