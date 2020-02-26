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
    3. DONE. создать общий базовый финальный класс ConciseAPI - со статическими методами
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
    - DONE. убрать повтор по сортировке - сделать один универсальный метод вместо двух


    // ToDo ----------------- 29/10 HOMETASK 06

    Practice:
    - DONE. методы fillInputWithText, clickOnElementLocated - убрать с базовой страницы, так как это не кор методы
    - DONE. переименовать kieskeurig страницы - убрать kieskeurig из названия классов, чтоб не дублировалось
    - сделать на базовой странице Actions статик метод, который будет возвращать
    - DONE. разнести на два отдельных метода chooseSortingByPriceDescendingAndWaitForResultsToLoad() - выбрать фильтр и подожать
    - DONE. поменять локатор для фильтра chooseSortingByPriceDescendingAndWaitForResultsToLoad - привязаться к имени лейбы,
        так как других языков не используется в приложении
    - DONE. вынести JavascriptExecutor js = (JavascriptExecutor) getDriver(); на кор страницу, сделать статиком
    - DONE. добавить дополнительный фильтр для тестов сортировки
    - переписать метод loadFullCatalog() - ждать, пока кнопка, к которой скроллить, исчезнет
    - manage to run tests via mvn
    - add plugin from skype
    - iterm2 - поставить плагин
    - сделать два сьюта - смоук для гугла (серч фор селениум) остальные - в регрессионный сьют (сьют ранится через идею и через мавен)
        junit5 - how to create test suites

    Theory:
    - git: log, status, как получить хеши коммитов, reflog
    - unix commands


    // ToDo ------------------- HOMETASK 07

    Practice:
    Есть задание, по кишкюригу - проверить все важные юайные элементы на странице
    1. Залогиниться
    2. На мейн пейдже проверить видимость всех важных елементов
    (определить что важно а что нет остаётся тебе)

    - проверять все элементы из навигационной панели - иначе нету экспектед резалта
    - популярные продукты - также - вопрос: должно отображаться 10? список популярных периодически меняется,
        поэтому решила получать список всех возможных категорий и проверять, что он содержит актуальный список популярных.
        и проверять, что популярных 10
    - поиск - поле серча (сверху и под популярными товарами) - под популярными вижу поле подписки, поля серча нет
    - список категорий - составить список
    - есть вся инфа по компании, агрименты и тп
    - социальные сети


    // ToDo -------------------- HOMETASK 08

    - DONE добавить MainPage для кишкюрига и вынести туда нужные элементы
    - DONE com.mentoring.ui + com.mentoring.com.mentoring.api - добавить пакеты
    - DONE отправить Мише ссылку на тесты из докера от Юли
    - паттерны/антипаттерны в автоматизации, какие используются - билдер паттерн

    API:
    - DONE REST SOAP - чем отличаются
    - DONE клиент-серверная архитектура
    - DONE какие есть методы и что они делают POST PUT GET
    - какие бывают хедеры, типы body
    - DONE авторизация аутентификация: какие бывают токены, как авторизовать пользователя - bearer token ect
    - DONE зачем нужна аутентификация
    - сваггер - что такое, зачем нужен (тулза для документирования). почитать про другие плагины
    - DONE типы кодов, за что отвечают 200/400/500
    - json - почитать (xml)
    - почитать про библиотеки - rest assured, Gson. где используются, что делают
    - DONE apache licence client4
    - liba unirest

новый апи:
    1. выгрести всех юзеров - проверить статус 200
    2. создать своего юзера через пост - проверить статус, что он создался, запомнить его id
    3. с помощью айди выгрести этого пользователя и провалидировать схему
    посмотреть порт
    дочитать про паттерны
    фреймворк - набор инструментов


    // ToDo -------------------- HOMETASK 09

    убрать ненужные депенденси из pom файла
    добавить апи класс на DELETE для списка юзеров - набрасываем тесты кол-во
    вынести апи в отдельный класс и дергать его оттуда
    хитрость: через стринг риплейс можно менять параметры (для джейсона, например) - как через стринг формат


    // ToDo -------------------- HOMETASK 10

    system api --> main
    get/delete/... --> enum
    post put --> добавить метод для риквеста тоже
    перевести все тесты под новые классы
    накидать еще тестов в юзера - про все коллы, не только один эндпоинт
    перенести методы в UserController
    сделать задание данных юзера через генерилку
    добавить в BaseTest afterAll с удалением созданных юзеров тестами (предварительно собирать статическую мапу с их айдишками)
    убрать из BaseTest методы в UserUtils
    в UserUtils добавить логгирование для id
