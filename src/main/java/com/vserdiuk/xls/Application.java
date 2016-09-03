package com.vserdiuk.xls;

import com.vserdiuk.xls.bl.XlsManagerImpl;
import com.vserdiuk.xls.entity.Company;
import com.vserdiuk.xls.xls.Reader;
import com.vserdiuk.xls.xls.ReaderImpl;
import com.vserdiuk.xls.xls.Writer;
import com.vserdiuk.xls.xls.WriterImpl;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by vserdiuk on 8/19/16.
 */
public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input file path: ");
        String fileName = scanner.next();

        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        XlsManagerImpl xlsManager = new XlsManagerImpl();

        List<Company> companies = reader.getCompanyList(fileName);
        System.out.println("Please wait while application is checking data. It could take some time");
        System.out.println("\n");

        List<String> buildingKeys = new ArrayList<>();
        buildingKeys.add("строитель");
        buildingKeys.add("строй");
        buildingKeys.add("дом");

        List<String> furnitureKeys = new ArrayList<>();
        furnitureKeys.add("ванн");
        furnitureKeys.add("душев");
        furnitureKeys.add("раковин");
        furnitureKeys.add("смесител");
        furnitureKeys.add("унитаз");
        furnitureKeys.add("биде");
        furnitureKeys.add("умывальник");
        furnitureKeys.add("гамак");
        furnitureKeys.add("гардероб");
        furnitureKeys.add("декор");
        furnitureKeys.add("диван");
        furnitureKeys.add("комод");
        furnitureKeys.add("кресл");
        furnitureKeys.add("кроват");
        furnitureKeys.add("кух");
        furnitureKeys.add("лежак");
        furnitureKeys.add("матрас");
        furnitureKeys.add("мебел");
        furnitureKeys.add("пенал");
        furnitureKeys.add("прихож");
        furnitureKeys.add("пуф");
        furnitureKeys.add("софа");
        furnitureKeys.add("стеллаж");
        furnitureKeys.add("стол");
        furnitureKeys.add("стул");
        furnitureKeys.add("табурет");
        furnitureKeys.add("тумб");
        furnitureKeys.add("ширм");
        furnitureKeys.add("шкаф");

        List<String> archetectureKeys = new ArrayList<>();
        archetectureKeys.add("архитектур");
        archetectureKeys.add("проект");
        archetectureKeys.add("бюро");
        archetectureKeys.add("проект дома");
        archetectureKeys.add("проекты домов");
        archetectureKeys.add("проект квартир");
        archetectureKeys.add("проект коттеджа");

        List<String> interiorKeys = new ArrayList<>();
        interiorKeys.add("дизайн");
        interiorKeys.add("авторский дизайн");
        interiorKeys.add("авторского дизайна");
        interiorKeys.add("декоратор");
        interiorKeys.add("дизайн ванной");
        interiorKeys.add("дизайна ванной");
        interiorKeys.add("дизайн ванных");
        interiorKeys.add("дизайна ванных");
        interiorKeys.add("дизайн домов");
        interiorKeys.add("интерьер");
        interiorKeys.add("дизайн интерьера");
        interiorKeys.add("дизайна интерьера");
        interiorKeys.add("дизайн интерьеров");
        interiorKeys.add("дизайна интерьеров");
        interiorKeys.add("дизайн квартир");
        interiorKeys.add("дизайн коттеджей");
        interiorKeys.add("дизайн кухни");
        interiorKeys.add("дизайна кухни");
        interiorKeys.add("дизайн кухонь");
        interiorKeys.add("дизайна кухонь");
        interiorKeys.add("дизайн нежилых помещений");
        interiorKeys.add("дизайн помещения");
        interiorKeys.add("дизайн помещений");
        interiorKeys.add("дизайна помещений");
        interiorKeys.add("дизайн прихожей");
        interiorKeys.add("дизайна прихожей");
        interiorKeys.add("дизайн прихожих");
        interiorKeys.add("дизайна прихожих");
        interiorKeys.add("дизайн спальни");
        interiorKeys.add("дизайна спальни");
        interiorKeys.add("дизайн спален");
        interiorKeys.add("дизайна спален");
        interiorKeys.add("дизайнер");
        interiorKeys.add("дизайнеры");
        interiorKeys.add("дизайнеров");
        interiorKeys.add("дизайнерский");
        interiorKeys.add("дизайнерский");
        interiorKeys.add("дизайнерская");
        interiorKeys.add("дизайнерского");
        interiorKeys.add("дизайн-проект");
        interiorKeys.add("интерьера");
        interiorKeys.add("интерьеров");
        interiorKeys.add("проектирование");
        interiorKeys.add("проекты");
        interiorKeys.add("студия дизайна");

        xlsManager.check(companies, buildingKeys, furnitureKeys,
                archetectureKeys, interiorKeys);

        try {
            writer.createXLS(companies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
