<html ng-app "EventManagement">
<head>
    <title>Hello World</title>
    <script src="js/lib/angular.min.js"></script>
    <#--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.js"></script>-->
    <script src="js/app/main.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/add.css" rel="stylesheet" />
</head>

<body  ng-controller="EventController">
<#--<label>Name :</label><input type="text" ng-model="name" placeholder="Enter your name"/>-->
<#--<h1>Hello <span ng-bind="name"></span></h1>-->

<#--<h1>Hey {{name}}</h1>-->

<div class="panel-heading"><span class="lead">List of Events </span></div>
<div class="panel-body">
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Event_Date</th>
                <th>Type</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="e in events">
                <td>{{e.id}}</td>
                <td>{{e.description}}</td>
                <td>{{e.eventDt}}</td>
                <td>{{e.type}}</td>
                <#--<td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>-->
                <#--<td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>-->
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>