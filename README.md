# mongodb-spring-boot
- curl --location --request POST 'http://localhost:8080/users' \
--data-raw '{"id":3, "name":"Ann","salary":8000}'

- curl --location --request PUT 'http://localhost:8080/users/3' \
--data-raw '{"name":"Ann How","salary":8000}'

- GET http://localhost:8080/users
- GET http://localhost:8080/users/3
- curl --location --request DELETE 'http://localhost:8080/users/3'

# mac user (mongodb setup)
- install brew (`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`)
- brew update or brew upgrade
- brew tap mongodb/brew
- brew install mongodb-community@5.0
- brew —prefix ##to see installation path
- brew services start mongodb-community@5.0 (it will start mongodb)
- brew services stop mongodb-community@5.0 (it will stop mongodb)
- Start mongodb `brew services start mongodb-community@5.0`
- Run commond in terminal `mongosh` it will display logs for host port(e.g mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000) and let you inside mongodb default database `test>` where you can query
- now you can use host `127.0.0.1` and port `27017` to connect with application (see application.properties)


# Overview of mongodb


create databse
> use user

show database(new created will not show until have a record)
show database
> show dbs

drop database
> use user <br/>
> db.dropDatabase()

 create collection (if you insert record in collection which is not exist mongodb create it
> db.createCollection(“users”)

show collection 
> show collections

insert record
> db.users.insertOne({"id":2,"name":"Raj", “salary":15000})

Drop collection
> db.users.drop()

Query (return all)
> db.users.find().pretty() <br/> 

Query first <br/>
>db.users.findOne()  <br/>

Condition <br/>
>db.users.find({"id":2}) <br/>

Condition AND
> db.users.find({ $and: [ {"id":2}, {“name":"Raj"}]})

Condition OR
> db.users.find({ $or: [ {"id":2}, {"name":"Ram"}]})

Condition greater than
> db.users.find({“salary":{$gt:9000}})

Condition NOT & LessThan
> db.users.find({ "salary": {$not: {$lt: 10000}}})

Update
> db.users.updateOne({‘id':2},{$set:{'name':'Prince'}})

Find and Update
> db.users.findOneAndUpdate({id: 2},{ $set: { 'salary':8000,'name': ‘Winson’}})

Remove all document
> db.users.remove({})

Remove specific document
> db.users.remove({‘name':'Winson'})

Limit
> db.users.find().limit(1)

Sort 1(asc) -1 (desc)
> db.users.find().sort({“name":-1})

Create index
> db.users.createIndex({"name":1})

Drop index
>db.users.dropIndex({“name":1})

Agregate
> db.users.aggregate([{$group : {_id : "$name", total_name_users : {$sum : 1}}}])

MongoDB datatype(many, few is below): <br/>
> Integer, String, Boolean, Double, Array, Timestamp, Object, Null, Symbol, Date, Regular Expression, Code etc


