### Тестирование приложения "Мобильный хоспис" ("Вхосписе")

### **Описание приложения**

Приложение даёт функционал по работе с новостями хосписа и включает в себя:

* информацию о новостях и функционал для работы с ними;
* тематические цитаты;
* информацию о приложении.

### **Функционал приложения**

1. Страница авторизации
   * поле login
   * поле password
   * кнопка "Sign in"

2. Главная страница:
    * меню:
        * "Main" (главная страница);
        * "News" (новостная лента);
        * "About" (информация о приложении);
    * раздел с тематическими цитатами;
    * кнопка "logout" - выход из учётной записи;
    * кнопка "All news" для перехода в раздел "News".
3. Страница "News":
    * сортировка;
    * фильтр;
    * редактирование:
        * сортировка;
        * фильтр;
        * добавление новой новости;
        * сворачивание/разворачивание новости.
4. О приложении:
    * ссылка на политику конфиденциальности;
    * ссылка на условия использования.

## **Тестовые данные**
* Данные для авторизации:
`login2;`  
`password2.`

## **Стратегия тестирования**

**Цель:**
* проведение функционального исследовательского тестированиея и UI-тестирования функционала приложения для проверки работоспособности приложения и удобства интерфейса для пользователей.  

**Этапы:**
* исследование приложения;
* составление чек-листа;
* составление тест-кейсов;
* автоматизация тестов;
* составление отчета.

**Проверяемый функционал:**
* Авторизация и логаут пользователя;
* Работа с опубликованными новостями;
* Добавление новой новости;
* Просмотр тематических цитат;
* Просмотр информации о приложении.
  
**Автоматизация тестов:**
* Авторизация с корректными данными (id 1);
* Логаут пользователя (id 2);
* Авторизация с некорректным логином и корректным паролем (id 3);
* Авторизация с корректным логином и некорректным паролем (id 4);
* Авторизация с незаполненными полями Логин и Пароль (id 7);
* Добавление новой новости (id 8);
* Фильтрация новостей (id 9);
* Разворачивание цитаты (id 16);
* Переход по ссылке /privacy-policy для просмотра политики конфиденциальности (id 17);
* Переход по ссылке /terms-of-use для просмотра условий использования (id 18);
* Создание новости с пустыми полями (id 19).


## **Используемые инструменты**

* **Android Studio** - запуск приложения, написание и запуск тестов
* **Espresso** - написание автотестов
* **Allure** - создание отчета
* **Эмулятор Android API30** - установка и работа с приложением


## **Оценка времени на выполнение работы**
* Проведение ручного тестирование и написание плана - 6 часов
* Составление чек-листа - 5 часов
* Написание тест-кейсов - 20 часов
* Создание автотестов - 150 часов