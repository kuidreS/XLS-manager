# XLS manager

The application reads data from input XLS file (company name and company email). 
After parsing XLS file it checks data:

* if email registered on free post domain app should mark current free email column as TRUE and webpage column as 'Not available'.
* if data on company web page consits of key word - mark current category

After checking data app should create result file on computer Desktop.

## Dependencies

* poi-ooxml
* poi
* javax.mail

## Plugin

* maven-assembly-plugin
