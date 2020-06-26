Feature: Data driven test
test driven approach

Scenario Outline: Multiple Logins
Given Adithya is in demo webshop
When Adithya gives valid "<username>" "<password>"
Then Adithya is able to see homepage

Examples:
|username|password|
|var123@abc.com|adithya1|
|adi123@abc.com|vardhan1|
|kode123@abc.com|var12345|
|adi.kode1@abc.com|adi12345|


