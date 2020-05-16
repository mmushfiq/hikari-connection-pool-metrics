# hikari-connection-pool-metrics

### Request:
http://localhost:8888/metrics/hikari/connections

### Response:

```
{
   "oracle-pool":{
      "total":20,
      "active":0,
      "idle":20,
      "waiting":0
   },
   "h2-pool":{
      "total":5,
      "active":0,
      "idle":5,
      "waiting":0
   },
   "mysql-pool":{
      "total":10,
      "active":0,
      "idle":10,
      "waiting":0
   }
}
```
