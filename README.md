
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cn.javaer/retrofit2-converter-jaxb/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cn.javaer/retrofit2-converter-jaxb)
[![Release](https://jitpack.io/v/cn-src/retrofit2-converter-jaxb.svg)](https://jitpack.io/#cn-src/retrofit2-converter-jaxb)

Retrofit2 framework JAXB converter
==================================

[No longer maintained, please use: https://github.com/square/retrofit/tree/master/retrofit-converters/jaxb](https://github.com/square/retrofit/tree/master/retrofit-converters/jaxb)

[Retrofit 官方已增加对 jaxb 的支持, 请使用: https://github.com/square/retrofit/tree/master/retrofit-converters/jaxb](https://github.com/square/retrofit/tree/master/retrofit-converters/jaxb)
<!-- [![Build Status](https://travis-ci.org/cn-src/retrofit2-converter-jaxb.svg?branch=master)](https://travis-ci.org/cn-src/retrofit2-converter-jaxb) -->
<!-- [![Libraries.io for GitHub](https://img.shields.io/librariesio/github/cn-src/retrofit2-converter-jaxb.svg)](https://libraries.io/github/cn-src/retrofit2-converter-jaxb) -->
<!-- [![coverage](https://sonarcloud.io/api/badges/measure?key=cn.javaer:retrofit2-converter-jaxb&metric=coverage)](https://sonarcloud.io/dashboard/index/cn.javaer:retrofit2-converter-jaxb) -->
<!-- [![bugs](https://sonarcloud.io/api/badges/measure?key=cn.javaer:retrofit2-converter-jaxb&metric=bugs)](https://sonarcloud.io/dashboard/index/cn.javaer:retrofit2-converter-jaxb) -->
<!-- [![vulnerabilities](https://sonarcloud.io/api/badges/measure?key=cn.javaer:retrofit2-converter-jaxb&metric=vulnerabilities)](https://sonarcloud.io/dashboard/index/cn.javaer:retrofit2-converter-jaxb) -->
<!-- [![code_smells](https://sonarcloud.io/api/badges/measure?key=cn.javaer:retrofit2-converter-jaxb&metric=code_smells)](https://sonarcloud.io/dashboard/index/cn.javaer:retrofit2-converter-jaxb) -->
<!-- [![duplicated_lines_density](https://sonarcloud.io/api/badges/measure?key=cn.javaer:retrofit2-converter-jaxb&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard/index/cn.javaer:retrofit2-converter-jaxb) -->

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


