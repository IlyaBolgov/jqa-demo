# jqa-demo
Репозиторий с небольшой логикой и тестами на Java и Kotlin разных уровней для демонстрации навыков работы на этих языках.

## Обзор

### Java

- Spring-приложение, которое использует Open API для генерации Swagger. Под капотом логика, имитирующая
примитивное банковское приложение, которое взаимодействует со счетами. 
- Utils и Async: там есть не использующиеся напрямую в контроллерах классы Калькулятора, а также немного асинхронщины.
Идейно реализовано для того, чтобы показать работу с асинхронщиной и увязать Java и Kotlin.
- Тесты. Есть unit-тесты, которые покрывают написанную логику + интеграционный тест для проверки связи синхронного и
асинхронного варианты реализации.

### Kotlin

- Utils и Async: цель та же, что в и Java, только отличается логика и методы.
- Unit-тесты. Проверяют логику Utils и Async
- API-тесты. На основе открытого API и Rest Assured реализованы тесты, которые проверяют вызовы по REST

Кроме того, подключена выгрузка в Allure и возможность запускать интеграционные тесты отдельно от остальных.