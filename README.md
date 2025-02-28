# 🎮 eSports Tournament Management System

Welcome to the **eSports Tournament Management System**! This project is designed to manage eSports tournaments efficiently using object-oriented programming.

---

## 📌 Project Overview
This application helps organize and manage eSports tournaments, including players, teams and matches. It provides various functionalities such as registering players, managing teams, viewing tournaments, and updating match results.

### 🏗️ Project Structure
The project is divided into the following packages:

- **`tournament.main`** 📌 → Contains the main logic of the system.
  - `Main` 🏁 → The entry point of the application.
  - `TournamentManager` 🎮 → Manages tournaments, players, and teams.

- **`tournament.data`** 📂 → Stores classes and interfaces for tournament management.
  - `Tournament` 🏆 → Abstract class for tournaments.
  - `IndividualTournament` 🎭 → Tournament for solo players.
  - `TeamTournament` 🏅 → Tournament for teams.
  - `MixedTournament` ⚔️ → Tournament allowing both solo and team participation.
  - `Participant` 👤 → Abstract class for players and teams.
  - `Player` 🕹️ → Represents individual players.
  - `Team` 👥 → Represents a team of players.
  - `Match` ⚡ → Represents a match between participants.

- **`tournament.comparators`** 🔀 → Contains comparators for sorting data.
  - `MatchTournamentNameComparator` 🔄 → Compares matches by tournament name.
  - `PlayerRankingAndNameComparator` 🏅 → Compares players by ranking and name.
  - `PlayerRankingComparator` 🏆 → Compares players by ranking.
  - `TeamRankingComparator` 🏅 → Compares teams by ranking.
  - `TournamentNameComparator` 📜 → Compares tournaments by name.
- **`tournament.exceptions`** 🚨 → Handles a custom exception: `FullTeamException`.

---

## 🖥️ Menu Options
- 🔹 **1.View available tournaments ordered by name** 📜  
- 🔹 **2.View players information ordered by ranking and name** 🏅  
- 🔹 **3.View teams information ordered by ranking** 🏆  
- 🔹 **4.Add a new player to a team** ➕  
- 🔹 **5.Find an exact player by name** 🔍  
- 🔹 **6.Find players** 🏴  
- 🔹 **7.Find teams** ⚔️  
- 🔹 **9.Update the result of the matches pending** 📝  
- 🔹 **10.Exit** 🚪  

---

## 👥 Team Members
| Name | GitHub Username |
|-------|----------------|
| Marcos Varela Orchillés | [MarcosVaorDAW] / [MarcosVoDAW] |
| Nehuén Esteban Rojas Marsicano | [Manuel Gutierrez] |
| Lucía Navarro Cruz | [Lucia19-beep] |



