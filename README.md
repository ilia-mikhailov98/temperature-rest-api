# Temperature REST API

Этот проект представляет собой простой REST API для управления температурой. Он позволяет пользователям регистрировать сенсоры и хранить собранных с них данные о температуре и погоде.

## Требования

Для запуска проекта понадобятся:

- Java 11 или выше
- Docker

## Установка

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/ilia-mikhailov98/temperature-rest-api.git
   cd temperature-rest-api
   ```
3. Настройте подключение к базе данных в файле `docker-compose.yml`.

5. Запустите приложение:

   ```bash
   docker-compose up --build
   ```

   API будет доступен по адресу `http://localhost:8080`.

## Эндпоинты API

### Базовый URL

`http://localhost:8080`

### Эндпоинты

1. **Зарегистрировать новый сенсор**
   - **POST** `/sensors/registration`
   - Тело запроса:
     ```json
     {
       "name": "near_house"
     }
     ```
   - Ответ: статус 200.
2. **Список всех измерений**
   - **GET** `/measurements`
   - Ответ: Список всех записей о температуре в формате:
     ```json
     [{
        "value": 30,
        "raining": false,
        "sensor": {
           "name": "near_house"
        }
     }]
     ```

3. **Добавить новое измерение**
   - **POST** `/measurements/add`
   - Тело запроса:
     ```json
     {
        "value": 30,
        "raining": false,
        "sensor": {
           "name": "near_house"
        }
     }
     ```
   - Ответ: статус 200.

4. **Общее количество дождливых дней**
   - **GET** `/measurements/rainyDaysCount`
   - Ответ: Количество дождливых дней.
