Manual Camunda
https://docs.camunda.org/manual/7.18/
https://camunda.com/bpmn/reference/
https://docs.camunda.org/manual/7.11/user-guide/process-engine/database/#database-configuration
https://camunda.com/blog/2015/08/start-and-complete-process-with-rest-api/
https://docs.camunda.org/rest/camunda-bpm-platform/7.19-SNAPSHOT/#tag/Task/operation/handleEscalation



>curl --location --request POST 'http://localhost:8080/engine-rest/process-definition/key/personal-message/start' --header 'Content-Type: application/json' --data-raw '{
>      "variables": {
>          "personal-message": {
>              "value": "Hello World !!!",
>              "type": "String"
>         }
>     }
> }'