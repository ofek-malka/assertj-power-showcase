# AssertJ Power Showcase 💥

A modern Java 21+ demo project that showcases the expressive, fluent, 
and readable power of **AssertJ** with **JUnit 5**.

> 🧪 No boilerplate. No legacy. Just clean, modern assertions.

---

## 🔍 What's Included?

This project demonstrates how to:

- ✅ Write fluent and expressive assertions for **strings**, **collections**, **maps**, **files**, and **custom objects**
- ✅ Test exceptions clearly and concisely
- ✅ Use `extracting` to assert object properties
- ✅ Replace multiple `assertEquals` calls with intention-revealing one-liners

---

## 🚀 Getting Started

### Prerequisites

- Java **21+**
- Maven

### 🔧 Run the Tests

```bash
mvn clean test
```

### ✨ Example Assertions
```java
// String assertions
assertThat("I love Java and AssertJ")
		.contains("Java")
		.containsIgnoringCase("assertj")
		.doesNotContain("Python");
```

```java
// Collection assertions
		assertThat(langs)//
		.hasSize(3)//
		.contains("Java")//
		.doesNotContain("PHP");
```

```java
// File assertions
assertThat(pathToFile)
    .exists()
    .isReadable()
    .hasExtension("txt");
```

```java
// Exception testing
assertThatThrownBy(() -> divideByZero())
    .isInstanceOf(ArithmeticException.class)
    .hasMessageContaining("/ by zero");
```

```java
// Custom object property testing
		assertThat(person)
		.extracting(Person::name, Person::age)
		.containsExactly("Bob", 25);
  ```
  
  
  ```java
// 🛠 Custom Assertions Example
assertThat(person)
  .hasName("Ofek")
  .isAdult()
  .hasAddress()
    .hasCity("Tel Aviv");

  ```
    
### 📚 Why AssertJ?
 ✅ Fluent and human-readable

 ✅ Better failure messages than JUnit

 ✅ Extensible and composable

 ✅ Massive set of built-in assertions

### 🛠 Tech Stack
- Java 21

- JUnit 5

- AssertJ

- Maven

#### 🤝 Contributing
Pull requests are welcome!
Add new examples, fix typos, or suggest improvements.
**Let’s make testing expressive and joyful. ✨**