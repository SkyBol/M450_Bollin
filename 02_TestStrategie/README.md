# Aufgaben

## 1
### Abstrakte Testfälle

| Testfall |	Eingabe (Kaufpreis)                    |	Erwartetes Ergebnis |
|----------|-------------------------------------------|------------------------|
| Fall 1   |	Kaufpreis < 15'000 CHF                 |	Kein Rabatt         |
| Fall 2   |	15'000 CHF <= Kaufpreis <= 20'000 CHF  |	5% Rabatt           |
| Fall 3   |	20'000 CHF < Kaufpreis < 25'000 CHF    |	7% Rabatt           |
| Fall 4   |	Kaufpreis >= 25'000 CHF                |	8.5% Rabatt         |

### Konkrete Testfälle

| Testfall |	Eingabe (Kaufpreis)   |  Ergebnis    |
|----------|--------------------------|--------------|
| Fall 1   |	12'718 CHF            |	Kein Rabatt  |
| Fall 2   |    18'095 CHF            |	5% Rabatt    |
| Fall 3   |	23'631 CHF            |	7% Rabatt    |
| Fall 4   |	29'989 CHF            |	8.5% Rabatt  |


## 2
Ausgesuchte Website: https://www.avis.ch/

| ID | Beschreibung | Erwartetes Resultat | Effektives Resultat | Status | Mögliche Ursache |
|----|--------------|---------------------|---------------------|--------|------------------|
| 1  | Programm startet korrekt | Nach dem Aufruf des Programms auf der Konsole öffnet sich ein Fenster.| Programm stürzt ab mit Fehler X00234 | Fehler |Zugriff auf DB-Server evtl. nicht möglich |
| 2  | Anmeldung mit gültigen Anmeldeinformationen | Erfolgreicher Login | Erfolgreicher Login | Erfolg | - |
| 3  | Anmeldung mit ungültigen Anmeldeinformationen | Fehlermeldung "Ungültige Anmeldeinformationen" | Fehlermeldung "Falsches Passwort" | Fehler | Authentifizierungsproblem |
| 4  | Fahrzeugbuchung für ausgewählten Zeitraum | Erfolgreiche Buchung und Reservierung | Buchung fehlgeschlagen, Fahrzeug nicht verfügbar | Fehler | Fahrzeug bereits gebucht oder technisches Problem |
| 5  | Zahlungsvorgang für gebuchtes Fahrzeug | Erfolgreiche Abbuchung des Betrags | Zahlungsfehler, Transaktion abgebrochen | Fehler | Problem mit dem Zahlungsgateway oder Verbindung |
| 6  | Fahrzeugrückgabe nach gemieteter Zeit | Bestätigung der Rückgabe, Abrechnung des Mietbetrags | Fehlende Rückgabebestätigung, keine Abrechnung | Fehler | Technische Probleme mit der Rückgabelogik |

## 3
1. Identifzieren Sie mögliche Black-Box Testfälle, welche Sie als Benutzer testen können.
- Konto Erstellen mit Special Characters
- Konto mit Special Characters anzeigen lassen
- Ungültige Kontonummer abfragen
- Geld auf ein Konto abheben / hinterlegen
- Currency Converter nach der aktuellen Rate abfragen

2. Welche Methoden im Code könnten für White-Box Testfälle verwendet werden?
- deposit/withdraw
- convertCurrency von EUR-Konto zu USD Konto

3. Was würden Sie am Code generell verbessern, welche Best Practices fallen Ihnen ein
do {} while(true)
Input Sanitation
-> Eigene Scanner/Input Klasse
AccountExeption auslagern