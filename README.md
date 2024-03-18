# URL Shortener

## Problem
Users are unable to share long URLs in their twitter, as twiter message only support a 140 character limit.


## Problem Breakdown
URLs can get extramely long. Twitter users are unable to share links due to the 140 character limit on twitter messages.

We need a way to shorten ULRs small enough that they can been shared via twitter, but also leave room for a brief message as well.

### Expected usuage
Currently in 2006, twitter sees around 20,000 tweets per day.

20,000 / 24(hrs) / 60 (mins) = 14 tweets per hour (rounded up from 13.888).

If half the tweets start to add our short URLs. We can assume 7 creates per hour with a read ratio of 10:1 becomes 70 reads per hour.


### Twitter message

We where able to get a domain name `shrtnr.com`. When shared on twitter will be `https://shrtnr.com`. This is 18 characters long. 25 characters with the unique identifier added `https://shrtner.com/5dG7vE9`. which leaves 115 characters for a brief message.

### Create Revenue
We will require a consistent source of revenue to pay for the system.
1. Paid subscriptions. A number of tiers with allowed number of create requests.
2. Wesite Advertising

#### Paid subscriptions
A paid subscription model would involve either:

**Integration of a third party service**<br>
Used to store and retrieve user credentials and handle billing. A unique identifier for the user will also need to be saved within our system to establishe limits for tiered pricing.

**Inhouse user authentication & authorization**<br>
We build our own authentication & authorization service. That will store user credentials and handle billing with a third party service.

#### Website advertising
Everyone can create a short URL and site advertising will generate income. To generate a re-occurring revenue stream we should only allow short urls to be saved within our system for a short time period of 7 to 14 days.

This would establishe repeat customers.

## Short URL Design
The short URL needs to be as short as possible.

To generate a short URL, what we need to do is generate a short alphanumeric unique identifer that is usable as part of a URL.

For example: `https://shrtner.com/5dG7vE9`.

However, we want to make the identifer unique to each request and not to each long URL. So the identifer can be used to lookup the long URL within the DB.

We could encode the URL using Base64 encoding, but if the same URL is add by another user, the same hash code will be generated. So we will need to make each URL unique.

Base64 encoding is used to convert binary data as printable text. So when using Base64 encoding we are guaranteed the code generated will be usuable within a URL.

To make the URL unique. We can create a random string, made up of a set number of random characters from the given URL. This random string can be added to the end of the URL before we encode it. Making it unique to each request.

The random string will not be saved as part of the long URL.

We will then take 7 characters from the Base64 encoded string as the unique identifer.


## Requirements

| Functional |
|----------- |
| Generate a unique identifier for each long URL |
| Receive a long URL and generate a short URL |
| Recieve a short URL, redirect user to long URL |
| Complete short URL should be no more than 30 characters |
| URLS will be deleted after a period of 7 days |

| Non-functional |
| -------------- |
| Low latency |
| High availablity |
| Generate income |


## High Level System Design
![](imgs/tinyurl-arc.png)

An API gateway will handle any DDos attacks and handle rate limiting.

One medium sized webserver and DB is only required for now. Should demand increase a load balancer can be added between the gateway and webservers.

## Data
Only three sets of data are required.
- Short URL = String
- Long URL = Text
- Created date = Timestamp


|  DB | Table | 
| - | - |
| PK  | ShortUrl |
|     | LongUrl  |
|     | Created  |

An SQL DB is preffered as the `INSERT` is handled in sequential order. Which means any collions on the short URLs can be handled.


## Endpoints
We will only require two REST endpoints. A `GET` & `POST`.

### POST /
```json
Accept: application/json

{
    "longUrl" : "https://..."
}
```

Request Details
| Property | Type | Description |
| ---- | ---- | ----------- |
| longUrl | String | The long URL to generate a short URL for. |

Response
```json
STATUS: 201 Created

{
    "shortUrl" : "https://shrtner/bR86d"
}
```

### GET /{shortUrl}

Request Deatils
| Path | Type | Description |
| ---- | ---- | ----------- |
| shortUrl | String | The short URL generated from long URL. |

Response
```json
STATUS: 301 Permanent Redirect
```


## Future Features
1. Endpoints for batch URL requests. Allowing users to request a list of urls to be processed or returned. So they can be displayed on the app/site.
2. Add payment tiers, so URLs can be kept for longer.
3. Include load balancer when required.
