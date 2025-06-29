# Sky-Pay

This repository contains the exercises as requested in the email. Both projects are **Maven-based** and built with **Java 17**.

---

## 📁 Projects Overview

### 🏦 Banking Exercise

The banking module includes the core functionality of a simple banking system, including deposit, withdrawal, and transaction history. Unit tests are also provided to validate the logic.

#### How to Run
1. Open the project in your IDE.
2. Run the `main` method.
3. Follow the input prompts in the console.

#### Console Output Example

The application provides clear feedback for each operation:

![Sample Output](https://github.com/user-attachments/assets/a5e824a2-6b58-45f5-a8fb-346474475c4e)

You can also display the full transaction stack:

![Transaction Stack](https://github.com/user-attachments/assets/886d9d4c-25f5-42f0-b2b6-999bc27c614c)

---

### 🏨 Hotel Application

This module simulates a basic hotel room booking system. You can run the `main` method to interact with it.

#### Test Results

Below is a screenshot of the test case results:

![image](https://github.com/user-attachments/assets/d0598f6e-8a4b-492c-ac85-23a48b2da6d3)

---

## 💡 Bonus Questions – Design Discussion

### 1. Should we put all the functions inside the same service?

No, placing all functions in a single service is not recommended. It breaks the **Single Responsibility Principle (SRP)** and leads to tightly coupled, hard-to-maintain code.

Instead, functions should be distributed across multiple focused services—each handling a specific responsibility (e.g., `BookingService`, `RoomService`). This promotes **locality of behavior**, improves testability, and enhances modularity.

### 2. In this design, we chose to have a `setRoom(...)` method that should not affect previous bookings. What is another way? What do you recommend?

A better approach is to avoid mutating the existing data and instead use **immutable** or **Clone** objects.

---

## ✅ Requirements

- Java 17
- Maven 3.6+
---


