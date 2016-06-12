
angular.module('myApp', [
    'ngTable',
    'ngAnimate',
    'angular-jwt',
    'ui.bootstrap'
])
        .controller('myCtrl', function ($http, $scope, NgTableParams) {
            $scope.calculate = function () {
                $http({method: 'GET',
                    Access: "http://exam-safevand.rhcloud.com/epReSTandJSON/",
                    Control: "http://exam-safevand.rhcloud.com/epReSTandJSON/",
                    Allow: "http://exam-safevand.rhcloud.com/epReSTandJSON/",
                    Origin:"http://exam-safevand.rhcloud.com/epReSTandJSON/",
//                    Access-Control-Allow-Origin: "http://exam-safevand.rhcloud.com/epReSTandJSON/",
                    url: "api/addresses/" + $scope.num + "/" + $scope.props
                     
                }).then(function(response){
                     var data = response.data;
                     
                    $scope.tableParams = new NgTableParams({page: 1, count: 10}, {dataset: data});
                });
            };

        });