package com.vserdiuk.xls.xls;

import com.vserdiuk.xls.entity.Company;

import java.util.List;

/**
 * Created by vserdiuk on 7/20/2016.
 */
public interface Reader {

    List<Company> getCompanyList(String filePath);

}
