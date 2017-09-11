[![GitHub tag](https://img.shields.io/github/tag/javaercn/retrofit2-converter-jaxb.svg)](https://github.com/javaercn/retrofit2-converter-jaxb/tags)
[![Maven Central](https://img.shields.io/maven-central/v/cn.javaer/retrofit2-converter-jaxb.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22cn.javaer%22%20AND%20a%3A%22retrofit2-converter-jaxb%22)
[![JitPack](https://img.shields.io/github/tag/javaercn/retrofit2-converter-jaxb.svg?label=JitPack)](https://jitpack.io/#javaercn/retrofit2-converter-jaxb)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

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
