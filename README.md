# Contrast Accessibility
[![Build](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/build.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/build.yml)
[![Lint](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/lint.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/lint.yml)
[![Test](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/test.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/test.yml)

A library providing the famous ["human readable bytes" StackOverflow answer](https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java).

## Installation
![Stable](https://img.shields.io/github/v/release/BenMMcLean/contrast-accessibility?label=Stable)
![Preview](https://img.shields.io/github/v/release/BenMMcLean/contrast-accessibility?label=Preview&include_prereleases)

```
implementation "cl.emilym:contrast-accessibility:<latest>"
```

## Usage
```java
long color1 = 0xFF0000; // Red
long color2 = 0x000000; // Black
System.out.println(ContrastAccessibility.valid(color1, color2)); // True
```