<html lang="en" ng-app="AppList">
<head>
    <meta charset="utf-8">
    <title>Events</title>
    <script src="js/lib/angular.min.js"></script>
<#--<script src="js/angular.js"></script>-->
    <script src="js/app.js"></script>
    <link th:href="css/bootstrap.css" rel="stylesheet"/>
    <link th:href="css/add.css" rel="stylesheet"/>
</head>
<body>
<div ng-controller="ListController">
    <div class="panel-heading"><span class="lead">{{tablename}}</span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Event_Date</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="e in events">
            <td>{{e.id}}</td>
            <td>{{e.description}}</td>
            <td>{{e.eventDt}}</td>
            <td>{{e.type}}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>