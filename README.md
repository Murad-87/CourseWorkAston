# CourseWorkAston
# Краткое описание приложения
При открытии работа приложения начинается с открытия Splash screen, который будет показывать логотип нашего приложения.
Приложение простое состоит из трех экранов с нижней навигацией между экранами.
Основной экран с навигацией из трех пунктов - "Персонажи", "Локации", "Эпизоды". Основной экран - "Персонажи".
Каждый экран поддерживает поиск, а также возможность фильтрации по вкладкам.
При нажатии на "Персонаж", "Локации", "Эпизоды" открывается экран с деталями выбранного пункта, на котором представлены детали выбранной вкладки с подробным описанием.
Экран с персонажами отображается в виде таблицы из 2 столбцов и содержит полный список доступных персонажей и информацию по персонажу.
Экран с эпизодами также отображается в виде таблицы из 2 столбцов и содержит список доступных эпизодов и информацию по эпизоду.
Экран с локациями в виде таблицы из 2 столбцов и содержит доступный список локаций и информацию по локации.

# Стек технологий и описание использования данного стека

# Архитектура приложения
Архитектура приложения будет по Clean Architecture. Что позволит нам разделить наше приложение на слои независимые друг от друга. Плюсы данного подхода:
- отделение нашей бизнес-логики от деталей
- легкость при расширении
- легкость тестирования
У нас будет 3 слоя - Presentation, Domain, Data.

# Внедрение зависимостей DI
Для работы с DI будем применять Dagger2.

# База данных
Для работы с базой данных будем использовать библиотеку Room.

# UI слой
Для UI слоя будем использовать архитектуру MVVM.

# Пагинация
Для загрузки части данных за раз будем использовать библиотеку Paging 2.

# REST API 
Вся наша работа с сетью будет строиться на основе библиотеки Retrofit.
Для этого нам понадобиться:
- POJO (Plain Old Java Object) или Model Class - json-ответ от сервера нужно реализовать как модель
- Retrofit - класс для обработки результатов. Ему нужно указать базовый адрес в методе baseUrl()
- Interface - интерфейс для управления адресом, используя команды GET, POST

# Многопоточность
Для решения задач асинхронности и параллельных вычислений будем использовать Kotlin coroutine.

# Картинки
Для работы с картинками будем использовать библиотеку Glide.

# Навигация
Реализация навигации будет с Navigation Architecture Component. Так же будем использовать BottomNavigation для нижней навигации.

# Элементы списка
Для работы со списками будем использовать RecyclerView. Так как наше приложение не имеет функционала для удаления, изменения или добавления элементов в списки
будем использовать обычный Adapter. 
