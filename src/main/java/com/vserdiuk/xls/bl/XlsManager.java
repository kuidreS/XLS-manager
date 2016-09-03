package com.vserdiuk.xls.bl;

import com.vserdiuk.xls.entity.Company;

import java.util.List;

/**
 * Created by vserdiuk on 9/3/16.
 */
public interface XlsManager {

    void check(List<Company> companies, List<String> buildingKeys, List<String> furnitureKeys,
               List<String> archetectureKeys, List<String> interiorKeys);

}
