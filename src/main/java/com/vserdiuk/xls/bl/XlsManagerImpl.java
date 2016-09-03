package com.vserdiuk.xls.bl;

import com.vserdiuk.xls.entity.CommonPostClient;
import com.vserdiuk.xls.entity.Company;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by vserdiuk on 8/19/16.
 */
public class XlsManagerImpl implements XlsManager {

    public void check(List<Company> companies, List<String> buildingKeys, List<String> furnitureKeys,
                 List<String> archetectureKeys, List<String> interiorKeys) {

        int i = 1;

        for (Company company : companies) {

            String email = company.getEmail();
            String domain = getDomain(email);
            String keyWord = email;

            //check if free accaunt
            if (isFreeAccount(domain)) {
                company.setFreeEmailDomain(true);
                company.setWebPage("Not available");
                System.out.println(i + ": " + company);
                i++;
                continue;
            } else {
                company.setWebPage("http://" + domain);
            }

            //check company name by key words
            boolean isBuilding = checkCompanyNames(company, buildingKeys);
            if (isBuilding) {
                company.setBuilding(true);
                System.out.println(i + ": " + company);
                i++;
                continue;
            }

            boolean isFurniture = checkCompanyNames(company, furnitureKeys);
            if (isFurniture) {
                company.setFurniture(true);
                System.out.println(i + ": " + company);
                i++;
                continue;
            }

            boolean isArchetecture = checkCompanyNames(company, archetectureKeys);
            if (isArchetecture) {
                company.setArchitecture(true);
                System.out.println(i + ": " + company);
                i++;
                continue;
            }

            boolean isInterior = checkCompanyNames(company, interiorKeys);
            if (isInterior) {
                company.setInterior(true);
                System.out.println(i + ": " + company);
                i++;
                continue;
            }

            //Check is email valid
            try {
                if (isEmailExist(domain) ||
                        (isKeyWordExist(domain, keyWord)) ||
                        (isEmailExistAtContacts(domain, keyWord))) {
                    company.setEmailValid(true);
                }
            } catch (NamingException e) {
                company.setEmailValid(false);

                System.out.println(i + ": " + company);

                i++;
                continue;
            } catch (UnknownHostException e) {
                company.setEmailValid(false);
                company.setWebPage("Not available");

                System.out.println(i + ": " + company);

                i++;
                continue;
            } catch (FileNotFoundException e) {
                company.setEmailValid(false);

                System.out.println(i + ": " + company);

                i++;
                continue;
            } catch (IOException e) {
                company.setEmailValid(false);
                company.setWebPage("Not available");

                System.out.println(i + ": " + company);

                i++;
                continue;
            }

            //Check web page according to a key words
            try {
                boolean isBuildingOnPage = isKeyWordMatchKeyWordList(domain, buildingKeys);
                if (isBuildingOnPage) {
                    company.setBuilding(true);
                    System.out.println(i + ": " + company);
                    i++;
                    continue;
                }

                boolean isFurnitureOnPage = isKeyWordMatchKeyWordList(domain, furnitureKeys);
                if (isFurnitureOnPage) {
                    company.setFurniture(true);
                    System.out.println(i + ": " + company);
                    i++;
                    continue;
                }

                boolean isIArchitectureOnPage = isKeyWordMatchKeyWordList(domain, archetectureKeys);
                if (isIArchitectureOnPage) {
                    company.setArchitecture(true);
                    System.out.println(i + ": " + company);
                    i++;
                    continue;
                }

                boolean isInteriorOnPage = isKeyWordMatchKeyWordList(domain, interiorKeys);
                if (isInteriorOnPage) {
                    company.setInterior(true);
                    System.out.println(i + ": " + company);
                    i++;
                    continue;
                }
            } catch (UnknownHostException e) {
                System.out.println(i + ": " + company);
                i++;
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(i + ": " + company);
                i++;
                continue;
            } catch (IOException e) {
                System.out.println(i + ": " + company);
                i++;
                continue;
            }

        }

    }

    private boolean isKeyWordMatchKeyWordList(String domain, List<String> keyWords) throws IOException {
        boolean isMatch = false;
        for (String keyWord : keyWords) {
            isMatch = isKeyWordExist(domain, keyWord);
            if (isMatch == true) {
                return  isMatch;
            }
        }
        return isMatch;
    }

    private boolean isEmailExist(String email) throws NamingException {
        boolean isExist = false;
        Hashtable env = new Hashtable();
        env.put("java.naming.factory.initial",
                "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext( env );
        Attributes attrs = ictx.getAttributes(email, new String[] { "MX" });
        Attribute attr = attrs.get( "MX" );
        if(( attr != null )) {
            isExist = true;
        }
        return isExist;
    }

    private boolean isKeyWordExist(String domain, String keyWord) throws IOException {
        boolean isKeyWordExist = false;
        String http = "http://";
        URL oracle = new URL(http + domain);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.toLowerCase().contains(keyWord.toLowerCase())) {
                isKeyWordExist = true;
                break;
            }
        }
        in.close();
        return isKeyWordExist;
    }

    private boolean isEmailExistAtContacts(String domain, String keyWord) throws IOException {
        boolean isEmailExist = false;
        String http = "http://";
        URL oracle = new URL(http + domain + "/contacts");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.toLowerCase().contains(keyWord.toLowerCase())) {
                isEmailExist = true;
                break;
            }
        }
        in.close();
        return isEmailExist;
    }

    private boolean checkCompanyNames(Company company, List<String> keyWords) {
        boolean isExist = false;
        for (String kyeWord : keyWords) {
            String companyName = company.getName();
            isExist = companyName.toLowerCase().contains(kyeWord.toLowerCase());
            if (isExist) {
                break;
            }
        }
        return isExist;
    }

    private boolean isFreeAccount(String domain) {
        boolean isFreeAccount = false;
        for (CommonPostClient commonPostClient : CommonPostClient.values()) {
            isFreeAccount = domain.equals(commonPostClient.getValue());
            if (isFreeAccount) {
                break;
            }
        }
        return isFreeAccount;
    }

    private String getDomain(String email) {
        return email.substring(email.lastIndexOf('@') + 1);
    }

}
