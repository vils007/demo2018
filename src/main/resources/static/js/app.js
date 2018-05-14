var appList = angular.module('AppList', []);
appList.controller('ListController', function ($scope, $http, $timeout) {
    $scope.findlist = function () {
        $timeout($http.get('event').success(function (data, status) {
            $scope.events = data;
        }),100);
    };
    $scope.findlist();
    $scope.tablename = 'List of Events!!!';

    $scope.sortField = undefined;
    $scope.reverse = false;
    $scope.fildId = null;
    $scope.description = null;

    $scope.del = function (fildId) {
      $http.delete('delete/' + fildId);
        setTimeout(function() {
            $scope.findlist();
            $scope.$apply(); //this triggers a $digest
        }, 500);
    };
    $scope.addEvent = function (description) {
        $http.post('event', description);
        setTimeout(function() {
            $scope.findlist();
            $scope.$apply(); //this triggers a $digest
        }, 500);
    };

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
});