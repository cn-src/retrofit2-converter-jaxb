[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/cn.javaer/retrofit2-converter-jaxb.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22cn.javaer%22%20AND%20a%3A%22retrofit2-converter-jaxb%22)
[![Build Status](https://travis-ci.org/cn-src/retrofit2-converter-jaxb.svg?branch=master)](https://travis-ci.org/cn-src/retrofit2-converter-jaxb)

Retrofit2 framework JAXB converter
==================================

## Use
Maven Central
```xml
<dependency>
    <groupId>cn.javaer</groupId>
    <artifactId>retrofit2-converter-jaxb</artifactId>
    <version>LATEST</version>
</dependency>
```

## Demo
```java
final Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("http://demo.com")
    .addConverterFactory(JaxbConverterFactory.create())
    .build();
```
