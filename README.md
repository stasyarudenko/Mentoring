# Mentoring

    // ToDo:

    // ------------- HOMETASK 01
    // naming convenction - java package naming, interface, methods, test methods,
    // page object
    // DONE. тестовые методы заканчиваются на слово Test
    // DONE. test class name - ...Test -->
    // DONE. Web Driver Manager -- удалить папку с драйверами
    // DONE. JUnit --> 5 вместо 4
    // readbility -- clean code
    // DONE. browser.quit instead of .close
    // DONE. before, after --> beforeClass, AfterClass вынести в отд класс
    // DONE. selenium - как знает, что страница прогрузилась: document.readyState = complete
    // DONE. сделать проще тест - логин и пароль
    // commit from текущей бранчи с фичей вмерджить в другую бранчу с фичей - cherry peak
    // git HEAD, git revert, git reset
    // UNIX - terminal
    // DONE. gitignore - добавить в гитигнор чтоб не коммитился
    // DONE. .gitignore - сгенерить и убрать лишнее


    // --------------- HOMETASK 02

    // DONE. заменить в локаторах " на ' - убрать экранирование
    // DONE. subject = "" - заменить проверку
    // DONE. поменять названия элементов из фреймворка, чтоб соответствовали названиям на странице
    // DONE. клик на инбокс заменить на клик по рефрешу
    // DONE. assert 1 - письмо первое в списке - решили оставить как есть
    // DONE. assert 2 - что сабджект совпадает
    // DONE. спрятать driver.get("http://gmail.com/"); и остальное под капот на бейс пейдж
    // DONE. метод начинается на тест, классы - заканчиваются
    // DONE. изменения делать в отдельной бранче --> пулл реквест
    // DONE. wait - SECONDS - добавить переменную времени ожидания и конфигуражить ее - Duration - TIMEOUT was added to Configuration
    // selenium selenoid - дефолтные значения для времени ожидания (явного неявного)
    // DONE. посмотреть изменения из ветки Миши
    // почитать по гиту (на гугл доке)
    // lorem ipsum - email text заменить --------- используя рандомный тест
    // понять, как инициализируется драйвер и как исп
    // UNIX!!!!!!
    // DONE. Методы пейджи не должны быть статик - каждый объект пейджи нужно создавать, и после этого использовать его методы

    - зайти на google.com
    - вбить в поиск Selenium
    - проверить, что на странице 10 результатов и первый из них - https://www.seleniumhq.org
    - перейти по ссылке на https://www.seleniumhq.org
    - проверить что тайтл соответствует нужному сайту


    // ---------------- 19/09 HOMETASK 03

    1. DONE. убрать все вейтеры с базовой страницы, заменить на вейтер, который принимает Expected condition и возвращает элемент/лист элементов,
    2. DONE. вынести инициализацию страниц в тестовых методах из тестов выше в тестовый класс
    3. DONE. в тесте гмейла поменять структуру - добавить вход в ящик по навигационному меню гугла
    4. пересмотреть локаторы - заменить на привязку к айди/класснейму
    5. почитать про способы генерации рандомных данных (для авторизации/создания пользователя)
    6. почитать про генерики из ссылок Useful Links
    7. DONE. найти 3 способа WebDriver нажатия на элемент:
        - element.click;
        - element.submit;
        - element.sendKeys(Keys.ENTER) / element.sendKeys(Keys.RETURN);
        - с помощью JavaScript;
        - с помощью класса Actions (http://qaru.site/questions/11531877/how-many-ways-to-click-on-webelement-in-webdriver);
    8. UNIX
    9. DONE. Видео по Git
    10. DONE. Atom - скачать текстовый редактор
