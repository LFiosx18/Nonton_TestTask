# Nonton_TestTask

## Описание задания

Задание необходимо выполнить на любом C-подобном языке. В задаче нельзя использовать базы данных или любые другие бибилиотеки. В целом вы не ограничены в реализации, только использовать стандартные структуры данных sdk.

Необходимо реализовать все 4 функции в классе ProductsImpl. Реализоцию писать в теле самих функций. Ввы в праве добавлять необходимые вам структуры данных в класс.
```
// структура Product, id - уникальный номер продукта, name - наименование
class Product {
late String id;
late String name;
}

//класс для реализации 4 функций
class ProductsImpl {

//добавляет новый продукт, возвращает true - если продукта с таким id еще не было, возвращает false - если был такой id, вставка отменяется
bool addProduct(Product product) {
//реализация
}

//Удаляет продукт, возвращает true - если продукт с таким id был, возвроащает false - если id не было, (удаления не происходит)
bool deleteProduct(Product product) {
// реализация
}

//Получает имя (name) продукта, возращает name продукта у которого идентификатор равен (=) id, если продукта нет, вернуть пустую строку ""
String getName(String id) {
// реализация
}

//возвращает массив (список) идентификаторов (id), У котрых наименование равно (=) name. Если таких нет, возвращается пустой массив (список)
List findByName(String name) {
//реализация
}
}
```

Данный пример показан на языке dart. Если вы будуте реализовывать на других языка - вы в праве поменять типы на аналогичные в вашей sdk. Но только на аналогичные.

## Особенности реализации

Для хранения всех экземпляров класса `Product` была выбрана коллекция `TreeSet` - данная структура подразумевает автоматическую сортировку объектов. В данном случае объекты сортируются по полю `id` (по возрастанию). Для сравнения объектов класса `Product`, данный класс реализует метод `compareTo` интерфейса `Comparable`

В классе `ProductsImpl` был реализован вспомогательный метод для поиска объекта `Product` по полю `id`. Этот метод используется в `addProduct`, `deleteProduct` и `getName`

Метод `addProduct` реализует добавление объекта `Product` в общую коллекцию `products`. Данный метод обеспечивает уникальность поля `id`, а также обработку некорректных данных (отрицательное поле `id` и пустое значение `name`)

Метод `deleteProduct` отвечает за удаление элемента из общей коллекции. Так как данный метод по заданию должен принимать аргумент типа `Product`, процесс наождения удаляемого элемента происходит не только по полю `id`, но и по полю `name`. Это сделано для того, чтобы случайно не удалить не тот элемент.

Например, в коллекции находится один элемент `Product (id=5, name="Milk")`, при вызове метода `products.deleteProduct(new Product(5, "Tea"))` будет удалён этот единственный элемент коллекции, если производить поиск только по полю `id` (id элементов совпадают, но name - нет). Чтобы исключить такие ситуации, было предусмотрено добавочное сравнение полей `name`

Также для удобства тестирования были разработаны юнит-тесты с использованием библиотеки JUnit5.
