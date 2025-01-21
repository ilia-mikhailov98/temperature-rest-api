# Temperature REST API

Этот проект представляет собой простой REST API для управления температурой. Он позволяет пользователям выполнять основные операции CRUD для записей о температуре.

## Требования

Для запуска проекта понадобятся:

- Java 11 или выше
- Реляционная база данных (например, MySQL, PostgreSQL)

## Установка

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/ilia-mikhailov98/temperature-rest-api.git
   cd temperature-rest-api
   ```

2. Соберите проект с помощью Maven:

   ```bash
   mvn clean install
   ```

3. Настройте подключение к базе данных в файле `src/main/resources/application.properties`. Пример:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/temperature_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   spring.jpa.hibernate.ddl-auto=update
   ```

4. Запустите приложение:

   ```bash
   mvn spring-boot:run
   ```

   API будет доступен по адресу `http://localhost:8080`.

## Эндпоинты API

### Базовый URL

`http://localhost:8080/api/v1/temperature`

### Эндпоинты

1. **Получить все записи о температуре**
   - **GET** `/`
   - Ответ: Список всех записей о температуре.

2. **Получить запись о температуре по ID**
   - **GET** `/{id}`
   - Параметры:
     - `id`: ID записи о температуре.
   - Ответ: Одна запись о температуре.

3. **Создать новую запись о температуре**
   - **POST** `/`
   - Тело запроса:
     ```json
     {
       "value": 25.5,
       "unit": "C",
       "timestamp": "2025-01-21T15:00:00"
     }
     ```
   - Ответ: Созданная запись о температуре.

4. **Обновить существующую запись о температуре**
   - **PUT** `/{id}`
   - Параметры:
     - `id`: ID записи о температуре.
   - Тело запроса:
     ```json
     {
       "value": 30.0,
       "unit": "F",
       "timestamp": "2025-01-22T10:30:00"
     }
     ```
   - Ответ: Обновленная запись о температуре.

5. **Удалить запись о температуре**
   - **DELETE** `/{id}`
   - Параметры:
     - `id`: ID записи о температуре.
   - Ответ: Сообщение об успехе или ошибке.
