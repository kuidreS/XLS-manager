package com.vserdiuk.xls.entity;

/**
 * Created by vserdiuk on 7/25/2016.
 */
public enum CommonPostClient {

    MAIL_RU("mail.ru"),
    GMAIL_COM("gmail.com"),
    YANDEX_RU("yandex.ru"),
    LIST_RU("list.ru"),
    INBOX_RU("inbox.ru"),
    YA_RU("ya.ru"),
    BK_RU("bk.ru"),
    OUTLOOK_COM("outlook.com"),
    MAIL_YAHOO_COM("mail.yahoo.com"),
    GMS_NET("gmx.net"),
    MAIL_AOL_COM("mail.aol.com"),
    ZOHO_COM(".zoho.com"),
    MAIL_LYCOS_COM("mail.lycos.com"),
    INBOX_COM("inbox.com"),
    HUSJMAIL_COM("hushmail.com");

    private String value;

    CommonPostClient(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
