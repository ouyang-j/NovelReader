# Novel Reader (Android)

A lightweight Android application for reading internal novels, featuring an optimized keyword search engine built from scratch using Binary Search Tree (BST) algorithms.

## 1. Overview
This project was developed using **Java** and **Android Studio**. It serves as a proof-of-concept for handling text-based data efficiently on mobile devices without relying on external databases.

## 2. Key Features
* **Offline Reading:** Internal novel library stored within the app.
* **Algorithmic Search:** Implemented a Binary Tree search algorithm to handle keyword lookups across string arrays, significantly reducing search time compared to linear iteration.
* **User Interface:** Custom list views for novel selection and a dedicated reading mode.

## 3. Technical Deep Dive: Search Logic
Instead of using standard library search functions, I implemented a **Binary Search Tree (BST)** to manage keywords.
* **Data Structure:** Nodes containing String values from the novel arrays.
* **Optimization:** The tree is balanced during construction to ensure $O(\log n)$ search complexity, making keyword jumps nearly instantaneous.

## 4. Tech Stack
* **Language:** Java
* **IDE:** Android Studio
* **Data Structures:** Binary Trees, String Arrays
