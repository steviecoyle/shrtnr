![Java](https://img.shields.io/badge/java-17-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-3.1.10-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-5.7.41-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.7-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

# shrtnr

'shrtnr' is a RESTful API URL Shortener service, created in Java and Spring boot.

## Problem Breakdown

URLs and links to documents can be extremely long to share in emails, DMs or chat channels within organisations.
These links can detract from the central message.

Organizations need an in-house way to shorten ULRs, small enough so they can been shared without taking up valuable space.
For security, the short URLs should not be accessible from outside the company network.

### Expected usage

#### Assumptions
Although there is no specific data around users sharing links within a company.
The data that is available tends to be more qualitative and focused on the broader trends and impacts of employee sharing, rather than a quantitative measure of frequency.

However, several studies and reports provide insights into the habits and behaviors of enterprise employees when it comes to sharing information, which can give you a better understanding of the landscape:

- Prevalence of Sharing: A Veritas study found that 71% of employees globally admit to sharing sensitive and business-critical data using instant messaging and business collaboration tools. This highlights that link and URL sharing is a very common activity within the enterprise.


- Time Spent on Collaboration Tools: The same Veritas study noted that employees in the U.S. spend an average of 2.5 hours every day on messaging and collaboration applications like Teams and Zoom. This suggests that the environment for frequent link sharing is constantly active.


- Rule?


- Internal vs. External Sharing: The data available often makes a distinction between internal sharing (e.g., on a company intranet or Microsoft Teams) and external sharing (e.g., on LinkedIn or other public social media). Studies on employee advocacy show that content shared by employees on platforms like LinkedIn receives significantly more engagement than content shared by the corporate account.


- Security Concerns: A large body of research, while not focused on frequency, highlights the security risks associated with employee link sharing. This includes the sharing of sensitive data, which can lead to data breaches and compliance issues. The frequent use of messaging and collaboration tools for sharing reinforces these security concerns.




## Short URL Design

### How long does the short URL need to be?

### What are the DB requirements?
Reads, Writes & Storage.

## Requirements

| Functional                                                         |
|--------------------------------------------------------------------|
| Generate a unique identifier for each long URL                     |
| Receive a long URL and generate a short URL                        |
| Recieve a short URL, redirect user to long URL                     |
| Complete short URL should be no more than 30 characters            |
| URLS will be deleted after 5 years if they have not been accessed  |
| Short URLs clicked outside the company network should not function |

| Non-functional |
| -------------- |
| Low latency |
| High availablity |