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
    
    <ul ng-repeat="data1 in records">
				<li>{{data1.name}}</li>
				<li>{{data1.no}}</li>
			</ul>
		
    
    </div>

<script>
	var app=angular.module('myApp',[]);
	app.controller("myController",function($scope,$http)
			{
				//$scope.records = [] ; 
				alert('in controller');
				$scope.login=function(){
					var url="webapi/myresource/"+$scope.user;
					alert('in login func');
					$http.get(url).success(function(data){
						alert(data);
						console.log(JSON.stringify(data));
						$scope.records = data; 
						//alert($scope.records[0].name);
					    //alert($scope.records[0].no);
						
					}).error(function(data){
						alert('error');	
						
					});
				}
			});
</script>
</body>

</html>
