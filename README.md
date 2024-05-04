# Contrast Accessibility
[![Build](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/build.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/build.yml)
[![Lint](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/lint.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/lint.yml)
[![Test](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/test.yml/badge.svg)](https://github.com/BenMMcLean/contrast-accessibility/actions/workflows/test.yml)

Provides a utility class for checking contrast accessibility between colors and calculating contrast ratios using the standards defined in WCAG 2.1.

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