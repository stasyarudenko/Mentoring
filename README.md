# Mentoring

    // ToDo ------------- HOMETASK 01

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


    // ToDo --------------- HOMETASK 02

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
    // DONE. lorem ipsum - email text заменить используя рандомный тест
    // понять, как инициализируется драйвер и как исп
    // UNIX!!!!!!
    // DONE. Методы пейджи не должны быть статик - каждый объект пейджи нужно создавать, и после этого использовать его методы

    - зайти на google.com
    - вбить в поиск Selenium
    - проверить, что на странице 10 результатов и первый из них - https://www.seleniumhq.org
    - перейти по ссылке на https://www.seleniumhq.org
    - проверить что тайтл соответствует нужному сайту


    // ToDo ---------------- 19/09 HOMETASK 03

    1. DONE. убрать все вейтеры с базовой страницы, заменить на вейтер, который принимает Expected condition и возвращает элемент/лист элементов,
    2. DONE. вынести инициализацию страниц в тестовых методах из тестов выше в тестовый класс
    3. DONE. в тесте гмейла поменять структуру - добавить вход в ящик по навигационному меню гугла
    4. DONE. пересмотреть локаторы - заменить на привязку к айди/класснейму
    5. почитать про способы генерации рандомных данных (для авторизации/создания пользователя)
    6. почитать про генерики из ссылок Useful Links
    7. DONE. найти 3 способа WebDriver нажатия на элемент:
        - element.click;
        - element.submit;
        - element.sendKeys(Keys.ENTER) / element.sendKeys(Keys.RETURN);
        - с помощью JavaScript;
        - с помощью класса Actions (http://qaru.site/questions/11531877/how-many-ways-to-click-on-webelement-in-webdriver);
    8. DONE. UNIX
    9. DONE. Видео по Git
    10. DONE. Atom - скачать текстовый редактор


    // ToDo ----------------- 26/09 HOMETASK 04

    1. https://www.kieskeurig.nl/:
    - зарегать юзера на сайте
    - из почты нажать на конфирмейшн линк
    - залогиниться и проверить имя юзера
    - имя юзера и имейл - уникальныe
    - использовать алиас для гмейл ящика - чтоб на один имейл приходили письма со всех

    2. Theory: Exceptions
    3. Null pointer - почему плохо возвращать и как отлавливать - способы
    4. DONE. Actions - использовать

    дженериками могут быть: метод, класс, переменная, интерфейс


    // ToDo ----------------- 3/10 HOMETASK 05

    1. DONE. разнести тестовые классы по пакетам - гмейл и гугл - отдельно, кишкюрик - отдельно
    2. DONE. для кишкюрика сделать свою базовую страницу (базовый тест класс оставить как есть)
    3. ToDo создать общий базовый финальный класс ConciseAPI - со статическими методами
    4. DONE. добавить генерилку для имени - депенденси фейкер
    5. оптимизировать локаторы для кишкюрика ----- речь о попапе регистрации/логина на кишкюрике
    6. Exceptions - try-catch-finally
    7. лямбды, стримы, функциональные интерфейсы (пока на 4 остановимся: Function, Consumer, Supplier, Predicate)
       Happy Learning - !!!!!!

    - заходим на https://www.kieskeurig.nl
    - выбираем категорию "телефоны"
    - клапаем на вкладку sorting opt
    - сортировать по цене по убыванию
    - проверить, что все элементы отсортированы по убыванию - проскроллить до конца, пока все телефоны появятся
    - добавить еще один похожий тест, только будут стиралки, по рейтингу (от высшего к низкому)
    - ToDo проверить названия методов и переменных
    - ToDo убрать повтор по сортировке - сделать один универсальный метод вместо двух


    // ToDo ----------------- 29/10 HOMETASK 06

    - fillInputWithText - убрать с базовой страницы, так как это не кор метод
    - переименовать kieskeurig страницы - убрать kieskeurig из названия классов, чтоб не дублировалось
    - сделать на базовой странице Actions статиком, так как инициализация
    - разнести на два отдельных метода chooseSortingByPriceDescendingAndWaitForResultsToLoad() - выбрать фильтр и подожать
    - поменять локатор для фильтра chooseSortingByPriceDescendingAndWaitForResultsToLoad - привязаться к имени лейбы,
        так как других языков не используется в приложении
    - вынести JavascriptExecutor js = (JavascriptExecutor) getDriver(); на кор страницу, сделать статиком
    - manage to run tests via mvn
    - add plugin from skype
    - iterm2 - поставить плагин
    - git: log, status, как получить хеши коммитов, reflog
    - unix commands
    - сделать два сьюта - смоук для гугла (серч фор селениум) остальные - в регрессионный сьют (сьют ранится через идею и через мавен)
        junit5 - how to create test suites

