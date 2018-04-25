var appList = angular.module('AppList',[]);
    appList.controller('ListController',['$scope','$http','$location',function ($scope,$http) {
        $http.get('event').success(function (data,status) {
            $scope.events = data;
        })
        $scope.tablename = 'List of Events!!!';

        $scope.sortField = undefined;
        $scope.reverse = false;

        $scope.sort = function (fieldName) {
            if ($scope.sortField === fieldName) {
                $scope.reverse = !$scope.reverse;
            } else {
                $scope.sortField = fieldName;
                $scope.reverse = false;
            }
        };

        $scope.isSortUp = function (fieldName) {
            return $scope.sortField === fieldName && !$scope.reverse;
        };
        $scope.isSortDown = function (fieldName) {
            return $scope.sortField === fieldName && $scope.reverse;
        };



        // $scope.events = [
        //     {"id":76,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:39.000+0000"},
        //     {"id":75,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:34.000+0000"},
        //     {"id":74,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:29.000+0000"},
        //     {"id":73,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:24.000+0000"},
        //     {"id":72,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:19.000+0000"},
        //     {"id":71,"type":"scheduler","description":"Task event fix rate = 5000","eventDt":"2018-04-13T09:37:14.000+0000"}
        // ];
    }]);
