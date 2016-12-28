angular.module('sse', [])
       .controller("productsCtrl", function($scope){

        $scope.products = [];
        $scope.findAll = function(){

            var source = new EventSource('http://localhost:8888/products');

            var handleCallback = function (msg) {
                if ( msg.id == 'close' ) source.close();
                else {
                    console.log(msg);
                    $scope.$apply(function () {
                        $scope.products.push(JSON.parse(msg.data));
                    });
                }
            };

            source.addEventListener('message', handleCallback, false);
        }
});