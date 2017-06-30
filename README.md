[![Release](https://jitpack.io/v/cn.javaer/retrofit2-converter-jaxb.svg)](https://jitpack.io/#cn.javaer/retrofit2-converter-jaxb)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
Retrofit2 framework JAXB converter
==================================

## Use
Step 1. Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
```xml
<dependency>
    <groupId>cn.javaer</groupId>
    <artifactId>retrofit2-converter-jaxb</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Demo
```java
final Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("http://demo.com")
    .addConverterFactory(JaxbConverterFactory.create())
    .build();
```
