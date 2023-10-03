package com.crio.starter.repository;

import com.crio.starter.data.XmemeEnity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XmemeRepository extends MongoRepository<XmemeEnity,Long> {
   XmemeEnity findByName(String Name);
   XmemeEnity findByNameAndCaptionAndUrl(String name,String caption,String url);
}
