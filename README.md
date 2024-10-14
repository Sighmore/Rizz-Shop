# Stock, Cashflow & Debt Management Android App

## Overview

This Android application helps users manage stock, cash flow (cash and float), and debts effectively. It is built using **Kotlin**, **Jetpack Compose**, **LiveData**, **ViewModel**, **App Navigation**, and **Room Database**. The app provides a user-friendly interface and smooth user experience for managing inventories, tracking cash movements, monitoring float balances, and keeping records of debts.

## Features

- **Stock Management**: Users can add, edit, and delete stock items. The app provides an inventory list with detailed information such as product name, quantity, and price.
  
- **Cashflow Management**:
  - Manage both **cash on hand** and **float**.
  - Track income and expenses over time.
  - View historical cashflow data to monitor financial health.

- **Debt Management**:
  - Record debts owed by customers.
  - Record debts you owe to suppliers.
  - Mark debts as paid and view outstanding balances.
  
- **Live Data Updates**: The app uses **LiveData** to provide real-time updates across the UI, ensuring the most up-to-date information is always displayed.

- **ViewModel Architecture**: Each key component (Stock, Cashflow, and Debt Management) is encapsulated in a **ViewModel** for a separation of concerns and better management of lifecycle-related issues.

- **Room Database**: All data, including stock items, cashflow records, and debt details, are persisted using **Room Database**, ensuring the data is saved locally and accessible even when offline.

- **Jetpack Compose UI**: The app leverages **Jetpack Compose** for building modern, responsive UIs in a declarative way, offering a seamless user experience.

- **Navigation Component**: The app implements **App Navigation** to provide a smooth and intuitive navigation experience between screens, ensuring users can move between stock, cashflow, and debt management sections easily.

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Database**: Room Database
- **Architecture**: MVVM (Model-View-ViewModel)
- **LiveData**: For real-time UI updates.
- **Navigation**: Jetpack Navigation Component
- **Coroutines**: Used for background processing and async tasks.

## Project Structure

- **UI Layer**: Contains all the Compose-based UI components that are used to display the stock, cashflow, and debt data.
- **ViewModel Layer**: Manages the app's UI-related data in a lifecycle-conscious way and handles communication between the repository and the UI.
- **Repository Layer**: Acts as a single source of truth for all data-related operations, interacting with the Room database for data persistence.
- **Database Layer**: Implements the Room database, which is responsible for storing and retrieving data.

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Sighmore/Rizz-shop.git
   ```

2. Open the project in **Android Studio**.

3. Build the project and run it on an emulator or a physical Android device.

## Usage

- **Add Stock**: Navigate to the stock management section to add new stock items. Input details like product name, quantity, and price.
- **Track Cashflow**: Use the cashflow section to log income or expenses, and track how your cash and float balances change over time.
- **Manage Debts**: Navigate to the debt section to add new debts or record payments made towards existing debts.

## Future Enhancements

- **Export Data**: Allow users to export stock, cashflow, and debt data as CSV or PDF files.
- **Multi-Currency Support**: Add support for managing multiple currencies in the app.
- **Notifications**: Add reminders for debt payments and low stock alerts.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
