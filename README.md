# 🐉 Mythical Creature Caretaker (Java OOP)

## 📌 Project Overview
This Java application is a survival simulation where the user acts as a caretaker for various mythical entities. The project demonstrates the application of **Object-Oriented Programming (OOP)** and **algorithmic resource management**.

The core challenge involves maintaining the health and temperament of five distinct creatures across multiple rounds, ensuring their "Killer Score" does not reach fatal levels.



## 🚀 Key Features
* **Encapsulated Entity Management**: Uses a custom `Creature` class to store state-specific data such as `Anger_level`, `Hunger_level`, and `Illness_level`.
* **Strategic Game Loop**: A modular `Playgame` method that allows users to interact with entities through specific actions: `Givewater`, `Givefood`, `Vaccinate`, and `Moveit`.
* **Dynamic Risk Assessment**: An algorithm-based `Danger_Message` system that provides real-time feedback (e.g., "Peaceful," "Miffed," or "DANGEROUS") based on the creature's current stats.
* **Input Validation**: A robust `CheckValid` system that ensures only authorized commands are processed, preventing system crashes.

## 🛠 Technical Implementation
* **Data Structures**: Managed a collection of entities using an array of objects (`Creature[] creature_record`).
* **Stat Weighting**: Implemented a weighted calculation to derive a `Killer_Score` from individual attributes.
* **Modular Design**: Organized logic into reusable static methods, separating data printing from core calculation logic.

## 📈 Database Foundations (ER Concept)
This project serves as a practical foundation for **Relational Model mapping**:
* **Entity Type**: The `Creature` class acts as a strong entity type.
* **Attributes**: Includes simple attributes (e.g., `Anger_level`) and unique identifiers (e.g., `Name`).



## 🛡️ Setup & Usage
1. **Ensure Java is installed** on your system.
2. **Clone the Repository**: `git clone https://github.com/SabeehAshir/Mythical-Creature-Game`
3. **Compile**: 
   ```bash
   javac Mythical_Creature.java
