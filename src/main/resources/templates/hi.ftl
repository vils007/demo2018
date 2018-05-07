<html lang="en" ng-app="AppList">
<head>
    <meta charset="utf-8">
    <title>Events</title>
    <script src="js/lib/angular.min.js"></script>
    <script src="js/app.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/app.css" rel="stylesheet"/>
</head>
<body>
<div ng-controller="ListController">
    <div class="panel-heading"><span class="lead">{{tablename}}</span></div>
    <table class="table table-hover">
        <th>
            <p><input type="text" ng-model="query" placeholder="Such as . . ."></p>
            <button type="button" ng-click="findlist()">Refresh</button>
        </th>
        <th>
            <p>Delete <input type="text" ng-model="fildId" placeholder="delete id"></p>
            <button type="button" ng-click="del(fildId)">Delete</button>
        </th>
        <th>
            <p>Create Event <input type="text" ng-model="description" placeholder="description"></p>
            <button type="button" ng-click="addEvent(description)">Create Event</button>
        </th>
    </table>
    <table class="table table-hover">
        <thead>
        <tr>
            <th><a href="" ng-click="sort('id')">ID
            <#--<i class="glyphicon" ng-class="{'glyphicon-chevron-up' : isSortUp('id'),-->
            <#--'glyphicon-chevron-down' : isSortDown('id')}"></i>-->
            </a></th>
            <th>Description</th>
            <th>Event_Date</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="e in events | orderBy:sortField:reverse | filter:query">
            <td>{{e.id}}</td>
            <td>{{e.description}}</td>
            <td>{{e.eventDt | date:'yyyy/MM/dd'}}</td>
            <td>{{e.type}}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>