show dbs

use admin // переключиться на бд или создать бд если ее нет

use school // создание базы данных

db.createCollection("students") // создать коллекцию

db.dropDatabase() // удалить используемую базу данных

db.students.insertOne({name: "Artem", age: 18, gpa: 4.8}) // вставить запись

db.students.find() // достать все записи колллекции

db.students.insertMany
([
    {name: "Mishka", age: 18, gpa: 4.8},
    {name: "Sonya", age: 18, gpa: 4.8},
    {name: "Anton", age: 18, gpa: 4.8}
]) // вставить много записей

db.students.insertOne(
    {
        name: "Artem",
        age: 18,
        gpa: 4.8,
        fullTime: false,
        registerDate: new Date("2023-01-02T00:00:00"), // при пустом конструкторе даты вставится дата, когда заапись была внесена
        graduationDate: null,
        courses: [
            "BIOLOGY", "CHEMISTRY", "CALCULUS" // массивы
        ],
        address: {
            street: "123 Fake St.", // вложеннные объекты
            city: "Moscow"
        }
    }
)

db.students.find().sort({name:1}) // сортировка по полю в алфавитном порядке 1, не в алфавитном -1

db.students.find().sort({gpa:1}) // с int также, 1 - в порядке возрастания, -1 - в порядке убывания

db.students.find().limit(1) // лимит документов

db.students.find().sort({gpa: -1}).limit(1) // найти самй большой средний балл

db.students.find({name: "Artem", address: null}) // поиск по полю / нескольким полям

db.students.find({}, {_id: false, name:true}) // второй аргумент - взять только нужные поля ( проекция )

db.students.updateOne({name: "Artem"}, {$set: {fullTime: true}}) // обновить одного: обновит первый попавшийся, поэтому лучше обновлять по айдишнику монги
db.students.updateOne({_id: ObjectId('65d4c553c7cc995610b74888')}, {$set: {fullTime: true}}) // обновление по айдишнику монги

db.students.updateOne({_id: ObjectId('65d4c553c7cc995610b74888')}, {$unset: {fullTime: ''}}) // удалить поле

db.students.updateMany({}, {$set:{fulltime:false}}) // установление поля для всех записей

db.students.deleteOne({name:"Anton"}) // удалить одного

db.students.deleteMany({name:"Artem"}) // удалить много

db.students.deleteMany({registerDate: {$exists: false}}) // удаление записи, если поле registerDate не существует

db.students.find({name: {$ne: "Artem"}}) // удалить все записи, где имя не Artem