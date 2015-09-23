<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    <div ng-app="myApp" ng-controller="myController">
    	<input type="text" ng-model="user">
    	<input type="button" ng-click="login()">
    </div>
</body>
<script>
	var app=angular.module('myApp',[]);
	app.controller("myController",function($scope,$http)
			{
				alert('in controller');
				$scope.login=function(){
					var url="webapi/myresource/"+$scope.user;
					alert('in login func');
					$http.get(url).success(function(response){
						alert(response);	
						
					}).error(function(response){
						alert('error');	
						
					});
				}
			});
</script>
</html>
