# Hexagonal Architecture Server

## Overview

The **Hexagonal Architecture Server** is a robust backend solution built around the principles of **Hexagonal Architecture** (also known as **Ports and Adapters**). This project is designed to provide a clean, scalable, and maintainable approach to backend software development. It demonstrates the application of **Clean Architecture** and design patterns, with a strong focus on modularity, testability, and extensibility.

By adhering to these principles, the project showcases how to build a backend system that is both easy to test and extend, while ensuring separation of concerns and clear system boundaries.

---

## Key Features

### **Hexagonal Architecture Implementation**
The system follows **Hexagonal Architecture** principles, which separate the core domain logic from external systems and interfaces. This results in improved modularity, easier testing, and more maintainable code.

### **Decoupled Layers**
The application is structured into well-defined layers, including **Domain**, **Application**, **Adapters**, and **Ports**. This promotes separation of concerns and enhances the maintainability and clarity of the codebase.

### **Test-Driven Development (TDD)**
The project follows **TDD** practices, with an emphasis on **unit** and **integration tests** to ensure code reliability, robustness, and correct behavior across different layers of the application.

### **Flexible Integration**
The server is designed for easy integration with various external systems, such as **databases**, **APIs**, and **third-party services**, through well-defined adapters and ports. This enables the application to remain adaptable and extensible.

### **Scalability and Extensibility**
The architecture supports seamless modifications and extensions, allowing new features or external systems to be integrated without disrupting the existing functionality.

### **Clean Code Principles**
The codebase follows **Clean Code** practices to ensure readability, maintainability, and ease of collaboration. Emphasis is placed on clear, concise code, proper documentation, and adherence to industry best practices.

---

## Tech Stack

This project leverages the following technologies:

- **Java 21**
- **Spring Boot 3.3.0**
- **Maven**
- **PostgreSQL**

---

## Project Structure

The application is organized into several distinct layers:

- **Domain Layer**: Contains the core business logic, independent of any external systems.
- **Application Layer**: Acts as the intermediary between the domain logic and the outer layers.
- **Adapters**: External systems such as databases, APIs, and other services interact with the core system through well-defined adapters.
- **Ports**: Interfaces that define the contracts for interactions with external services, ensuring loose coupling and scalability.

This separation enables testing and evolving each component independently while maintaining a well-organized system architecture.

---

## Resources

The following resources have been instrumental in the development of this project:

### **Books**

- **[Get Your Hands Dirty on Clean Architecture: Build 'clean' applications with code examples in Java, Second Edition](https://www.packtpub.com/en-us/product/get-your-hands-dirty-on-clean-architecture-9781805128373)**  
  An in-depth guide to implementing Clean Architecture with practical Java examples.

- **[Clean Architecture: A Craftsman's Guide to Software Structure and Design (Robert C. Martin Series)](https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164)**  
  A classic resource on software architecture from Robert C. Martin, a leading authority in the field.

### **Hexagonal Architecture**

- [Onion Architecture with Spring Boot](https://blog.mimacom.com/onion-architecture-spring-boot/)
- [Unit Tests for Software Architecture](https://blog.mimacom.com/unit-tests-for-software-architecture/)
- [How I Put It All Together: DDD, Hexagonal, Onion, Clean, CQRS](https://herbertograca.com/2017/11/16/explicit-architecture-01-ddd-hexagonal-onion-clean-cqrs-how-i-put-it-all-together/)
- [Ports & Adapters Architecture Example](https://wkrzywiec.medium.com/ports-adapters-architecture-on-example-19cab9e93be7)
- [The Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Using Value Objects with JPA](https://dev.to/peholmst/using-value-objects-with-jpa-27mi)
- [Spring Boot: Power of Value Objects](https://dev.to/kirekov/spring-boot-power-of-value-objects-1oah)

### **Integration Testing**

- [Testcontainers Spring Boot Setup](https://maciejwalkowiak.com/blog/testcontainers-spring-boot-setup/)
- [Spring Boot Integration Tests with WireMock and JUnit 5](https://rieckpil.de/spring-boot-integration-tests-with-wiremock-and-junit-5/)
- [Spring Boot TestConfiguration Best Practices](https://reflectoring.io/spring-boot-testconfiguration/)

---

## Conclusion

The **Hexagonal Architecture Server** project exemplifies best practices in backend development, showcasing the use of modern software architecture principles to create clean, scalable, and maintainable systems. By utilizing **Hexagonal Architecture**, **Clean Architecture**, and **Test-Driven Development**, this project highlights my skills in building flexible and extensible backend systems with a focus on high code quality.

Feel free to explore the repository and contribute to the project. Your feedback and contributions are always welcome!

---

## Trademark & Author Acknowledgment

The **Hexagonal Architecture Server** project is designed, developed, and maintained by **Panagiotis Yfantis**. All rights to the project's design, implementation, and associated content are owned by the author unless otherwise noted.

- **Panagiotis Yfantis** is the sole author of this repository.
- **Hexagonal Architecture** and **Clean Architecture** are widely recognized design patterns and concepts. The use of these patterns in this project is based on publicly available principles and frameworks, and they are not proprietary to this repository.

This project is licensed under the [MIT License](LICENSE.md). You are free to use, modify, and distribute the code in accordance with the terms of the MIT License, as long as you include the original copyright notice and this license text in all copies or substantial portions of the software.

For more information or to connect with the author, visit [Panagiotis Yfantis on LinkedIn](https://www.linkedin.com/in/panosyf/) or check out the author's GitHub profile at [Panagiotis Yfantis on GitHub](https://github.com/panosyf).

---

© 2024 **Panagiotis Yfantis**. All rights reserved.

