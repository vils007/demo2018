var appList = angular.module('AppList', []);
appList.controller('ListController', ['$scope', '$http', '$location', function ($scope, $http) {
    $scope.findlist = function () {
        $http.get('event').success(function (data, status) {
            $scope.events = data;
        })
    };
    $scope.findlist();
    $scope.tablename = 'List of Events!!!';

    $scope.sortField = undefined;
    $scope.reverse = false;
    $scope.fildId = null;
    $scope.description = null;

    $scope.del = function (fildId) {
        $http.delete('delete/' + fildId);
        $scope.events = null;
        $scope.findlist();
    };
    $scope.addEvent = function (description) {
        $http.post('event', description);
        $scope.events = null;
        $scope.findlist();
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
}]);