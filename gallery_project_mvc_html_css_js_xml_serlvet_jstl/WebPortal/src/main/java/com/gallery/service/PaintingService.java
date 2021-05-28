package com.gallery.service;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.gallery.dao.PaintingDao;
import com.gallery.utils.PageModel;

/**
 * PaintingService provides all service logics. It bridges the gap between
 * controller and paintingDao. paintingDao is in charge of preparing data.
 * PaintingService is in charge of checking data.
 * 
 * @author dwang
 *
 */

public class PaintingService {
	private PaintingDao paintingDao = new PaintingDao();
	public PageModel pagination(int page, int rows, String... category) {
		if(rows == 0)
			throw new RuntimeException("rows starts from 1");
		
		if(category.length == 0 || category[0] == null)
			return paintingDao.pagination(page, rows);
		else {
			return paintingDao.pagination(Integer.parseInt(category[0]), page, rows);
		}
	}

}
