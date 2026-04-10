# Attack Surface PoC Labs - Hextree Consolidated 🛡️

![Android Security](https://img.shields.io/badge/Focus-Android%20Security-green)
![Hextree](https://img.shields.io/badge/Course-Hextree.io-orange)

A practical Android Security project that consolidates **41 real-world PoCs (Proof of Concepts)** into a single application.

Originally solved as separate labs, this project was rebuilt to **deepen understanding of Android internals and vulnerability exploitation** — transforming isolated challenges into a **complete attack surface playground**.

---

## 📱 Project Overview

This application provides a **unified environment** to explore and exploit common Android vulnerabilities across different components.

It focuses on **Inter-Process Communication (IPC)** weaknesses and real-world attack scenarios, making it a useful reference for:

- Mobile Security Engineers  
- Pentesters  
- Android Developers learning secure coding  

---

## 🚀 Key Features

- 🔹 41 consolidated PoCs in one APK  
- 🔹 Organized by Android component & attack vector  
- 🔹 Real exploitation scenarios (not just theory)  
- 🔹 Clean and simple UI for navigation  
- 🔹 Covers major Android attack surfaces  

---

## 📸 Screenshots

![App Screenshot](./screenshots/main.png)

---

## 📂 Categories & Lab Count

| Category               | Lab Count | Description                                  |
| :--------------------- | :-------: | :------------------------------------------- |
| **Activity**           |     7     | Exported activities & Intent filter bypasses |
| **ActivityResult**     |     2     | Hijacking activity result data               |
| **Implicit Intents**   |     3     | Exploiting non-specific intent routing       |
| **DeepLink**           |     3     | URI scheme abuse & data leaks                |
| **Broadcast Receiver** |     6     | Malicious broadcasts & unprotected receivers |
| **PendingIntent**      |     2     | Privilege escalation via hijacking           |
| **Service**            |     6     | Exploiting insecure services                 |
| **Content Provider**   |     5     | Unauthorized access & SQL injection          |
| **File Provider**      |     4     | Path traversal & misconfigurations           |
| **WebView**            |     4     | JavaScript injection & XSS                   |

---

## 🛠️ Build & Installation

```bash
git clone https://github.com/0xbedo/Android-Attack-Surface-Labs.git
```

## 📥 Download

You can download the ready-to-install APK from the [Releases Section](https://github.com/0xbedo/Android-Attack-Surface-Labs/releases).
