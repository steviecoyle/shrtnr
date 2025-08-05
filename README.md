![Java](https://img.shields.io/badge/java-17-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-3.1.10-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-5.7.41-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.7-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

# shrtnr

'shrtnr' is a RESTful API URL Shortener service, created in Java and Spring boot.

## Problem Breakdown

URLs and links to documents can be extremely long to share in emails, DMs or chat channels within organisations.
These links can detract from the central message.

Organizations need an in-house way to shorten ULRs small enough so they can been shared without taking up valuable space.

### Expected usage

## Short URL Design

## Requirements

| Functional                                                         |
|--------------------------------------------------------------------|
| Generate a unique identifier for each long URL                     |
| Receive a long URL and generate a short URL                        |
| Recieve a short URL, redirect user to long URL                     |
| Complete short URL should be no more than 30 characters            |
| URLS will be deleted after 3 months if they have not been accessed |

| Non-functional |
| -------------- |
| Low latency |
| High availablity |