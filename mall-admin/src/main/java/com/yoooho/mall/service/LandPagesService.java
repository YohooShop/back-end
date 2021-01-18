package com.yoooho.mall.service;

import com.yoooho.mall.model.LandPages;

import java.util.List;

public interface LandPagesService {

   public int add(LandPages landPages);

   public  int update(LandPages landPages);

   public List<LandPages> list(Integer pageSize, Integer pageNum);
   public List<LandPages> listAll();
   public LandPages info(Long id);

   public int delete(Long id);

   public int updateStatus( Long id, boolean showStatus);
}
