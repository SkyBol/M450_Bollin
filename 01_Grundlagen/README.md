# Aufgaben

## 1
### Welche Formen von Tests kennen Sie aus der Informatik?
White/BlackBox Tests
Unit-Tests, Component-Tests, System-Tests, E2E-Tests
Smoke-Tests

### Erläutern Sie mind. drei Beispiele, die Sie aus der Praxis kennen
e2e - Email-Prozess, welcher an einer Liste von Teilnehmer Einladungen ausschickt.
Blackbox / Exploratory - Bevor wir unser Projekt dem Kunden abgaben, überprüften wir jedes "Modul".
Unit - JUnit Test für einen längeren Berechnungs-Schritt

### Wie werden die Tests durchgeführt?
Pipeline bevor dem Mergen von feature Branch in master.
Und bevor jemand seine Veränderungen Pushed in seinen Feature Branch (Wurde nicht immer eingehalten).


## 2 
### Nennen Sie ein Beispiel eines SW-Fehlers und eines SW-Mangels.
#### Fehler
Beim erstellen eines Users wird ihm standartmässig die Rolle "ADMIN" zugeteilt.

#### Mangel
Beim Erstellen eines Users mit der Rolle "USER" wird im Frontend die Rolle "ADMIN" dargestellt.

### Nennen Sie ein Beispiel für einen hohen Schaden bei einem SW-Fehler.
`Beim erstellen eines Users wird ihm standartmässig die Rolle "ADMIN" zugeteilt.`
-> Beim Release können neue User auf alles zugreifen, vor allem auf interne Dokumente und auf das Bank-System.

## 3
Eine Software gliedert sich in der Regel in eine Reihe von Teilsystemen, die wiederum aus einer Vielzahl elementarer
Komponenten besteht. Wir haben im V-Modell gesehen, dass es verschiedene Teststufen gibt. Wir wollen in diesem
Zusammenhang nun ein Beispiel der untersten Stufe anschauen.

### Beispiel Test in der Klasse Preisberechnung
// Siehe Code
Es besteht ein Grundpreis (baseprice),
abzüglich Händlerrabatt (discount).
Dazu kommen Sondermodellaufschlag (specialprice)
und der Preis für weitere Zusatzaustattungen (extraprice).
Wenn drei oder mehr Zusatzausstattungen ausgewählt (extras)

werden, dann erfolgt ein Rabatt von 10% auf diesen Ausstattungen. Wenn es fünf oder mehr Zusatzausstattungen sind, dann ist der Rabatt bei 15%. Der Händlerrabatt bezieht sich auf den Grundpreis.
Der Zubehörrabatt gilt nur für den Preis der Zubehörteile


### Bonus
`
if (discount > addon_discount)
    addon_discount = discount;
`
Discount betrifft nur Grundpreiss.
