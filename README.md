# Getting Started

### Task
Organization “FarmCollector”  wants to collect information from Farmers for every field for every season, per farm (2 API):

1. Planted:   	
   a. Planting Area (in acres).
   b. Type of crops planted.
   c. Amount of Expected product (in tons)


2. Harvested:
   a. Actual amount of harvested product.
   Organization “FarmCollector”  want to see reports for every season shows expected vs actual amount of product:
    1. For each farm
    2. For each Type of crops


### Setup
To run the application, first setup database and run scripts from the given folder.

#### Database Name 
```devstaff```

#### Database Scripts
Run scripts from the following folder path in the database before running the application.

``` src/main/resources/db-scripts```

#### Default running structure
Application runs on `http://localhost:8080` by default.
Port can be changed from the ```server.port=8080``` property in ``` src/main/resources/application.properties``` 

### Example API

```POST api/harvest/save```
###### Request Body
```json
{
  "field": {
    "id": 1
  },
  "season": "SPRING",
  "cropType": {
    "id": 1
  },
  "actualProductAmount": 150.0
}
```

```GET /api/plantation/{id}```
##### Response 

```json
{
    "field": {
        "id": 1,
        "name": "Field Devstaff West",
        "farm": {
            "id": 1,
            "name": "Farm Devstaff"
        }
    },
    "season": "WINTER",
    "plantingArea": 550.0,
    "cropType": {
        "id": 1,
        "name": "Potato"
    },
    "expectedProductAmount": 500.0
}
```
### For Report

#### By Season
```GET api/report/season/{season}```

#### Response in string

Season : WINTER --- Expected Amount From Plantation : 500.0 --- Actual Amount Harvested : 500.0


### By Field
```GET api/report/field/{id}```

#### Response in string

In Field : Field Devstaff West --- Expected Amount From Plantation : 700.0 --- Actual Amount Harvested : 700.0 in tons

