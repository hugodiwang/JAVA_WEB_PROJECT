package com.gallery.dao;

import java.util.ArrayList;
import java.util.List;

import com.gallery.entity.Painting;
import com.gallery.utils.PageModel;
import com.gallery.utils.XmlDataSource;
/***
 * paintingdao class is used to fetch the list of data in each page.
 * it communicates with xmldatasource class to get the pagemodel data.
 * 
 * @author dwang
 *
 */
public class PaintingDao {
	public PageModel pagination(int page, int rows) {
		List<Painting> data = XmlDataSource.getRawData();
		PageModel model = new PageModel(data, page, rows);
		return model;
	}
	
	public PageModel pagination(int category, int page, int rows) {
		List<Painting> data = XmlDataSource.getRawData();
		List<Painting> categorydata = new ArrayList<>();
		for(Painting painting : data) {
			if(painting.getCategory() == category)
				categorydata.add(painting);
		}
		PageModel pageModel = new PageModel(categorydata, page, rows);
		return pageModel;
	}
}
