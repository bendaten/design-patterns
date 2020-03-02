# Design Patterns

### Telusko - Youtube course

## Syllabus

### 1. Overview

Solutions to common problems
3 types - Creation, Structural, and Behavioral

### 2. Factory

Client deals with just one factory class and doesn’t need to understand the different implementation of an interface

### 3. Builder

Avoid calling the constructor, especially useful for classes with many required fields.
Setters should return the builder object so that they can be chained.

### 4. Adapter

Use case - employing a 3rd party class which we want to use but cannot change and want to match an existing interface

### 5. Composite

Example of a tree-like objects

### 6. Prototype

When a class initiation may require a lot of resources (like accessing a database and loading a lot of data) - create a prototype and initialize it. Then copy to all subsequent instances.

**Note** - do not use Cloneable and .clone() as Navin suggests - it is not recommended (SonarLint and some articles on the web). Use a copy constructor with a customized deep copy where needed - see my example

### 7 Observer

Example - push notifications like youtube channel notifications to subscribers when a video is uploaded

## References

[This course youtube playlist](https://www.youtube.com/playlist?list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol)
[My followup examples](https://github.com/bendaten/design-patterns)
