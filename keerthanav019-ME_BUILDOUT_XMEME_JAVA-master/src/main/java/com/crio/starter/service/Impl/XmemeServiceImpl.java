package com.crio.starter.service.Impl;

import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import com.crio.starter.data.SequenceGeneratorService;
import com.crio.starter.data.XmemeEnity;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.XmemeRepository;
import com.crio.starter.service.XmemeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class XmemeServiceImpl implements XmemeService{

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService; 
    @Autowired
    private ModelMapper modelMapper; 
    
    @Autowired
    private MongoTemplate mTemplate;
  
    @Autowired
    private XmemeRepository xmemeRepository;
   
public ResponseDto saveXmeme(ResponseDto responseDto)
{
  ResponseDto xmemeresponse=null;
  if(responseDto.getName()==null || responseDto.getCaption()==null || responseDto.getUrl()==null)
  {
    return null;
  }
 
try{
  XmemeEnity xmemeEnity=modelMapper.map(responseDto, XmemeEnity.class);
  XmemeEnity xmemeduplicate= xmemeRepository.findByNameAndCaptionAndUrl(xmemeEnity.getName(), xmemeEnity.getCaption(), xmemeEnity.getUrl());
    if(xmemeduplicate!=null)
    {
      return null;
    }
    xmemeEnity.setId(sequenceGeneratorService.generateSequence());
xmemeRepository.save(xmemeEnity);
xmemeresponse=modelMapper.map(xmemeEnity, ResponseDto.class);
}
catch (Exception e) {
  System.err.println(e.getMessage());
}


return xmemeresponse;
}

public List<ResponseDto> getMemes()
{

List<ResponseDto> responseDtos = new ArrayList();
    List<XmemeEnity> xmemeEntity;
    
    try {
      Aggregation aggregation = Aggregation.newAggregation(
      Aggregation.sort(Sort.Direction.DESC, "_id"),
      Aggregation.limit(100));

      xmemeEntity = mTemplate.aggregate(aggregation, "memes", XmemeEnity.class).getMappedResults();


      for(XmemeEnity entity : xmemeEntity){
        responseDtos.add(modelMapper.map(entity, ResponseDto.class));
      }

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return responseDtos;

}

@Override
public ResponseDto getMemeById(long id) {
    ResponseDto responseDto = null;
    XmemeEnity xmemeEntity = null;
    try {
      xmemeEntity = xmemeRepository.findById(id).get();

      responseDto = modelMapper.map(xmemeEntity, ResponseDto.class);

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    
    return responseDto;
}
    
}
