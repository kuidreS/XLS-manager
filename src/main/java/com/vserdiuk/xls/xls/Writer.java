package com.vserdiuk.xls.xls;

import com.vserdiuk.xls.entity.Company;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by vserdiuk on 30.07.16.
 */
public interface Writer {

    void createXLS(List<Company> companies) throws FileNotFoundException;

}
