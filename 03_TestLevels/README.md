# Aufgaben

## 2
@TestFactory – denotes a method that’s a test factory for dynamic tests
  - -> Dynamische Test Generierung

- @DisplayName – defines a custom display name for a test class or a test method
  - -> Namen Definieren

- @Nested – denotes that the annotated class is a nested, non-static test class
  - -> Grupieren von Tests über Klassen verteilt

- @Tag – declares tags for filtering tests
  - -> Tests Grupieren

- @ExtendWith – registers custom extensions
  - -> Benutzerdefiniertes Logging
  - -> Eigenes Zeit-Messungs Tool

- @BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
  - -> Logging von aktuellem System-Stand

- @AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
  - -> Logging von aktuellem System-Stand

- @BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
  - -> Test-Daten erstellen

- @AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)
  - -> Test-Daten aufräumen

- @Disabled – disables a test class or method (previously @Ignore)
  - -> Alte Tests, welche ersetzt wurden

Referenz-Seite:
https://www.baeldung.com/junit-5


## 3

### Klassenliste

- Bank
- Account
- SalaryAccount
extends Account
- SavingsAccount
extends Account
- PromoYouthSavingsAccount
extends SavingsAccount
- Booking


### Klassen-Util-Listen

- AccountBalanceComparator
- AccountInverseBalanceComparator
- BankUtils

### Verbindungen
- Bank besitzt Accounts (SalaryAccount, SavingsAccount, PromoYouthSavingsAccount)
- Bank benutzt BankUtils für Formatierungen
- Ein Account besitzt Bookings
- AccountInverseBalanceComparator und AccountBalanceComparator werden zum Sortieren gebraucht in der Bank

