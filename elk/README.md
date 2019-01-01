# ELK Stack

## learning ELK stack

###  Elastic search 

#### Elastic search concept 

* Data Flow in Elastic search 
	![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/1.png)

* Elastic search Structure
	![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/3.png)

#### Elastic search vs Relation DB

![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/2.png)
![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/4.png)
![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/5.png)
![GitHub Logo](https://byungjun0689.github.io/src/201708/basic/concept/6.png)

#### CRUD using elastic search

* Get Index in elastic search
	- curl -XGET http://localhost:9200/[index name]
	- curl -XGET http://localhost:9200/[index name]?pretty 
```
//no index situation.
{
  "error" : {
    "root_cause" : [
      {
        "type" : "index_not_found_exception",
        "reason" : "no such index",
        "resource.type" : "index_or_alias",
        "resource.id" : "classes",
        "index_uuid" : "_na_",
        "index" : "classes"
      }
    ],
    "type" : "index_not_found_exception",
    "reason" : "no such index",
    "resource.type" : "index_or_alias",
    "resource.id" : "classes",
    "index_uuid" : "_na_",
    "index" : "classes"
  },
  "status" : 404
}
```
* Create Index
	- curl -XPUT http://localhost:9200/[index name]
```
{
	"acknowledged":true,
	"shards_acknowledged":true,
	"index":"classes"
}
```
```
//after create index
{
  "classes" : {
    "aliases" : { },
    "mappings" : { },
    "settings" : {
      "index" : {
        "creation_date" : "1545689783836",
        "number_of_shards" : "5",
        "number_of_replicas" : "1",
        "uuid" : "IwaghTZ-S62Tq0AX871aSg",
        "version" : {
          "created" : "5061499"
        },
        "provided_name" : "classes"
      }
    }
  }
}
```

* Delete index
	- curl -XDELETE http://localhost:9200/[index name]
```
{
  "acknowledged" : true
}
```

* Create Document
	- curl -XPOST http://localhost:9200/classes/class/2/?pretty -d '{"title" : "algorithm","professor" : "John"}'
```
{
  "_index" : "classes",
  "_type" : "class",
  "_id" : "1",
  "_version" : 2,
  "result" : "updated",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "created" : false
}
```
	- curl -XPOST http://localhost:9200/classes/class/1/?pretty -d @oneclass.json(you can use file too)

* Update Document
	- curl -XPOST http://localhost:9200/classes/class/2/?pretty -d '{"title" : "algorithm","professor" : "John1"}'
```	
{
  "_index" : "classes",
  "_type" : "class",
  "_id" : "2",
  "_version" : 2,
  "result" : "updated",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "created" : false
}
```
* Update Document like programmatically
	- curl -XPOST http://localhost:9200/classes/class/3/?pretty -d '{"add":1}'
	- curl -XPOST http://localhost:9200/classes/class/3/_update?pretty -d '{"script" : "ctx._source.add += 5"}'
	
```
//add 1
{
  "_index" : "classes",
  "_type" : "class",
  "_id" : "3",
  "_version" : 3,
  "found" : true,
  "_source" : {
    "add" : 1
  }
}
//after adding programmatically
{
  "_index" : "classes",
  "_type" : "class",
  "_id" : "3",
  "_version" : 4,
  "found" : true,
  "_source" : {
    "add" : 6
  }
}
```

* Create bulk file
	- curl -XPOST http://localhost:9200/_bulk?pretty - -data-binary @classes.json

* Create Mapping
	- curl -XPUT http://localhost:9200/classes/class/_mapping -d @classesRating_maping.json
```
//before
{
  "classes" : {
    "aliases" : { },
    "mappings" : { },
    "settings" : {
      "index" : {
        "creation_date" : "1545694104056",
        "number_of_shards" : "5",
        "number_of_replicas" : "1",
        "uuid" : "e4UAqKMlQvWruhKiN0MLUA",
        "version" : {
          "created" : "5061499"
        },
        "provided_name" : "classes"
      }
    }
  }
}
//after
{
  "classes" : {
    "aliases" : { },
    "mappings" : {
      "class" : {
        "properties" : {
          "major" : {
            "type" : "text"
          },
          "professor" : {
            "type" : "text"
          },
          "rating" : {
            "type" : "integer"
          },
          "school_location" : {
            "type" : "geo_point"
          },
          "semester" : {
            "type" : "text"
          },
          "student_count" : {
            "type" : "integer"
          },
          "submit_date" : {
            "type" : "date",
            "format" : "yyyy-MM-dd"
          },
          "title" : {
            "type" : "text"
          },
          "unit" : {
            "type" : "integer"
          }
        }
      }
    },
    "settings" : {
      "index" : {
        "creation_date" : "1545694104056",
        "number_of_shards" : "5",
        "number_of_replicas" : "1",
        "uuid" : "e4UAqKMlQvWruhKiN0MLUA",
        "version" : {
          "created" : "5061499"
        },
        "provided_name" : "classes"
      }
    }
  }
}
```

* Search in document
	- curl -XGET localhost:9200/basketball/record/_search?pretty
	- curl -XGET 'localhost:9200/basketball/record/_search?q=points:30&pretty'
	- curl -XGET localhost:9200/basketball/record/_search?pretty -d '{"query":{"term":{"points":20}}}'
	
#### Aggregations elastic search

## Reference
- https://byungjun0689.github.io/1.Elasticsearch/



